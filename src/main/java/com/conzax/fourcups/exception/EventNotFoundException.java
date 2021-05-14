package com.conzax.fourcups.exception;

import java.util.UUID;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(UUID id) { super("Event ID not found: " + id); }
}
