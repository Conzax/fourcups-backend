package com.conzax.fourcups.exception;

import java.util.UUID;

public class TournamentNotFoundException extends RuntimeException {

    /**
     * Возвращает текст "Идентификатор турнира не найден: идентификатор" по идентификатору
     * @param id идентификатор турнира
     */
    public TournamentNotFoundException(UUID id) { super("Tournament ID not found " + id); }
}
