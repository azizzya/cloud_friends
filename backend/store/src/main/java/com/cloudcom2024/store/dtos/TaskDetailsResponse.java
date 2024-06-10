package com.cloudcom2024.store.dtos;

import java.math.BigDecimal;
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

    @JsonProperty("created")
    private LocalDateTime created;

    @JsonProperty("task_deadline")
    private LocalDateTime taskDeadline;

    @JsonProperty("is_done")
    private boolean isDone;

    @JsonProperty("coin_reward")
    private BigDecimal coinReward;

    @JsonProperty("friend")
    private UserResponse friend;

    @JsonProperty("task")
    private TaskResponse task;
}
