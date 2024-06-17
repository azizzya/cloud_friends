package com.cloudcom2024.store.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cloudcom2024.store.models.PersonalityType;
import com.cloudcom2024.store.models.Task;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    @NotEmpty(message = "title musn't be blank")
    @JsonProperty("title")
    private String title;

    @NotEmpty(message = "description musn't be blank")
    @JsonProperty("description")
    private String description;

    @NotEmpty(message = "personality type id musn't be blank")
    @JsonProperty("personality_id")
    private Long personalityTypeID;

    public Task convertToTask() {
        return Task.builder()
            .title(title)
            .description(description)
            .personalityType(new PersonalityType(personalityTypeID))
            .build();
    }
}
