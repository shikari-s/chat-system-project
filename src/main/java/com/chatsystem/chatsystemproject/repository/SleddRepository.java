package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.Sledd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SleddRepository implements ISleddRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Sledd>select(){
        var sql = "select * from SLEDD";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(Sledd.class));
    }
}
