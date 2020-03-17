package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.User;

import java.util.List;

public interface IUserRepository {
    List<User> select();

    User selectLastBy(String userName);

    List<User> selectLikeNameBy(String userName,Long myUserId);

    User selectBy(long userId);

    public int insert(String userName, String userPass);

    public void update(String userName, String password);

    void update(String userName, String password, long userId);

    List<User> selectByUserName(String userName);
}
