package com.maids.task.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Setter
@Getter
public class ApiBodyException {
    private final String message;
    private final LocalDateTime date;
    private final HttpStatus httpStatus;
}
