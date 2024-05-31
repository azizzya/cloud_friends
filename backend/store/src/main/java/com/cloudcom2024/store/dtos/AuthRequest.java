package com.cloudcom2024.store.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthRequest {
    @NotEmpty(message = "username musn't be empty")
    @JsonProperty("username")
    private String username;

    @NotEmpty(message = "password musn't be empty")
    @JsonProperty("password")
    private String password;
}
