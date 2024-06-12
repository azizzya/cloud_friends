package com.cloudcom2024.store.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcom2024.store.dtos.TaskDetailsRequest;
import com.cloudcom2024.store.dtos.TaskDetailsResponse;
import com.cloudcom2024.store.exceptions.OnlyOneTaskPerUserAvailableException;
import com.cloudcom2024.store.exceptions.PersonalityTypesOfUserAndFriendAndTaskAreNotEqualException;
import com.cloudcom2024.store.exceptions.TaskDetailNotFoundException;
import com.cloudcom2024.store.exceptions.TaskNotFoundException;
import com.cloudcom2024.store.exceptions.UserNotFoundException;
import com.cloudcom2024.store.models.Tamagotchi;
import com.cloudcom2024.store.models.Task;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.repositories.TamagotchiRepository;
import com.cloudcom2024.store.repositories.TaskDetailsRepository;
import com.cloudcom2024.store.repositories.TaskRepository;
import com.cloudcom2024.store.repositories.UserRepository;

@Service
public class TaskDetailsService {
    final private TaskDetailsRepository taskDetailsRepository;
    final private TaskRepository taskRepository;
    final private UserRepository userRepository;
    final private TamagotchiRepository tamagotchiRepository;

    public TaskDetailsService(
        TaskDetailsRepository taskDetailsRepository,
        TaskRepository taskRepository,
        UserRepository userRepository,
        TamagotchiRepository tamagotchiRepository
    ) {
        this.taskDetailsRepository = taskDetailsRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.tamagotchiRepository = tamagotchiRepository;
    }

    public List<TaskDetailsResponse> getAllTaskDetailsByUsername(String username) {
        return userRepository.findUserByUsername(username).get()
            .getTaskDetails().stream()
                .map(taskDetails -> taskDetails.convertToTaskDetailsResponse(username))
                .toList();
    }

    public void completeTaskByCurrentUserUsernameAndFriendID(String currentUserUsername, long friendID) {
        long currentUserID = userRepository.findUserByUsername(currentUserUsername).get()
            .getUserID();

        Optional<TaskDetails> taskDetails = taskDetailsRepository.findActiveTaskDetailsByCurrentUserIDAndFriendID(currentUserID, friendID);
        if (!taskDetails.isPresent()) {
            throw new TaskDetailNotFoundException("task detail for current user with friend id %d not found", friendID);
        }

        taskDetailsRepository.setTaskIsDoneByUserIDAndFriendID(currentUserID, friendID);
        taskDetailsRepository.setTaskIsDoneByUserIDAndFriendID(friendID, currentUserID);

        User currentUser = userRepository.findById(currentUserID).get();
        User friend = userRepository.findById(friendID).get();

        Tamagotchi currentUserTamagotchi = tamagotchiRepository.findTamagotchiByUserID(currentUserID);
        Tamagotchi friendTamagotchi = tamagotchiRepository.findTamagotchiByUserID(friendID);

        int currentUserBoost = currentUserTamagotchi.getBoost();
        int friendBoost = friendTamagotchi.getBoost();

        BigDecimal currentUserCoinReward = taskDetails.get().getCoinReward().multiply(new BigDecimal(currentUserBoost));
        BigDecimal friendCoinReward = taskDetails.get().getCoinReward().multiply(new BigDecimal(friendBoost));

        BigDecimal currentUserCurrentCoinReward = currentUser.getCoinBalance();
        BigDecimal currentUserCurrentTotalScore = currentUser.getCoinTotalScore();
        currentUser.setCoinBalance(currentUserCurrentCoinReward.add(currentUserCoinReward));
        currentUser.setCoinTotalScore(currentUserCurrentTotalScore.add(currentUserCoinReward));

        BigDecimal friendCurrentCoinReward = friend.getCoinBalance(); 
        BigDecimal friendCurrentTotalScore = friend.getCoinTotalScore();
        friend.setCoinBalance(friendCurrentCoinReward.add(friendCoinReward));
        friend.setCoinTotalScore(friendCurrentTotalScore.add(friendCoinReward));

        userRepository.save(currentUser);
        userRepository.save(friend);

        if (currentUserBoost <= 3) {
            currentUserTamagotchi.setBoost(currentUserBoost + 1);
            tamagotchiRepository.save(currentUserTamagotchi);
        }

        if (friendBoost <= 3) {
            friendTamagotchi.setBoost(friendBoost + 1);
            tamagotchiRepository.save(friendTamagotchi);
        }
    }

    public void deleteTaskDetailByID(Long taskDetailID) {
        taskDetailsRepository.deleteById(taskDetailID);
    }

    public void createTaskDetails(TaskDetailsRequest taskDetailsRequest) {
        long userID = taskDetailsRequest.getUserID();
        long friendID = taskDetailsRequest.getFriendID();
        Optional<TaskDetails> taskDetails = taskDetailsRepository.findActiveTaskDetailsByCurrentUserIDAndFriendID(userID, friendID);
        if (taskDetails.isPresent() && !taskDetails.get().isDone()) {
            throw new OnlyOneTaskPerUserAvailableException("task detail with user %d or %d already exists", userID, friendID);
        }

        User user = taskDetails.get().getUser();
        User friend = taskDetails.get().getFriend();
        Task task = taskDetails.get().getTask();
        checkIfPersonalityTypesOfUserAndFriendAndTaskAreEqual(user, friend, task);

        checkIfUserExistsByUserID(taskDetailsRequest.getUserID());
        checkIfUserExistsByUserID(taskDetailsRequest.getFriendID());
        checkIfTaskExistsByTaskID(taskDetailsRequest.getTaskID());

        taskDetailsRepository.save(taskDetailsRequest.convertToTaskDetails());
        taskDetailsRepository.save(taskDetailsRequest.swapUserIDAndFriendID().convertToTaskDetails());
    }

    private void checkIfPersonalityTypesOfUserAndFriendAndTaskAreEqual(User user, User friend, Task task) {
        long userPersonalityTypeID = user.getPersonalityType().getPersonalityTypeID();
        long friendPersonalityTypeID = friend.getPersonalityType().getPersonalityTypeID();
        long taskPersonalityTypeID = task.getPersonalityType().getPersonalityTypeID();

        if (!(userPersonalityTypeID == friendPersonalityTypeID && friendPersonalityTypeID == taskPersonalityTypeID)) {
            throw new PersonalityTypesOfUserAndFriendAndTaskAreNotEqualException("task with id %d or user with id %d or friend with id %d does not match",
                taskPersonalityTypeID, userPersonalityTypeID, friendPersonalityTypeID);
        }
    }

    private void checkIfUserExistsByUserID(long userID) {
        Optional<User> user = userRepository.findById(userID);
        if (!user.isPresent()) {
            throw new UserNotFoundException("user with id %d not found", userID);
        }
    }

    private void checkIfTaskExistsByTaskID(long taskID) {
        Optional<Task> task = taskRepository.findById(taskID);
        if (!task.isPresent()) {
            throw new TaskNotFoundException("task with id does not exist", taskID);
        }
    }
}