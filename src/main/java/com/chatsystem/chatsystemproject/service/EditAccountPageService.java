package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.repository.IUserRepository;
import com.chatsystem.chatsystemproject.session.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditAccountPageService implements IEditAccountPageService {
    private IUserRepository userRepository;

    @Autowired
    public EditAccountPageService(IUserRepository UserRepository) {
        this.userRepository = UserRepository;
    }


    @Override
    public void Update(String userName, String password,long userId) {
        userRepository.update(userName, password,userId);
    }

    @Override
    public User getMySessionUser(){
        return userRepository.selectBy(MySession.get().getMyUserId());
    }


}
