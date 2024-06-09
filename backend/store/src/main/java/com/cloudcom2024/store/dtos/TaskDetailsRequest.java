package com.cloudcom2024.store.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cloudcom2024.store.models.Task;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDetailsRequest {
    @JsonProperty("task_deadline")
    private LocalDateTime taskDeadline;

    @JsonProperty("coinReward")
    private BigDecimal coinReward;

    @JsonProperty("user_id")
    private long userID;

    @JsonProperty("friend_id")
    private long friendID;

    @JsonProperty("task_id")
    private long taskID;

    //@JsonIgnore
    //private String currentUserUsername;

    //@NotNull(message = "task id musn't be blank")
    //@JsonProperty("task_id")
    //private Long taskID;

    //@NotBlank(message = "friend username musn't be blank")
    //@JsonProperty("friend_username")
    //private String friendUsername;

    public TaskDetails convertToTaskDetails() {
        return TaskDetails.builder()
            .taskDeadline(taskDeadline)
            .coinReward(coinReward)
            .user(new User(userID))
            .friend(new User(friendID))
            .task(new Task(taskID))
            .build();
    }

    public TaskDetailsRequest swapUserIDAndFriendID() {
        return TaskDetailsRequest.builder()
            .taskDeadline(taskDeadline)
            .coinReward(coinReward)
            .userID(friendID)
            .friendID(userID)
            .taskID(taskID)
            .build();
    }
}
