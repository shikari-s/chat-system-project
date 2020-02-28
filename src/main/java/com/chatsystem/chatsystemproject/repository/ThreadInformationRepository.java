package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ThreadにUserを結合
 */
@Repository
public class ThreadInformationRepository implements IThreadInformationRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<ThreadInformation> select() {
        var sql = "select THREAD.ID as THREAD_ID,THREAD.NAME as THREAD_NAME,CREATE_TIME,USER.NAME as CREATOR_USER_NAME from THREAD " +
                "inner join USER on THREAD.CREATOR_USER_ID = USER.ID";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(ThreadInformation.class));
    }

    @Override
    public List<ThreadInformation> selectLastTen() {
        var sql = "select THREAD.ID as THREAD_ID,THREAD.NAME as THREAD_NAME,CREATE_TIME,USER.NAME as CREATOR_USER_NAME from THREAD " +
                "inner join USER on THREAD.CREATOR_USER_ID = USER.ID " +
                "order by CREATE_TIME desc limit 10";

        return jdbc.query(sql,new BeanPropertyRowMapper<>(ThreadInformation.class));
    }

    //最新の10件を書き換えるときに使用するsql
    @Override
    public List<ThreadInformation> selectBy(String threadName){
        var sql = "select THREAD.ID as THREAD_ID,THREAD.NAME as THREAD_NAME,CREATE_TIME,USER.NAME as CREATOR_USER_NAME from THREAD " +
                "inner join USER on THREAD.CREATOR_USER_ID = USER.ID " +
                "WHERE THREAD.NAME LIKE '%'||?||'%'";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(ThreadInformation.class),threadName);
    }

    @Override
    public ThreadInformation selectLastBy(Long userId) {
        var sql = "select THREAD.ID as THREAD_ID,THREAD.NAME as THREAD_NAME,CREATE_TIME,USER.NAME as CREATOR_USER_NAME from THREAD " +
                "inner join USER on THREAD.CREATOR_USER_ID = USER.ID " +
                "where THREAD.CREATOR_USER_ID = ?" +
                "order by CREATE_TIME desc limit 1";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(ThreadInformation.class),userId)
                .stream()
                .findFirst()
                .orElseThrow();
    }
}