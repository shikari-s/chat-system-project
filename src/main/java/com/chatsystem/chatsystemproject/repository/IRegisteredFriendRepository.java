package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.RegisteredFriend;
import com.chatsystem.chatsystemproject.bean.User;

import java.util.List;

public interface IRegisteredFriendRepository {
    List<RegisteredFriend> select();

    List<RegisteredFriend> selectBy(long usserId);

    void insert(Long myUserId, Long userId);

    /**
     * 友達一覧の情報をUserBeanのリストとして取得
     * @param userId
     * @return 友達の情報
     */
    List<User> selectByFriend(Long userId);
}
