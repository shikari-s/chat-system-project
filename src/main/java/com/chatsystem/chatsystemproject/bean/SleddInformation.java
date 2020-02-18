package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SleddInformation implements Serializable {

    private long sleddId;
    private String sleddName;
    private LocalDateTime createTime;
    private String creatorUserName;

}
