package com.example.AluraForoHub.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class configuracionErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException e){
        var error=e.getFieldErrors().stream().map(datosError400::new).toList();
        return ResponseEntity.badRequest().body(error);
    }

    private record datosError400(String campo, String error){
        public datosError400(FieldError error){
            this(error.getField(), error.getDefaultMessage());

        }
    }
}
