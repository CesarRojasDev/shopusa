package com.shopusa.server.exeption;

public class SubCategoriaNotFoundExeption extends RuntimeException{
    public SubCategoriaNotFoundExeption(String message){
        super(message);
    }
}
