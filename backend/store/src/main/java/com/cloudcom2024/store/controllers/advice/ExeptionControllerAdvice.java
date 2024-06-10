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
import com.cloudcom2024.store.exceptions.ImageNotFoundException;
import com.cloudcom2024.store.exceptions.ItemImageAlreadyExistsException;
import com.cloudcom2024.store.exceptions.ItemNotFoundException;
import com.cloudcom2024.store.exceptions.OnlyOneTaskPerUserAvailableException;
import com.cloudcom2024.store.exceptions.TaskDetailNotFoundException;
import com.cloudcom2024.store.exceptions.TaskNotFoundException;
import com.cloudcom2024.store.exceptions.UserAlreadyExistsException;
import com.cloudcom2024.store.exceptions.UserNotFoundException;

import jakarta.security.auth.message.AuthException;

@RestControllerAdvice
public class ExeptionControllerAdvice {
    
    @ExceptionHandler(TaskDetailNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionTaskDetailNotFoundHandler(TaskDetailNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format(ex.getMessage(), ex.getTaskDetailID()));
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
        if (ex.getUsername().isPresent()) {
            errorDetails.setMessage(String.format(ex.getMessage(), ex.getUsername().get()));
        } else if (ex.getUserID().isPresent()) {
            errorDetails.setMessage(String.format(ex.getMessage(), ex.getUserID().get()));
        }

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

    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionImageNotFoundExceptionHandler(ImageNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format("image with name %s not found", ex.getImagename()));
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorDetails);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionItemNotFoundExceptionHandler(ItemNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format("item with id %d not found", ex.getItemID()));
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(errorDetails);
    }
    
    @ExceptionHandler(ItemImageAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> exceptionItemImageNotFoundHandler(ItemImageAlreadyExistsException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format("item image with name %s already exists", ex.getItemImageName()));
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorDetails);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionTaskNotFoundHandler(TaskNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format(ex.getMessage(), ex.getTaskID()));
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(errorDetails);
    }

    @ExceptionHandler(OnlyOneTaskPerUserAvailableException.class)
    public ResponseEntity<ErrorDetails> exceptionOnlyOneTaskPerUserAvailableHandler(OnlyOneTaskPerUserAvailableException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(String.format(ex.getMessage(), ex.getUserID(), ex.getFriendID()));
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorDetails);
    }
}
