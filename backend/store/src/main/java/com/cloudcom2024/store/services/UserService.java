package com.cloudcom2024.store.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudcom2024.store.dtos.AuthRequest;
import com.cloudcom2024.store.dtos.PersonalityTypeResponse;
import com.cloudcom2024.store.dtos.PersonalityTypeTestRequest;
import com.cloudcom2024.store.dtos.UserResponse;
import com.cloudcom2024.store.exceptions.ListIsNullException;
import com.cloudcom2024.store.exceptions.PersonalityTypeNotFound;
import com.cloudcom2024.store.exceptions.UserAlreadyExistsException;
import com.cloudcom2024.store.exceptions.UserNotFoundException;
import com.cloudcom2024.store.models.PersonalityType;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.models.UserProfileImage;
import com.cloudcom2024.store.repositories.PersonalityTypeRepository;
import com.cloudcom2024.store.repositories.TaskDetailsRepository;
import com.cloudcom2024.store.repositories.TaskRepository;
import com.cloudcom2024.store.repositories.UserProfileImageRepository;
import com.cloudcom2024.store.repositories.UserRepository;
import com.cloudcom2024.store.utils.QRCodeGenerator;

import jakarta.security.auth.message.AuthException;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class UserService {
    final private UserRepository userRepository;
    final private PersonalityTypeRepository personalityTypeRepository;
    final private TaskDetailsRepository taskDetailsRepository;
    final private UserProfileImageRepository userProfileImageRepository;
    final private PasswordEncoder passwordEncoder;

    @Value("qrcode.url.host")
    private String QRCODE_URL_HOST;

    @Value("qrcode.url.port")
    private String QRCODE_URL_PORT;

    public UserService(
        UserRepository userRepository,
        PersonalityTypeRepository personalityTypeRepository,
        TaskDetailsRepository taskDetailsRepository,
        TaskRepository taskRepository,
        UserProfileImageRepository userProfileImageRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.personalityTypeRepository = personalityTypeRepository;
        this.taskDetailsRepository = taskDetailsRepository;
        this.userProfileImageRepository = userProfileImageRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("user with given username already exists", user.getUsername());
        }
        userRepository.save(user);
    }

    public List<UserResponse> getAllUsersSortByCoinBalanceDESCWithLimit100() {
        List<UserResponse> usersResponse = new ArrayList<>();
        List<User> users = userRepository.getAllUsersSortByCoinBalanceDESCWithLimit100();
        for (User user: users) {
            Optional<UserProfileImage> userProfileImage = userProfileImageRepository.findImageByUserID(user.getUserID());
            String userProfileImageName = "";
            if (userProfileImage.isPresent()) {
                userProfileImageName = userProfileImage.get().getName();
            }
            usersResponse.add(user.convertToUserResponse(userProfileImageName));
        }
        
        return usersResponse;
    }

    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username).get();

        long currentUserID = user.getUserID();
        Optional<TaskDetails> taskDetails = taskDetailsRepository.findActiveTaskDetailsByCurrentUserID(currentUserID);
        byte[] qrCode = new byte[]{};
        if (taskDetails.isPresent() && !taskDetails.get().isDone()) {
            //long friendID = taskDetails.get().getFriend().getUserID();
            qrCode = generateQRCodeWithURL(QRCODE_URL_HOST, QRCODE_URL_PORT, currentUserID);
        }

        Optional<UserProfileImage> userProfileImage = userProfileImageRepository.findImageByUserID(user.getUserID());
        String userProfileImageName = "";
        if (userProfileImage.isPresent()) {
            userProfileImageName = userProfileImage.get().getName();
        }

        //Optional<PersonalityTypeResponse> personalityTypeResponse = user.getPersonalityType().convertToPersonalityTypeResponse();
        UserResponse userResponse = UserResponse.builder()
            .userId(user.getUserID())
            .username(username)
            .firstname(user.getFirstname())
            .lastname(user.getLastname())
            .fathername(user.getFathername())
            .profileImageName(userProfileImageName)
            .coinBalance(user.getCoinBalance())
            .roles(user.getRoles())
            .phoneNumber(user.getPhoneNumber())
            .qrCode(qrCode)
            .build();
        PersonalityType personalityType = user.getPersonalityType();
        if (personalityType == null) {
            userResponse.setPersonalityTypeResponse(null);
        } else {
            userResponse.setPersonalityTypeResponse(personalityType.convertToPersonalityTypeResponse());
        }

        return userResponse;
    }

    private byte[] generateQRCodeWithURL(String host, String port, long friend_id) {
        String URL = String.format("http://%s:%d/tasks/complete?friend_id=%s",
            "5.35.86.32", 3000, friend_id);
        byte[] qrCode = null;
        try {
            QRCodeGenerator qrCodeGenerator = new QRCodeGenerator(URL, 320, 320);
            qrCode = qrCodeGenerator.generateByteQRCode();
        } catch (Exception ex) {}
        return qrCode;
    }

    public User authUser(AuthRequest authRequest) throws AuthException {
        Optional<User> user = userRepository.findUserByUsername(authRequest.getUsername());
        if (user.isPresent()) {
            String rawPassword = authRequest.getPassword();
            String encodedPassword = user.get().getPassword();
            if (passwordEncoder.matches(rawPassword, encodedPassword)) {
                return user.get();
            }
        }
        throw new AuthException("authentication failed wrong password or username");
    }

    public PersonalityTypeResponse getPersonalityTypeByUsername(String username) {
        PersonalityType personalityType = userRepository.findUserByUsername(username).get()
            .getPersonalityType();
        if (personalityType == null) {
            return null;
        }
        return personalityType.convertToPersonalityTypeResponse();
    }

    public void setUserPersonality(String username, List<PersonalityTypeTestRequest> personalityTypesTestRequest) {
        String personalityNotFoundIDs = "";
        for (var personalityTypeTestRequest: personalityTypesTestRequest) {
            long personalityID = personalityTypeTestRequest.getPersonalityTypeID();
            Optional<PersonalityType> personalityType = personalityTypeRepository.findById(personalityID);
            if (!personalityType.isPresent()) {
                personalityNotFoundIDs += String.format("%d ", personalityID);
            }
        }
        if (!personalityNotFoundIDs.isEmpty()) {
            throw new PersonalityTypeNotFound("personality type with id %s not found", personalityNotFoundIDs);
        }

        PersonalityTypeTestRequest personalityTypeTestRequest = findPersonalityTypeRequestWithMaxScore(personalityTypesTestRequest);
        long personalityIDWithMaxScore = personalityTypeTestRequest.getPersonalityTypeID();
        User user = userRepository.findUserByUsername(username).get();
        user.setPersonalityType(new PersonalityType(personalityIDWithMaxScore));
        userRepository.save(user);
    }

    private PersonalityTypeTestRequest findPersonalityTypeRequestWithMaxScore(List<PersonalityTypeTestRequest> personalityTypesTestRequest) {
        if (personalityTypesTestRequest == null) {
            throw new ListIsNullException("list of test result is null");            
        }

        log.info(personalityTypesTestRequest);
        PersonalityTypeTestRequest personalityTypeTestRequestWithMaxScore = personalityTypesTestRequest.get(0);
        for (var personalityTypeTestRequest: personalityTypesTestRequest) {
            BigDecimal maxScorePercent = personalityTypeTestRequestWithMaxScore.getScorePercent();
            BigDecimal currentScorePercent = personalityTypeTestRequest.getScorePercent();
            if (maxScorePercent.compareTo(currentScorePercent) == -1) {
                personalityTypeTestRequestWithMaxScore = personalityTypeTestRequest;
            }
        }
        return personalityTypeTestRequestWithMaxScore;
    }
}