package com.kruger.inventory.vaccination.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException){
        return new ResponseEntity<String>("There is some syntax problem in the JSON Request", HttpStatus.BAD_REQUEST);
    }
}
