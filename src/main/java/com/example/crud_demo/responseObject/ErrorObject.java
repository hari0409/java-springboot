package com.example.crud_demo.responseObject;

public class ErrorObject {
    public String status;
    public String message;

    public ErrorObject(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
