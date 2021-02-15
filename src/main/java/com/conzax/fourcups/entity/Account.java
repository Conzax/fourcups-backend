package com.conzax.fourcups.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Account {

    @Id
    private UUID id;
    private String username;
    private String password;

    public Account() {}

    /**
     * Возвращает идентификатор
     * @return идентификатор
     */
    @Id
    @GeneratedValue
    public UUID getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор
     * @param id идентификатор
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Возвращает имя пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Возвращает пароль
     * @return пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Устанавливает пароль
     * @param password пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
