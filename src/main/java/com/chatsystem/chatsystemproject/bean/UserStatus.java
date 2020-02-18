package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;

public class UserStatus implements Serializable {

    private long userId;
    private String userName;
    private boolean registeredFriend;
    private boolean blocked;

}
