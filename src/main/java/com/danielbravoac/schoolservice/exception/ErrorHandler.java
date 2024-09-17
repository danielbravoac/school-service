package com.danielbravoac.schoolservice.exception;

import com.danielbravoac.schoolservice.controller.dto.response.GenericResponse;
import com.danielbravoac.schoolservice.controller.dto.response.Info;
import com.danielbravoac.schoolservice.exception.custom.ModelNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleDefaultException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.INTERNAL_SERVER_ERROR.value(), "SOMETHING HAPPEN - CONTACT THE IT TEAM")), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<GenericResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.NOT_FOUND.value(), "DATA NOT FOUND")), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getField() + ": " + e.getDefaultMessage()).collect(Collectors.joining(","));
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.BAD_REQUEST.value(), "SOME INVALID FIELDS", "BAD REQUEST", message)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<GenericResponse> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.BAD_REQUEST.value(), "CHECK AGAIN THE IDS GIVEN")), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<GenericResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.BAD_REQUEST.value(), "SOME DATA GIVEN ALREADY EXISTS")), HttpStatus.NOT_FOUND);
    }

}
