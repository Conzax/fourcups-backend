package com.conzax.fourcups.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Event {

    @Id
    private UUID id;
    private UUID owner;
    private UUID game;
    private String name;
    private String description;

    @Id
    @GeneratedValue
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public UUID getGame() {
        return game;
    }

    public void setGame(UUID game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
