package com.conzax.fourcups.exception;

import java.util.UUID;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(UUID id) { super("Game ID not found: " + id); }
}
