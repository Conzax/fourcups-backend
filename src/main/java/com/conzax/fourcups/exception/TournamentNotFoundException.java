package com.conzax.fourcups.exception;

import java.util.UUID;

public class TournamentNotFoundException extends RuntimeException {

    public TournamentNotFoundException(UUID id) { super("Tournament not found " + id); }
}
