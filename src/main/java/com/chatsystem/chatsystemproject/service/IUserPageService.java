package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.RegisteredFriend;
import com.chatsystem.chatsystemproject.bean.User;

import java.util.List;

public interface IUserPageService {
    /**
     * フレンドの一覧を持ってくる
     */
    List<User> getFriendList(Long userId);
}
