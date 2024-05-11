package com.maids.task.exception;

public class BookDuplicateIDException extends RuntimeException{
    public BookDuplicateIDException(String message) {
        super(message);
    }
}
