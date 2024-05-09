package com.cloudcom2024.store.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private long taskId;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "coin_reward")
    private BigDecimal coinReward;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<TaskDetail> taskDetails = new ArrayList<>();

    public void setTaskDetail(TaskDetail taskDetail) {
        taskDetails.add(taskDetail);
    }
}