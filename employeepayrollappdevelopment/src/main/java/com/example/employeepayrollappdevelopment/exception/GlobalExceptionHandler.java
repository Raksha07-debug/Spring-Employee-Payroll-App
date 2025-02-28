package com.example.employeepayrollappdevelopment.exception;

import com.example.employeepayrollappdevelopment.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

//Exception handled by exception handler.
@ControllerAdvice @Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ResponseDto responseDTO = new ResponseDto("Validation Error", errors);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeeNotFoundException exception){
        ResponseDto responseDto=new ResponseDto("exception while processing REST request",exception.getMessage());
        return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("Invalid Date Format", exception);
        String message="Exception while processing REST ";
        ResponseDto responseDTO = new ResponseDto (message, "Should have date in the format dd MMM yyyy");
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    }

