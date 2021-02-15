package com.conzax.fourcups.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Tournament {

    @Id
    private UUID id;
    private String name;
    private String desc;
    private String author;

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
     * Возвращает имя
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает описание
     * @return описание
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Устанавливает описание
     * @param description описание
     */
    public void setDesc(String description) {
        this.desc = description;
    }

    /**
     * Возвращает автора
     * @return автор
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Устанавливает автора
     * @param author автор
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}
