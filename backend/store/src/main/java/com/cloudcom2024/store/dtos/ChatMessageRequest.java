package com.cloudcom2024.store.dtos;

import com.cloudcom2024.store.daos.MessageDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ChatMessageRequest {
    @JsonIgnore
    private String username;

    @NotEmpty(message = "role musn't be empty")
    @JsonProperty("role")
    private String role;

    @NotEmpty(message = "message musn't be empty")
    @JsonProperty("message")
    private String message;

    public MessageDAO convertToMessageDAO() {
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.setContent(message);
        messageDAO.setRole(role);

        return messageDAO;
    }
}