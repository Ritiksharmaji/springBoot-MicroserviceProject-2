//package com.scaler1.scalerProject_1.exceptions;
//
//import com.scaler1.scalerProject_1.dtos.ExceptionDto;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(NotFoundException.class)
//    public ExceptionDto handleNotFoundException(NotFoundException ex) {
//        return new ExceptionDto(
//                HttpStatus.NOT_FOUND,
//                ex.getMessage()
//        );
//    }
//}
package com.scaler1.scalerProject_1.exceptions;

import com.scaler1.scalerProject_1.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException ex) {

        ExceptionDto error = new ExceptionDto(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGeneralException(Exception ex) {

        ExceptionDto error = new ExceptionDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

