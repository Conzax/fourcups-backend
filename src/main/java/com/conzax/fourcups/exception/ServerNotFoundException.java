package com.conzax.fourcups.exception;

import java.util.UUID;

public class ServerNotFoundException extends RuntimeException {

    public ServerNotFoundException(UUID id) { super("Server ID not found: " + id); }
}
