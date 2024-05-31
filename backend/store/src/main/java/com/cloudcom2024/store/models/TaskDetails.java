package com.cloudcom2024.store.models;

import java.time.LocalDateTime;

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
import lombok.Data;

@Entity
@Table(name = "tasks_details")
@Data
public class TaskDetails {
    @Id
    @GeneratedValue
    @Column(name = "task_details_id")
    private long taskDetailsId;

    @Column(name = "created")
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "is_done")
    private boolean isDone = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private User friend;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public TaskDetailsResponse convertToTaskDetailsResponse() {
        TaskResponse taskResponse = task.convertToTaskResponse();
        UserResponse friendResponse = friend.convertToUserResponse();
        return TaskDetailsResponse.builder()
            .taskDetailsId(taskDetailsId)
            .isDone(isDone)
            .friend(friendResponse)
            .task(taskResponse)
            .build();
    }
}