package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<User> select(){
        var sql = "select * from USER";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User selectLastBy(String userName){
        var sql = "select * from USER where NAME = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(User.class),userName)
                .stream()
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<User> selectByUserName(String userName){
        var sql = "select * from USER where NAME = ? ";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(User.class),userName);
    }

    @Override
    public int insert(String userName,String password){
        var sql = "insert into User(NAME,PASSWORD) values(?,?)";
        var n = jdbc.update(sql, userName, password);
        return n;
    }

}
