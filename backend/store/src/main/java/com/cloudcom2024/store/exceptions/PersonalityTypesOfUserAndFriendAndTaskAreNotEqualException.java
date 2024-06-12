package com.cloudcom2024.store.exceptions;

public class PersonalityTypesOfUserAndFriendAndTaskAreNotEqualException extends RuntimeException {

    private long taskPersonalityTypeID;
    private long userPersonalityTypeID;
    private long friendPersonalityTypeID;

    public PersonalityTypesOfUserAndFriendAndTaskAreNotEqualException(
        String message,
        long taskPersonalityTypeID,
        long userPersonalityTypeID, 
        long friendPersonalityTypeID
    ) {
        super(message);
        this.taskPersonalityTypeID = taskPersonalityTypeID;
        this.userPersonalityTypeID = userPersonalityTypeID;
        this.friendPersonalityTypeID = friendPersonalityTypeID;
    }

    public long getTaskPersonalityTypeID() {
        return taskPersonalityTypeID;
    }

    public long getUserPersonalityTypeID() {
        return userPersonalityTypeID;
    }

    public long getFriendPersonalityTypeID() {
        return friendPersonalityTypeID;
    }
}