package com.cloudcom2024.store.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudcom2024.store.dtos.AuthRequest;
import com.cloudcom2024.store.dtos.PersonalityTypeResponse;
import com.cloudcom2024.store.dtos.UserResponse;
import com.cloudcom2024.store.exceptions.UserAlreadyExistsException;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.models.UserProfileImage;
import com.cloudcom2024.store.repositories.TaskDetailsRepository;
import com.cloudcom2024.store.repositories.TaskRepository;
import com.cloudcom2024.store.repositories.UserProfileImageRepository;
import com.cloudcom2024.store.repositories.UserRepository;
import com.cloudcom2024.store.utils.QRCodeGenerator;

import jakarta.security.auth.message.AuthException;


@Service
public class UserService {
    final private UserRepository userRepository;
    final private TaskDetailsRepository taskDetailsRepository;
    final private UserProfileImageRepository userProfileImageRepository;
    final private PasswordEncoder passwordEncoder;

    @Value("qrcode.url.host")
    private String QRCODE_URL_HOST;

    @Value("qrcode.url.port")
    private String QRCODE_URL_PORT;

    public UserService(
        UserRepository userRepository,
        TaskDetailsRepository taskDetailsRepository,
        TaskRepository taskRepository,
        UserProfileImageRepository userProfileImageRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
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

        PersonalityTypeResponse personalityTypeResponse = user.getPersonalityType().convertToPersonalityTypeResponse();

        return UserResponse.builder()
            .userId(user.getUserID())
            .username(username)
            .firstname(user.getFirstname())
            .lastname(user.getLastname())
            .fathername(user.getFathername())
            .profileImageName(userProfileImageName)
            .coinBalance(user.getCoinBalance())
            .personalityTypeResponse(personalityTypeResponse)
            .roles(user.getRoles())
            .phoneNumber(user.getPhoneNumber())
            .qrCode(qrCode)
            .build();
    }

    private byte[] generateQRCodeWithURL(String host, String port, long friend_id) {
        String URL = String.format("%s:%d/tasks/details/complete?friend_id=%s",
            "localhost", 8080, friend_id);
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
        PersonalityTypeResponse personalityType = userRepository.findUserByUsername(username).get()
            .getPersonalityType()
            .convertToPersonalityTypeResponse();
        return personalityType;
    }
}