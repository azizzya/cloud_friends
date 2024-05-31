package com.cloudcom2024.store.exceptions;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{
    private String username;
    
    public UserNotFoundException(String message, String username) {
        super(message);
        this.username = username;
    }
}
