package com.flyaway.flyaway.domain.exception;

public class DuplicateEntityException extends RuntimeException{

    public DuplicateEntityException(String message) {
        super(message);
    }
}
