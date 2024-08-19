package com.personal.me.EmployeeManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException exception) {
        HashMap<String, Object> error = new HashMap<>();
        error.put("message", "Resource id not found.");
        error.put("details", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EmployeeNullPropException.class)
    public ResponseEntity<Object> handleEmployeeNullPropException(EmployeeNullPropException exception) {
        HashMap<String, Object> error = new HashMap<>();
        String field = exception.getField();

        switch (field) {
            case "first name":
                error.put("message", "First name field is empty.");
                break;
            case "last name":
                error.put("message", "Last name field is empty.");
                break;
            case "specialization":
                error.put("message", "Specialization field is empty.");
                break;
            default:
                error.put("message", "A unknown error occurred.");
                break;
        }

        error.put("details", exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EmployeeWageValueException.class)
    public ResponseEntity<Object> handleEmployeeWageValueException(EmployeeWageValueException exception) {
        HashMap<String, Object> error = new HashMap<>();

        error.put("message", "Wage must be greater than 500.");
        error.put("details", exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
