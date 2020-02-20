package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ThreadInformation implements Serializable {

    private long ThreadId;
    private String ThreadName;
    private LocalDateTime createTime;
    private String creatorUserName;


    public long getThreadId() {
        return ThreadId;
    }

    public void setThreadId(long threadId) {
        ThreadId = threadId;
    }

    public String getThreadName() {
        return ThreadName;
    }

    public void setThreadName(String threadName) {
        ThreadName = threadName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
    }
}