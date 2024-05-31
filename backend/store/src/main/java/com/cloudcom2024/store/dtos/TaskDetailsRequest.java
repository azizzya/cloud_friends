package com.cloudcom2024.store.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String currentUserUsername;

    @NotNull(message = "task id musn't be blank")
    @JsonProperty("task_id")
    private Long taskID;

    @NotBlank(message = "friend username musn't be blank")
    @JsonProperty("friend_username")
    private String friendUsername;
}
