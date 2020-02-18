package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.BlockedUser;

import java.util.List;

public interface IBlockedUserRepository {
    List<BlockedUser> select();
}
