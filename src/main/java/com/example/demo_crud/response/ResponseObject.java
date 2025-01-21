package com.example.demo_crud.response;

public class ResponseObject<T> {
    public String status;
    public T data;
    public String errorMessage;

    public ResponseObject(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseObject(String status, T data, String errorMsg) {
        this.status = status;
        this.errorMessage = errorMsg;
        this.data = data;
    }
}