package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.BlockedUser;

import java.util.List;

public interface IBlockedUserRepository {
    List<BlockedUser> select();

    List<BlockedUser> selectBy(long userId);

    void insert(Long myUserId, Long userId);
}
