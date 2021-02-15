package com.conzax.fourcups.exception;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException {

    /**
     * Возвращает текст "Идентификатор аккаунта не найден: идентификатор" по идентификатору
     * @param id идентификатор аккаунта
     */
    public AccountNotFoundException(UUID id) {
        super("Account ID not found: " + id);
    }
}