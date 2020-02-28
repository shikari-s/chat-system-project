package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessage;

import java.time.LocalDateTime;
import java.util.List;

public interface IGlobalMessageRepository {
    List<GlobalMessage> select();

    void insert(GlobalMessage globalMessage);
}
