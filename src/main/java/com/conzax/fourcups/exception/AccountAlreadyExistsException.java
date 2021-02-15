package com.conzax.fourcups.exception;

public class AccountAlreadyExistsException extends RuntimeException {

    /**
     * Возвращает текст "Аккаунта с таким именем пользователя уже существует: имя пользователя"
     * @param username имя пользователя аккаунта
     */
    public AccountAlreadyExistsException(String username) {
        super("Account with username already exists: " + username);
    }
}