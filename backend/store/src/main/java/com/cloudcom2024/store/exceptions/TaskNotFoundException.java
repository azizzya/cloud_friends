package com.cloudcom2024.store.exceptions;

public class TaskNotFoundException extends RuntimeException {
    private long taskID;

    public TaskNotFoundException(String message, long taskID) {
        super(message);
        this.taskID = taskID;
    }

    public long getTaskID() {
        return taskID;
    }
}
