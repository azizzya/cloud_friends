package com.cloudcom2024.store.exceptions;

public class OnlyOneTaskPerUserAvailableException extends RuntimeException {

    private long userID;
    private long friendID;
    
    public OnlyOneTaskPerUserAvailableException(String message, long userID, long friendID) {
        super(message);
        this.userID = userID;
        this.friendID = friendID;
    }

    public long getUserID() {
        return userID;
    }

    public long getFriendID() {
        return friendID;
    }
}
