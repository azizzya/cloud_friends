package com.cloudcom2024.store.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcom2024.store.dtos.TaskDetailsRequest;
import com.cloudcom2024.store.dtos.TaskDetailsResponse;
import com.cloudcom2024.store.exceptions.TaskDetailNotFoundException;
import com.cloudcom2024.store.exceptions.UserNotFoundException;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.models.UserProfileImage;
import com.cloudcom2024.store.repositories.TaskDetailsRepository;
import com.cloudcom2024.store.repositories.UserProfileImageRepository;
import com.cloudcom2024.store.repositories.UserRepository;

@Service
public class TaskDetailsService {
    final private TaskDetailsRepository taskDetailsRepository;
    final private UserProfileImageRepository userProfileImageRepository;
    final private UserRepository userRepository;

    public TaskDetailsService(
        TaskDetailsRepository taskDetailsRepository,
        UserProfileImageRepository userProfileImageRepository,
        UserRepository userRepository
    ) {
        this.taskDetailsRepository = taskDetailsRepository;
        this.userProfileImageRepository = userProfileImageRepository;
        this.userRepository = userRepository;
    }

    public void completeTaskByCurrentUserUsernameAndFriendID(String currentUserUsername, long friendID) {
        long currentUserID = userRepository.findUserByUsername(currentUserUsername).get()
            .getUserID();
        taskDetailsRepository.setTaskIsDoneByUserIDAndFriendID(currentUserID, friendID);
        taskDetailsRepository.setTaskIsDoneByUserIDAndFriendID(friendID, currentUserID);
    }

    public void deleteTaskDetailByID(Long taskDetailID) {
        taskDetailsRepository.deleteById(taskDetailID);
    }

    public void createTaskDetails(TaskDetailsRequest taskDetailsRequest) {
        taskDetailsRepository.save(taskDetailsRequest.convertToTaskDetails());
        taskDetailsRepository.save(taskDetailsRequest.swapUserIDAndFriendID().convertToTaskDetails());
    }

    //public List<TaskDetailsResponse> getAllTaskDetailsByUsername(String username) {
        //User user = userRepository.findUserByUsername(username).get();
        //UserProfileImage userProfileImage = userProfileImageRepository.findImageByUserID(user.getUserID()).get();
        //return user.getTaskDetails().stream()
            //.map(taskDetails -> taskDetails.convertToTaskDetailsResponse(userProfileImage.getName()))
            //.toList();
    //}

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