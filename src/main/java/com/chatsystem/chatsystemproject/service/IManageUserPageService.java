package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.UserStatus;

import java.util.List;

public interface IManageUserPageService {
    List<UserStatus> getUserList(String userName);
}
