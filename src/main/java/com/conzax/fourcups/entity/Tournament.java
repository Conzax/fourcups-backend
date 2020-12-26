package com.conzax.fourcups.entity;

import net.minidev.json.JSONArray;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TOURNAMENTS")
public class Tournament {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true, nullable = false)
    private String description;
    private String author;

    @Type(type = "string-array")
    @Column(columnDefinition = "text[]")
    private String[] followers;

    public Tournament() {

    }

    public Tournament(Long id, String name, String description, String author, String[] followers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.followers = followers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getFollowers() { return followers; }
    public void setFollowers(String[] followers) {
        this.followers = followers;
    }
}
