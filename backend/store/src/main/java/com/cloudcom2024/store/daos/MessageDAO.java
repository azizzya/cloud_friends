package com.cloudcom2024.store.daos;

import com.cloudcom2024.store.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDAO {
    @JsonProperty("role")
    private String role;

    @JsonProperty("content")
    private String content;
}