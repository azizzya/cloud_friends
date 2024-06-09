package com.cloudcom2024.store.exceptions;

public class ItemImageAlreadyExistsException extends RuntimeException {
    private String itemImageName;

    public ItemImageAlreadyExistsException(String massage, String itemImageName) {
        super(massage);
        this.itemImageName = itemImageName;
    }

    public String getItemImageName() {
        return itemImageName;
    }
}
