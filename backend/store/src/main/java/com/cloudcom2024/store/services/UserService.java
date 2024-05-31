package com.cloudcom2024.store.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudcom2024.store.dtos.AuthRequest;
import com.cloudcom2024.store.dtos.PersonalityTypeResponse;
import com.cloudcom2024.store.dtos.UserResponse;
import com.cloudcom2024.store.exceptions.UserAlreadyExistsException;
import com.cloudcom2024.store.models.Task;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.repositories.TaskDetailsRepository;
import com.cloudcom2024.store.repositories.TaskRepository;
import com.cloudcom2024.store.repositories.UserRepository;
import com.cloudcom2024.store.utils.QRCodeGenerator;

import jakarta.security.auth.message.AuthException;


@Service
public class UserService {
    final private UserRepository userRepository;
    final private TaskDetailsRepository taskDetailsRepository;
    final private TaskRepository taskRepository;
    final private PasswordEncoder passwordEncoder;

    @Value("qrcode.url.host")
    private String qrCodeURLHost;

    @Value("qrcode.url.port")
    private String qrCodeURLPort;

    public UserService(
        UserRepository userRepository,
        TaskDetailsRepository taskDetailsRepository,
        TaskRepository taskRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.taskDetailsRepository = taskDetailsRepository;
        this.taskRepository = taskRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("user with given username already exists", user.getUsername());
        }
        userRepository.save(user);
    }

    public List<UserResponse> getAllUsersSortByCoinBalanceDESCWithLimit100() {
        return userRepository.getAllUsersSortByCoinBalanceDESCWithLimit100().stream()
            .map(x -> x.convertToUserResponse())
            .collect(Collectors.toList());
    }

    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username).get();

        Task randomAvailableFriendTask = findRandomFriendTaskWithGivenFriendName(username);
        long randomAvailableFriendTaskID = randomAvailableFriendTask.getTaskId();
        byte[] qrCode = generateQRCodeWithURL(qrCodeURLHost, qrCodeURLPort, randomAvailableFriendTaskID, username);

        return UserResponse.builder()
            .userId(user.getUserID())
            .username(username)
            .firstname(user.getFirstname())
            .lastname(user.getLastname())
            .fathername(user.getFathername())
            .coinBalance(user.getCoinBalance())
            .roles(user.getRoles())
            .phoneNumber(user.getPhoneNumber())
            .qrCode(qrCode)
            .build();
    }

    private Task findRandomFriendTaskWithGivenFriendName(String username) {
        List<Task> allTasks = taskRepository.findAll();
        List<TaskDetails> allTaskDetailsByGivenUsername = taskDetailsRepository.findAll().stream()
            .filter(taskDetail -> taskDetail.getFriend() != null)
            .filter(taskDetail -> taskDetail.getFriend().getUsername().contains(username))
            .toList();
        return takeRandomTask(allTasks.stream()
            .filter(friendtask -> friendtask.getTaskDetails().containsAll(allTaskDetailsByGivenUsername))
            .toList());
    }

    private Task takeRandomTask(List<Task> task) {
        Random rand = new Random();
        int randomIndexInGroup = rand.nextInt(task.size());
        return task.get(randomIndexInGroup);
    }

    private byte[] generateQRCodeWithURL(String host, String port, long taskID, String friendUsername) {
        String URL = String.format("%s:%d/tasks/complete?task_id=%d&friend_username=%s",
            "localhost", 5173, taskID, friendUsername);
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