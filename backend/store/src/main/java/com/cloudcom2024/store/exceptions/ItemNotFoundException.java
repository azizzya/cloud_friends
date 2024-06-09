package com.cloudcom2024.store.exceptions;

public class ItemNotFoundException extends RuntimeException {
    private long itemID;

    public ItemNotFoundException(String message, long itemID) {
        super(message);
        this.itemID = itemID;
    }

    public long getItemID() {
        return itemID;
    }
}
