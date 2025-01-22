package com.example.demo_crud.response;

public class ErrorResponseObject {
    public String status;
    public String errorMessage;

    public ErrorResponseObject(String status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}