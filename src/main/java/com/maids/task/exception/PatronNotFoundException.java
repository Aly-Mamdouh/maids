package com.maids.task.exception;

public class PatronNotFoundException extends RuntimeException{
    public PatronNotFoundException(String message) {
        super(message);
    }
}
