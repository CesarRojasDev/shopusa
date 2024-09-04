package com.shopusa.server.exeption;

public class ComisionNotFoundExeption extends RuntimeException{
    public ComisionNotFoundExeption(String message){
        super(message);
    }
}
