package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GlobalMessage implements Serializable {

    private String message;
    private LocalDateTime postTime;
    private long senderUserId;
    private long sleddId;
}
