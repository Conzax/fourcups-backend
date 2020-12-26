package com.conzax.fourcups.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    public Account() {

    }

    public Account(Long id, String nickname, String email, String password) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
