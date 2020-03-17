package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;

public class RegisteredFriend implements Serializable {

    private long registeredUserId;
    private long registrantUserId;

    public long getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(long registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public long getRegistrantUserId() {
        return registrantUserId;
    }

    public void setRegistrantUserId(long registrantUserId) {
        this.registrantUserId = registrantUserId;
    }
}
