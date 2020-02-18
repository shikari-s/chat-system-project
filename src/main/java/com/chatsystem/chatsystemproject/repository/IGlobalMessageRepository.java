package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessage;

import java.util.List;

public interface IGlobalMessageRepository {
    List<GlobalMessage> select();
}
