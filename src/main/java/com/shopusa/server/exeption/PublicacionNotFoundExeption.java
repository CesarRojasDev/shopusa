package com.shopusa.server.exeption;

public class PublicacionNotFoundExeption extends  RuntimeException{
    public PublicacionNotFoundExeption(String message){
        super(message);
    }
}
