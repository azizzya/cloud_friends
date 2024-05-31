package com.cloudcom2024.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcom2024.store.dtos.TaskDetailsRequest;
import com.cloudcom2024.store.exceptions.TaskDetailNotFoundException;
import com.cloudcom2024.store.exceptions.UserNotFoundException;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.repositories.TaskDetailsRepository;
import com.cloudcom2024.store.repositories.UserRepository;

@Service
public class TaskDetailsService {
    final private TaskDetailsRepository taskDetailsRepository;
    final private UserRepository userRepository;

    public TaskDetailsService(
        TaskDetailsRepository taskDetailsRepository,
        UserRepository userRepository
    ) {
        this.taskDetailsRepository = taskDetailsRepository;
        this.userRepository = userRepository;
    }

    public void setTaskIsDoneByTaskID(Long taskID) {
        Optional<TaskDetails> task = taskDetailsRepository.findById(taskID);
        if (!task.isPresent()) {
            throw new TaskDetailNotFoundException("task detail not found", taskID);
        }
        taskDetailsRepository.setTaskIsDone(taskID);
    }

    public void deleteTaskDetailByID(Long taskDetailID) {
        taskDetailsRepository.deleteById(taskDetailID);
    }

    public List<TaskDetails> getAllTaskDetailsByUsername(String username) {
        return userRepository.findUserByUsername(username).get()
            .getTaskDetails();
    }

    @Transactional
    public void setTaskIsDoneForCurrentUserAndFriend(TaskDetailsRequest taskDetailsRequest) {
        String friendUsername = taskDetailsRequest.getFriendUsername();
        long currentTaskID = taskDetailsRequest.getTaskID();

        Optional<User> friendUser = userRepository.findUserByUsername(friendUsername);
        if (!friendUser.isPresent()) {
            throw new UserNotFoundException("friend username was not found", friendUsername);
        }
        taskDetailsRepository.setTaskDetailIsDoneByUserIDAndTaskID(friendUser.get().getUserID(), currentTaskID);
    }
}