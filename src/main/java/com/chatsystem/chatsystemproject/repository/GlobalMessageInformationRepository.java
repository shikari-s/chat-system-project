package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GlobalMessageにUserとThreadを結合する
 */
@Repository
public class GlobalMessageInformationRepository implements IGlobalMessageInformationRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<GlobalMessageInformation> select(){
        var sql = "select USER.NAME as SENDER_USER_NAME,THREAD.NAME as Thread_NAME,MESSAGE,POST_TIME from GLOBAL_MESSAGE "+
                "inner join USER on GLOBAL_MESSAGE.SENDER_USER_ID = USER.ID " +
                "inner join THREAD on GLOBAL_MESSAGE.THREAD_ID = THREAD.ID ";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(GlobalMessageInformation.class));
    }

    @Override
    public List<GlobalMessageInformation> selectBy(long threadId){
        var sql = "select USER.NAME as SENDER_USER_NAME,THREAD.NAME as Thread_NAME,MESSAGE,POST_TIME from GLOBAL_MESSAGE "+
                "inner join USER on GLOBAL_MESSAGE.SENDER_USER_ID = USER.ID " +
                "inner join THREAD on GLOBAL_MESSAGE.THREAD_ID = THREAD.ID " +
                "where THREAD_ID = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(GlobalMessageInformation.class),threadId);
    }
}
