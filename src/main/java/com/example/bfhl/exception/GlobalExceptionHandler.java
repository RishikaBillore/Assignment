package com.example.bfhl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleException(Exception ex) {

        Map<String, Object> map = new HashMap<>();

        map.put("is_success", false);
        map.put("message", ex.getMessage());

        return map;
    }
}
