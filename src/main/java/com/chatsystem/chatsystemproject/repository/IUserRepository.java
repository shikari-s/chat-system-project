package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.User;

import java.util.List;

public interface IUserRepository {
    List<User> select();

    User selectBy(String userName);

    public int insert(String userName, String userPass);

}
