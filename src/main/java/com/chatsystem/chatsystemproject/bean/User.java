package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;

public class User implements Serializable {

    private long id;
    private String name;
    private String password;
    private boolean active;

    public User(){
        id = 0;
        name="";
        password = "";
        active = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
