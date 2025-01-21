package com.shopusa.server.exeption;

public class EntityNotFoundException extends  RuntimeException {
    public EntityNotFoundException(String entityName, String id) {
        super(entityName + " con ID " + id + " no fue encontrado.");
    }
}
