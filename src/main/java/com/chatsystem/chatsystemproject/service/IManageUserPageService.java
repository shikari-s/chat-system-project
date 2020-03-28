package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.UserStatus;

import java.util.List;

public interface IManageUserPageService {
    List<UserStatus> getUserList(String userName);

    List<UserStatus> getUserListTest(String userName);

    void registerFriend(Long userId);

    void blockFriend(Long userId);

    void removeRegister(Long userId);

    void removeBlock(Long userId);
}
