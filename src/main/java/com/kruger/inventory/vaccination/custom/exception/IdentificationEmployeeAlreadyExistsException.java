package com.kruger.inventory.vaccination.custom.exception;

public class IdentificationEmployeeAlreadyExistsException extends RuntimeException{
    public IdentificationEmployeeAlreadyExistsException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
