package com.kruger.inventory.vaccination.custom.exception;

/**
 * this Class is a customized Exception to be thrown from the code in Runtime
 */
public class IdentificationEmployeeAlreadyExistsException extends RuntimeException{
    public IdentificationEmployeeAlreadyExistsException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
