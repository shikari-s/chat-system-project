package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GlobalMessageRepository implements IGlobalMessageRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<GlobalMessage> select(){
        var sql = "select * from GLOBAL_MESSAGE";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(GlobalMessage.class));
    }
}
