package com.kruger.inventory.vaccination.advice;

import com.kruger.inventory.vaccination.custom.exception.IdentificationEmployeeAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException){
        return new ResponseEntity<String>("There is some syntax problem in the JSON Request", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IdentificationEmployeeAlreadyExistsException.class)
    public ResponseEntity<String> handlerIdentificationEmployeeAlreadyExistsException(IdentificationEmployeeAlreadyExistsException identificationEmployeeAlreadyExistsException){
        return new ResponseEntity<String>("Identification of Employee already in use try another one", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
        return new ResponseEntity<String>("No data found in the referenced table that is requested. Check if the value you want to record exists in the foreign table", HttpStatus.BAD_REQUEST);
    }
}
