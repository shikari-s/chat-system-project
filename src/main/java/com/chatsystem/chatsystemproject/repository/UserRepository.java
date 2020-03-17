package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public User selectBy(String userName) {
        return null;
    }
    //classのabstractを消したらこれが実装された

    @Override
    public User selectLastBy(String userName){
        var sql = "select * from USER where NAME = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(User.class),userName)
                .stream()
                .findFirst()
                .orElseThrow();
    }

    @Override
    public User selectBy(long userId){
        var sql = "select * from USER where Id = ?;";
        return  jdbc.query(sql,new BeanPropertyRowMapper<>(User.class),userId)
                .stream()
                .findFirst()
                .orElseThrow();
    }

    @Override
    public int insert(String userName,String password){
        var sql = "insert into User(NAME,PASSWORD) values(?,?)";
        var n = jdbc.update(sql, userName, password);
        return n;

    }

    @Override
    public void update(String userName, String password) {

    }

    @Override
    public void update(String userName, String password, long userId) {
        var sql = "UPDATE USER SET NUME=userName,PASSWORD=password WHERE ID=userId";
        jdbc.update(sql, userName, password);

    }

    @Override
    public List<User> selectByUserName(String userName) {
        return null;
    }
}
