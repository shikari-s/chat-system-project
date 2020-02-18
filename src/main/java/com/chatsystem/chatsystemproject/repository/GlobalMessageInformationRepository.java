package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GlobalMessageにUserとSleddを結合する
 */
@Repository
public class GlobalMessageInformationRepository implements IGlobalMessageInformationRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<GlobalMessageInformation> select(){
        var sql = "select USER.NAME as SENDER_USER_NAME,SLEDD.NAME as SLEDD_NAME,MESSAGE,POST_TIME from GLOBAL_MESSAGE "+
                "inner join USER on GLOBAL_MESSAGE.SENDER_USER_ID = USER.ID " +
                "inner join SLEDD on GLOBAL_MESSAGE.SLEDD_ID = SLEDD.ID ";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(GlobalMessageInformation.class));
    }
}
