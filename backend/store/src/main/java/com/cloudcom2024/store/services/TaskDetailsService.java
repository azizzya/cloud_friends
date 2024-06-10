package com.cloudcom2024.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cloudcom2024.store.dtos.TaskDetailsRequest;
import com.cloudcom2024.store.dtos.TaskDetailsResponse;
import com.cloudcom2024.store.exceptions.OnlyOneTaskPerUserAvailableException;
import com.cloudcom2024.store.exceptions.TaskDetailNotFoundException;
import com.cloudcom2024.store.exceptions.TaskNotFoundException;
import com.cloudcom2024.store.exceptions.UserNotFoundException;
import com.cloudcom2024.store.models.Task;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.repositories.TaskDetailsRepository;
import com.cloudcom2024.store.repositories.TaskRepository;
import com.cloudcom2024.store.repositories.UserProfileImageRepository;
import com.cloudcom2024.store.repositories.UserRepository;

@Service
public class TaskDetailsService {
    final private TaskDetailsRepository taskDetailsRepository;
    final private TaskRepository taskRepository;
    final private UserRepository userRepository;

    public TaskDetailsService(
        TaskDetailsRepository taskDetailsRepository,
        TaskRepository taskRepository,
        UserRepository userRepository
    ) {
        this.taskDetailsRepository = taskDetailsRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
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


        checkIfUserExistsByUserID(taskDetailsRequest.getUserID());
        checkIfUserExistsByUserID(taskDetailsRequest.getFriendID());
        checkIfTaskExistsByTaskID(taskDetailsRequest.getTaskID());

        taskDetailsRepository.save(taskDetailsRequest.convertToTaskDetails());
        taskDetailsRepository.save(taskDetailsRequest.swapUserIDAndFriendID().convertToTaskDetails());
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

    //public List<TaskDetailsResponse> getAllTaskDetailsByUsername(String username) {
        ////return userRepository.findUserByUsername(username).get()
            ////.getTaskDetails();
        //List<TaskDetails> tasksDetails = userRepository.findUserByUsername(username).get()
            //.getTaskDetails();
        //List<TaskDetailsResponse> tasksDetailsResponse = new ArrayList<>();
        //for (TaskDetails taskDetails: tasksDetails) {
            //UserProfileImage friendProfileImage = userProfileImageRepository.findImageByUserID(
                //taskDetails.getFriend().getUserID()
            //).get();

            //tasksDetailsResponse.add(taskDetails.convertToTaskDetailsResponse(friendProfileImage.getUserProfileImagePath()));
        //}
        //return tasksDetailsResponse;
        
        ////return userRepository.findUserByUsername(username).get()
            ////.getTaskDetails().stream()
                ////.map(taskDetails -> taskDetails.convertToTaskDetailsResponse(
                    ////userProfileImageRepository.findImageByUserID(taskDetails.getFriend().getUserID())
                ////)).toList();
    //}

    //@Transactional
    //public void setTaskIsDoneForCurrentUserAndFriend(TaskDetailsRequest taskDetailsRequest) {
        //String friendUsername = taskDetailsRequest.getFriendUsername();
        //long currentTaskID = taskDetailsRequest.getTaskID();

        //Optional<User> friendUser = userRepository.findUserByUsername(friendUsername);
        //if (!friendUser.isPresent()) {
            //throw new UserNotFoundException("friend username was not found", friendUsername);
        //}
        //taskDetailsRepository.setTaskDetailIsDoneByUserIDAndTaskID(friendUser.get().getUserID(), currentTaskID);
    //}
}