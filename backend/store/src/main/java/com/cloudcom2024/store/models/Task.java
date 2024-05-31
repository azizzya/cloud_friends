package com.cloudcom2024.store.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cloudcom2024.store.dtos.TaskResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private long taskId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "coin_reward")
    private BigDecimal coinReward;

    @Column(name = "time_interval_to_complete_task", columnDefinition = "INTERVAL")
    private  LocalDateTime timeIntervalToCompleteTask;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private List<TaskDetails> taskDetails = new ArrayList<>();

    public void setTaskDetail(TaskDetails taskDetail) {
        taskDetails.add(taskDetail);
    }

    public TaskResponse convertToTaskResponse() {
        return TaskResponse.builder()
            .taskId(taskId)
            .title(title)
            .coinReward(coinReward)
            .description(title)
            .build();
    }
}