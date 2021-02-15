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

    public Tournament() {}

    @Id
    @GeneratedValue
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String description) {
        this.desc = description;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
