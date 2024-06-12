package com.cloudcom2024.store.exceptions;

public class PersonalityTypeNotFound extends RuntimeException {
    private long personalityTypeID;

    public PersonalityTypeNotFound(String message, long personalityTypeID) {
        super(message);
        this.personalityTypeID = personalityTypeID;
    }

    public long getPersonalityTypeID() {
        return personalityTypeID;
    }
}
