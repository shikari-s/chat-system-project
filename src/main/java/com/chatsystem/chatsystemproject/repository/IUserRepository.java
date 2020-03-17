package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.bean.UserStatus;

import java.util.List;

public interface IUserRepository {
    List<User> select();

    User selectLastBy(String userName);

    List<User> selectLikeNameBy(String userName,Long myUserId);

    public int insert(String userName, String userPass);

}
