package com.danielbravoac.schoolservice.exception.custom;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String message) {
        super(message);
    }
}
