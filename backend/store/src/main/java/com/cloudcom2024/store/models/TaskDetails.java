package com.cloudcom2024.store.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.cloudcom2024.store.dtos.TaskDetailsResponse;
import com.cloudcom2024.store.dtos.TaskResponse;
import com.cloudcom2024.store.dtos.UserResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDetails {
    @Id
    @GeneratedValue
    @Column(name = "task_details_id")
    private long taskDetailsId;

    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "task_deadline")
    private LocalDateTime taskDeadline;

    @Column(name = "is_done")
    private boolean isDone = false;

    @Column(name = "coin_reward")
    private BigDecimal coinReward;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private User friend;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public TaskDetailsResponse convertToTaskDetailsResponse(String userProfileImageName) {
        TaskResponse taskResponse = task.convertToTaskResponse();
        UserResponse friendResponse = friend.convertToUserResponse(userProfileImageName);
        return TaskDetailsResponse.builder()
            .taskDetailsId(taskDetailsId)
            .created(created)
            .taskDeadline(taskDeadline)
            .isDone(isDone)
            .coinReward(coinReward)
            .friend(friendResponse)
            .task(taskResponse)
            .build();
    }
}