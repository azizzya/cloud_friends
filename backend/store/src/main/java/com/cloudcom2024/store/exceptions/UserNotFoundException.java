package com.cloudcom2024.store.exceptions;

import java.util.Optional;

public class UserNotFoundException extends RuntimeException{
    private String username;
    private Long userID;

    public UserNotFoundException(String message, String username) {
        super(message);
        this.username = username;
    }

    public UserNotFoundException(String message, long userID) {
        super(message);
        this.userID = userID;
    }

    public Optional<String> getUsername() {
        return Optional.of(username);
    }

    public Optional<Long> getUserID() {
        return Optional.of(userID);
    }
}
