package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessage;

import java.time.LocalDateTime;
import java.util.List;

public interface IGlobalMessageRepository {
    List<GlobalMessage> select();

    void insert(String message, LocalDateTime createTime, long senderUserId, long threadId);
}
