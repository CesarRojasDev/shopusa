package com.shopusa.server.exeption;

public class ProductoNotFoundExeption extends  RuntimeException {
    public ProductoNotFoundExeption(String message){
        super(message);
    }
}
