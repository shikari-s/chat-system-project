package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.User;

import java.util.List;

public interface IUserRepository {
    List<User> select();

    User selectLastBy(String userName);

    public int insert(String userName, String userPass);

}
