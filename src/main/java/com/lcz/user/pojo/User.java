package com.lcz.user.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: lcz
 * @create: 2019-11-21 19:24
 **/
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    private String id;
    private String username;
    private String password;
    private String phone;
    private String card;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public User(String id, String username, String password, String phone, String card) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.card = card;
    }

    public User(String username, String password, String phone, String card) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.card = card;
    }

    public User() {
    }
}
