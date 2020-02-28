package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GlobalMessage implements Serializable {

    private String message;
    private LocalDateTime postTime;
    private long senderUserId;
    private long threadId;

    public GlobalMessage(String message, LocalDateTime postTime, long senderUserId, long threadId){
        this.setMessage(message);
        this.setPostTime(postTime);
        this.setSenderUserId(senderUserId);
        this.setThreadId(threadId);
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

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }
}
