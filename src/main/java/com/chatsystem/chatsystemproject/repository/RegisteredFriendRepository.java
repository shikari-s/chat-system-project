package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.RegisteredFriend;
import com.chatsystem.chatsystemproject.bean.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegisteredFriendRepository implements IRegisteredFriendRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<RegisteredFriend> select(){
        var sql = "select * from REGISTERED_FRIEND";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(RegisteredFriend.class));
    }

    @Override
    public List<RegisteredFriend> selectBy(long userId){
        var sql = "select * from REGISTERED_FRIEND WHERE REGISTERED_USER_ID = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(RegisteredFriend.class),userId);
    }

    @Override
    public void insert(Long myUserId,Long userId){
        var sql = "insert into REGISTERED_FRIEND(REGISTERED_USER_ID,REGISTRANT_USER_ID) values (?,?)";
        jdbc.update(sql,myUserId,userId);
    }
}
