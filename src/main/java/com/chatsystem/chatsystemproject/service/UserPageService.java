package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.RegisteredFriend;
import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.repository.IRegisteredFriendRepository;
import com.chatsystem.chatsystemproject.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPageService implements IUserPageService {

    private IRegisteredFriendRepository registeredFriendRepository;
    private IUserRepository userRepository;

    @Autowired
    public UserPageService (IRegisteredFriendRepository registeredFriendRepository) {
        this.registeredFriendRepository = registeredFriendRepository;
    }

    //フレンド一覧を持ってくるメソッド
    @Override
    public List<User> getFriendList(Long userId) {
        return registeredFriendRepository.selectByFriend(userId);
    }

}
