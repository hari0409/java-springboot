package com.example.crud_demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.crud_demo.constants.ProjectConstant;
import com.example.crud_demo.responseObject.ErrorObject;

@ControllerAdvice
public class GlobaExceptionHandler {
    @ExceptionHandler(exception = GlobalException.class)
    public ResponseEntity<ErrorObject> returnError(GlobalException e) {
        return ResponseEntity.status(e.status).body(new ErrorObject(ProjectConstant.FAILURE, e.getMessage()));
    }

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ErrorObject> returnErrorGeneric(Exception e) {
        return ResponseEntity.status(500).body(new ErrorObject(ProjectConstant.FAILURE, "Invalid Request"));
    }
}
