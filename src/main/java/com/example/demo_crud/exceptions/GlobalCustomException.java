package com.example.demo_crud.exceptions;

public class GlobalCustomException extends RuntimeException {
    public GlobalCustomException(String errorMsg) {
        super(errorMsg);
    }
}
