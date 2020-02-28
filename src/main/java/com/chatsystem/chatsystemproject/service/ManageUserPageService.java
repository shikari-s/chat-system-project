package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.RegisteredFriend;
import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.bean.UserStatus;
import com.chatsystem.chatsystemproject.repository.IBlockedUserRepository;
import com.chatsystem.chatsystemproject.repository.IRegisteredFriendRepository;
import com.chatsystem.chatsystemproject.repository.IUserRepository;
import com.chatsystem.chatsystemproject.session.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ManageUserPageService implements IManageUserPageService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRegisteredFriendRepository registeredFriendRepository;
    @Autowired
    IBlockedUserRepository blockedUserRepository;

    @Override
    public List<UserStatus> getUserList(String userName){
        var userList = userRepository.selectLikeNameBy(userName);
        var registeredFriendList = registeredFriendRepository.selectBy(MySession.get().getMyUserId());
        var blockedUserList = blockedUserRepository.selectBy(MySession.get().getMyUserId());
        var userStatusList = new ArrayList<UserStatus>();
        userList.stream().forEach(user -> {
            var userStatus = new UserStatus(user.getId(),user.getName());
            if(registeredFriendList.stream().filter(registeredFriend -> registeredFriend.getRegistrantUserId() == user.getId()) != null)userStatus.setRegisteredFriend(true);
            if(blockedUserList.stream().filter(blockedUser -> blockedUser.getRegistrantUserId() == user.getId()) != null)userStatus.setBlocked(true);
            userStatusList.add(userStatus);
        });
        return userStatusList;
    }

}
