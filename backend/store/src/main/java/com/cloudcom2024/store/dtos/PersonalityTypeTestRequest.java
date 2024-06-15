package com.cloudcom2024.store.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonalityTypeTestRequest {
    @JsonProperty("personality_id")
    @NotNull(message = "personality id musn't be empty")
    private Long personalityTypeID;

    @JsonProperty("score_percent")
    @NotNull(message = "score percents musn't be empty")
    private BigDecimal scorePercent;
}
