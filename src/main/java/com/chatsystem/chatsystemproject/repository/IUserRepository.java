package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.bean.UserStatus;

import java.util.List;

public interface IUserRepository {
    List<User> select();

    User selectBy(String userName);

    List<User> selectLikeNameBy(String userName);

    public int insert(String userName, String userPass);

}
