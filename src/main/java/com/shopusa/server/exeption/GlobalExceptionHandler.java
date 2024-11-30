package com.shopusa.server.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductoNotFoundExeption.class)
    public ResponseEntity<String> handleProductoNotFoundException(ProductoNotFoundExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoriaNotFoundExeption.class)
    public ResponseEntity<String> handleCategoriaNotFoundException(CategoriaNotFoundExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SubCategoriaNotFoundExeption.class)
    public ResponseEntity<String> handleSubCategoriaNotFoundException(SubCategoriaNotFoundExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ComisionNotFoundExeption.class)
    public ResponseEntity<String> handleComisionNotFoundException(ComisionNotFoundExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlataformaNotFoundExeption.class)
    public ResponseEntity<String> handlePlataformaNotFoundException(PlataformaNotFoundExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PublicacionNotFoundExeption.class)
    public ResponseEntity<String> handlePublicacionNotFoundException(PublicacionNotFoundExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
