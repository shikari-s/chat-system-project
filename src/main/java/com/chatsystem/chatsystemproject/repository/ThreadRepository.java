package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ThreadRepository implements IThreadRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Thread>select(){
        var sql = "select * from THREAD";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(Thread.class));
    }

    //THREAD作成
    @Override
    public void insert(String createThreadName, LocalDateTime createTime, long creatorUserId) {
        var sql = "insert into THREAD(NAME,CREATE_TIME,CREATOR_USER_ID) values (?, ?, ?)";
        jdbc.update(sql, createThreadName, createTime, creatorUserId);
    }

}
