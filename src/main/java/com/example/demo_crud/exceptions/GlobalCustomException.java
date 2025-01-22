package com.example.demo_crud.exceptions;

public class GlobalCustomException extends RuntimeException {
    public Integer statusCode;

    public GlobalCustomException(String errorMsg, Integer statusCode) {
        super(errorMsg);
        this.statusCode = statusCode;
    }
}
