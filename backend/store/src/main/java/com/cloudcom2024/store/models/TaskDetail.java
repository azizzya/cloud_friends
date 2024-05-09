package com.cloudcom2024.store.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tasks_details")
@Data
public class TaskDetail {
    @Id
    @GeneratedValue
    @Column(name = "task_detail_id")
    private long taskDetailId;

    @Column(name = "task_deadline")
    private LocalDateTime taskDeadline;

    @NotNull
    @Column(name = "time_completed")
    private LocalDateTime timeCompletion;

    @NotNull
    @Column(name = "is_done")
    private boolean isDone;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonBackReference
    private Task task;
}