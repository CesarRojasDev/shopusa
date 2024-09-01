package com.shopusa.server.exeption;

public class CategoriaNotFoundExeption extends RuntimeException {
    public CategoriaNotFoundExeption(String message){
        super(message);
    }
}
