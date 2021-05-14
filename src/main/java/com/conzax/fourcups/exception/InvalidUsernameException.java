package com.conzax.fourcups.exception;

public class InvalidUsernameException extends RuntimeException {

    public InvalidUsernameException(String username) { super("Invalid username: " + username); }
}
