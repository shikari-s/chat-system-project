package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    @Override
    public void insert(GlobalMessage globalMessage){
        var sql = "insert into GLOBAL_MESSAGE(MESSAGE, POST_TIME, SENDER_USER_ID, THREAD_ID) values (?, ?, ?, ?)";
        jdbc.update(sql, globalMessage.getMessage(), globalMessage.getPostTime(), globalMessage.getSenderUserId(), globalMessage.getThreadId());
    }

    @Override
    public void delete(LocalDateTime postTime, long senderUserId, long threadId){
        var sql = "delete from GLOBAL_MESSAGE where (POST_TIME, SENDER_USER_ID, THREAD_ID) = (?,?,?)";
        jdbc.update(sql, postTime, senderUserId, threadId);
    }
}
