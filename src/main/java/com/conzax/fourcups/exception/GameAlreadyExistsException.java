package com.conzax.fourcups.exception;

public class GameAlreadyExistsException extends RuntimeException {

    public GameAlreadyExistsException(String name) {
        super("Game already exists: " + name);
    }
}