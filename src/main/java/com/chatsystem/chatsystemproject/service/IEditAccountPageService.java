package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.User;

public interface IEditAccountPageService {

    void Update(String userName, String password,long userId);

    //void Update(String userName, String password,long userId);

    User getMySessionUser();
}
