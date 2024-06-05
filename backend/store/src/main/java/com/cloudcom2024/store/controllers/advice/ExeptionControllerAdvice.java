package com.cloudcom2024.store.controllers.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudcom2024.store.dtos.ErrorDetails;
import com.cloudcom2024.store.exceptions.TaskDetailNotFoundException;
import com.cloudcom2024.store.exceptions.UserAlreadyExistsException;
import com.cloudcom2024.store.exceptions.UserNotFoundException;

import jakarta.security.auth.message.AuthException;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class ExeptionControllerAdvice {
    @ExceptionHandler(TaskDetailNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionTaskDetailNotFoundHandler(TaskDetailNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format("%s with id: %d", ex.getMessage(), ex.getTaskDetailID()));
        return ResponseEntity
            .badRequest()
            .body(errorDetails);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorDetails> extentionAuthHandler(AuthException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(errorDetails);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> extentionUserNotFound(UserNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format("user with username %s not found", ex.getUsername()));
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> exceptionJsonValidationHandler(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String jsonFieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(jsonFieldName, errorMessage);
        });
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errors);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> exceptionUserAlreadyExistsHandler(UserAlreadyExistsException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format("user with username %s already exists", ex.getUsername()));
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorDetails);
    }
}
