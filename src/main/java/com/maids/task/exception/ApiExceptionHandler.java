package com.maids.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex){
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        ApiBodyException exception=new ApiBodyException(ex.getMessage(), LocalDateTime.now(), httpStatus);
        return new ResponseEntity<>(exception,httpStatus);
    }

    @ExceptionHandler(value = {BookDuplicateIDException.class})
    public ResponseEntity<Object> handleBookDuplicateIDException(BookDuplicateIDException ex){
        HttpStatus httpStatus=HttpStatus.CONFLICT;
        ApiBodyException exception=new ApiBodyException(ex.getMessage(), LocalDateTime.now(), httpStatus);
        return new ResponseEntity<>(exception,httpStatus);
    }

    @ExceptionHandler(value = {PatronDuplicateIDException.class})
    public ResponseEntity<Object> handlePatronDuplicateIDException(PatronDuplicateIDException ex){
        HttpStatus httpStatus=HttpStatus.CONFLICT;
        ApiBodyException exception=new ApiBodyException(ex.getMessage(), LocalDateTime.now(), httpStatus);
        return new ResponseEntity<>(exception,httpStatus);
    }

    @ExceptionHandler(value = {PatronNotFoundException.class})
    public ResponseEntity<Object> handlePatronDuplicateIDException(PatronNotFoundException ex){
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        ApiBodyException exception=new ApiBodyException(ex.getMessage(), LocalDateTime.now(), httpStatus);
        return new ResponseEntity<>(exception,httpStatus);
    }
}
