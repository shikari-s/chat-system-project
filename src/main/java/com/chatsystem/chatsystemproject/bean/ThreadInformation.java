package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ThreadInformation implements Serializable {

    private long ThreadId;
    private String ThreadName;
    private LocalDateTime createTime;
    private String creatorUserName;

}