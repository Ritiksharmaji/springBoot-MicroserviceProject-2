package com.scaler1.scalerProject_1.dtos;

import com.scaler1.scalerProject_1.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ExceptionDto handleNotFoundException(NotFoundException ex) {
        return new ExceptionDto(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
    }
}
