package com.example.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.exceptions.EntityNotFound;

@RestController
public class ExceptionController {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> entityNotFound(EntityNotFound e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
