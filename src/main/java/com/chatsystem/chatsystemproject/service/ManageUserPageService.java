package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageUserPageService implements IManageUserPageService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getUserList(String userName){
        var userStatusList = userRepository.selectByUserName(userName);
        return userStatusList;
    }

}
