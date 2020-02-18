package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.RegisteredFriend;
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
}
