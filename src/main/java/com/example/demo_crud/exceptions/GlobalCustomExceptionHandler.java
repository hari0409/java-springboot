package com.example.demo_crud.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo_crud.constants.ProjectConstants;
import com.example.demo_crud.response.ErrorResponseObject;

@ControllerAdvice
public class GlobalCustomExceptionHandler {
    @ExceptionHandler(exception = GlobalCustomException.class)
    public ResponseEntity<ErrorResponseObject> handleException(GlobalCustomException e) {
        return ResponseEntity.status(e.statusCode)
                .body(new ErrorResponseObject(ProjectConstants.FAILURE, e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseObject> handleExceptionGeneric(Exception e) {
        return ResponseEntity.status(404)
                .body(new ErrorResponseObject(ProjectConstants.FAILURE, e.getMessage()));
    }
}
