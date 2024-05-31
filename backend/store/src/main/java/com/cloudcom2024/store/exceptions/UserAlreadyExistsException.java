package com.cloudcom2024.store.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserAlreadyExistsException extends RuntimeException {
    private String username;

    public UserAlreadyExistsException(String message, String username) {
        super(message);
    }
}