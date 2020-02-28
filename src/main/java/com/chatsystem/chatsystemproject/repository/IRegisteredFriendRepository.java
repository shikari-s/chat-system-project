package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.RegisteredFriend;

import java.util.List;

public interface IRegisteredFriendRepository {
    List<RegisteredFriend> select();

    List<RegisteredFriend> selectBy(long usserId);
}
