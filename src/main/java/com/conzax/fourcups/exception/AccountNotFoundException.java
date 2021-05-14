package com.conzax.fourcups.exception;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(UUID id) {
        super("Account ID not found: " + id);
    }
}
