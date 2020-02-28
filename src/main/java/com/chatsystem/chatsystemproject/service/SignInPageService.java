package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.repository.IUserRepository;
import com.chatsystem.chatsystemproject.session.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInPageService implements ISignInPageService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean authenticate(String userName, String password){
        var user = userRepository.selectLastBy(userName);
        if(user.getPassword().equals(password)){
            MySession.get().signIn(user.getId(),user.getName());
            return true;
        }else{
            return false;
        }
    }

}
