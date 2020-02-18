package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.SleddInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SleddにUserを結合
 */
@Repository
public class SleddInformationRepository implements ISleddInformationRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<SleddInformation> select(){
        var sql = "select SLEDD.ID as SLEDD_ID,SLEDD.NAME as SLEDD_NAME,CREATE_TIME,USER.NAME as CREATOR_USER_NAME from SLEDD " +
                "inner join USER on SLEDD.CREATOR_USER_ID = USER.ID";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(SleddInformation.class));
    }
}
