package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GlobalMessageInformation implements Serializable {

    private String senderUserName;
    private String sleddName;
    private String message;
    private LocalDateTime postTime;

}
