package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PersonalMessage implements Serializable {

    private String message;
    private LocalDateTime postTime;
    private long senderUserId;
    private long receiverUserId;

    public PersonalMessage(String message, LocalDateTime postTime, long senderUserId, long receiverUserId){
        this.setMessage(message);
        this.setPostTime(postTime);
        this.setSenderUserId(senderUserId);
        this.setReceiverUserId(receiverUserId);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public long getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(long senderUserId) {
        this.senderUserId = senderUserId;
    }

    public long getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(long receiverUserId) {
        this.receiverUserId = receiverUserId;
    }
}
