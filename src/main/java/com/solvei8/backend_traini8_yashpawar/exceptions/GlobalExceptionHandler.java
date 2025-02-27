package com.solvei8.backend_traini8_yashpawar.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for handling application-wide exceptions.
 * This class provides centralized exception handling for common validation and database errors.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation errors when request payload fails validation constraints.
     *
     * @param ex the MethodArgumentNotValidException thrown when validation fails
     * @return a map of field names and their corresponding validation error messages, wrapped in a ResponseEntity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    /**
     * Handles database integrity violations, such as duplicate entries.
     *
     * @param ex the DataIntegrityViolationException thrown when a database constraint is violated
     * @return an error message wrapped in a ResponseEntity with appropriate HTTP status codes
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, String> response = new HashMap<>();

        if (ex.getMessage().contains("Duplicate entry")) {
            response.put("error", "A training center with the same center code already exists.");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);  // 409 Conflict
        }

        response.put("error", "Database error occurred.");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles generic runtime exceptions.
     *
     * @param ex the RuntimeException thrown during application execution
     * @return an error message wrapped in a ResponseEntity with a 500 Internal Server Error status
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
