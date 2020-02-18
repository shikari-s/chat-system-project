package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.BlockedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlockedUserRepository implements IBlockedUserRepository{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<BlockedUser> select() {
        var sql = "select * from BLOCKED_USER";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(BlockedUser.class));
    }
}