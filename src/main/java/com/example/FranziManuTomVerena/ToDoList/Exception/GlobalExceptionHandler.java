package com.example.FranziManuTomVerena.ToDoList.Exception;

import com.example.FranziManuTomVerena.ToDoList.Security.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // durch diese Annotation kommt die Fehlermeldung automatisch, Spring Boot registriert sie automatisch
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> badCredentials(BadCredentialsException e){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Benutzer oder Passwort ist falsch.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>handleGeneralException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ein unerwarteter Fehler ist aufgetreten");
    }


}
