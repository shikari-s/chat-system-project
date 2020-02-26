package com.chatsystem.chatsystemproject.service;


import com.chatsystem.chatsystemproject.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccoountPageService implements ICreateAccoountPageService{
    private IUserRepository UserRepository;

    @Autowired
    public CreateAccoountPageService(IUserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public void registerUser(String userName, String password) {
        int n = UserRepository.insert(userName, password);
    }
}
