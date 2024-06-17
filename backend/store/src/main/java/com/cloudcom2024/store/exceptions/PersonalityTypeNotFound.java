package com.cloudcom2024.store.exceptions;

public class PersonalityTypeNotFound extends RuntimeException {
    private String personalityTypeID;

    public PersonalityTypeNotFound(String message, String personalityTypeID) {
        super(message);
        this.personalityTypeID = personalityTypeID;
    }

    public String getPersonalityTypeID() {
        return personalityTypeID;
    }
}
