package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PersonalMessageInformation implements Serializable {

    private String message;
    private LocalDateTime postTime;
    private String senderUserName;
    private String receiverUserName;

}
