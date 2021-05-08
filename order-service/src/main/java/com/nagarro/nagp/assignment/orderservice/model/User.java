package com.nagarro.nagp.assignment.orderservice.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -424688033076492589L;

    private int userId;
    private String name;

    public User() { }

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
