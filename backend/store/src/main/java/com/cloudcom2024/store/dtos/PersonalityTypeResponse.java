package com.cloudcom2024.store.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalityTypeResponse {
    @JsonProperty("personality_type_id")
    private Long personalityTypeID;

    @JsonProperty("name")
    private String name;
}
