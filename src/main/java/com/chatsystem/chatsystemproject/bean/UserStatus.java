package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;

public class UserStatus implements Serializable {

    private long userId;
    private String userName;
    private boolean registeredFriend;
    private boolean blocked;


    public UserStatus(long userId,String userName,boolean registeredFriend,boolean blocked){
        this.userId = userId;
        this.userName = userName;
        this.registeredFriend = registeredFriend;
        this.blocked = blocked;
    }
    public UserStatus(long userId,String userName){
        this.userId = userId;
        this.userName = userName;
        this.registeredFriend = false;
        this.blocked = false;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isRegisteredFriend() {
        return registeredFriend;
    }

    public void setRegisteredFriend(boolean registeredFriend) {
        this.registeredFriend = registeredFriend;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
