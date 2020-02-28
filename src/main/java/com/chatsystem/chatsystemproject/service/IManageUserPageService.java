package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.User;

import java.util.List;

public interface IManageUserPageService {
    List<User> getUserList(String userName);
}
