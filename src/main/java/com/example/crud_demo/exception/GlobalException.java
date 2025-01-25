package com.example.crud_demo.exception;

public class GlobalException extends RuntimeException {
    public Integer status;

    public GlobalException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }
}
