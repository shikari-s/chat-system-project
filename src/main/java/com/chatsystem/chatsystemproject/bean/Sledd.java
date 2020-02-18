package com.chatsystem.chatsystemproject.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Sledd implements Serializable {

    private long id;
    private String name;
    private LocalDateTime createTime;
    private long creatorUserId;

}
