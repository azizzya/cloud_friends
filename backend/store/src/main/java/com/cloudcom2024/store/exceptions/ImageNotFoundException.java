package com.cloudcom2024.store.exceptions;

public class ImageNotFoundException extends RuntimeException {
    private String imagename;

    public ImageNotFoundException(String message, String imagename) {
        super(message);
        this.imagename = imagename;
    }

    public String getImagename() {
        return imagename;
    }
}
