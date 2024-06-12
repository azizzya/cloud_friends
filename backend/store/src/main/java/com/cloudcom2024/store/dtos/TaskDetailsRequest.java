package com.cloudcom2024.store.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cloudcom2024.store.models.Task;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @NotNull(message = "task deadline musn't be blank")
    @JsonProperty("task_deadline")
    private LocalDateTime taskDeadline;

    @NotNull(message = "coin reward musn't be blank")
    @JsonProperty("coin_reward")
    private BigDecimal coinReward;

    @NotNull(message = "user id musn't be blank")
    @JsonProperty("user_id")
    private Long userID;

    @NotNull(message = "friend id musn't be blank")
    @JsonProperty("friend_id")
    private Long friendID;

    @NotNull(message = "task id musn't be blank")
    @JsonProperty("task_id")
    private Long taskID;

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
