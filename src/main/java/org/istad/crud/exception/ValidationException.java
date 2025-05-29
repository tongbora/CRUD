package org.istad.crud.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestControllerAdvice
public class ValidationException {


    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleServerException(ResponseStatusException exception){
        return ResponseEntity.status(exception.getStatusCode())
                .body(Map.of("message", exception.getMessage()));
    }
}
