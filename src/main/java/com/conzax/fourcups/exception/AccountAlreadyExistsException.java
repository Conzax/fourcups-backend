package com.conzax.fourcups.exception;

public class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(String username) {
        super("Account with username already exists: " + username);
    }
}