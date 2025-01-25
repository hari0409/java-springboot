package com.example.crud_demo.responseObject;

public class ResponseObject<T> {
    public String status;
    public T data;

    public ResponseObject(String status, T data) {
        this.status = status;
        this.data = data;
    }
}
