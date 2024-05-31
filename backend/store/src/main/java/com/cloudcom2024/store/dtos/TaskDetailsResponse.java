package com.cloudcom2024.store.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDetailsResponse {
    @JsonProperty("task_details_id")
    private long taskDetailsId;

    @JsonProperty("task_deadline")
    private LocalDateTime taskDeadline;

    @JsonProperty("time_completed")
    private LocalDateTime timeCompletion;

    @JsonProperty("is_done")
    private boolean isDone;

    @JsonProperty("friend")
    private UserResponse friend;

    @JsonProperty("task")
    private TaskResponse task;
}
