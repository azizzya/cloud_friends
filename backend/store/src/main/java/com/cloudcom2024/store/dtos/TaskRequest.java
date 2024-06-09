package com.cloudcom2024.store.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cloudcom2024.store.models.Task;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    public Task convertToTask() {
        return Task.builder()
            .title(title)
            .description(description)
            .build();
    }
}
