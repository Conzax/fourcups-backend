package com.conzax.fourcups.exception;

public class ServerAlreadyExistsException extends RuntimeException {

    public ServerAlreadyExistsException(String name) {
        super("Server already exists: " + name);
    }
}