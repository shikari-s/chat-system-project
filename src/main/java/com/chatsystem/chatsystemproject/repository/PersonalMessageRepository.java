package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessage;
import com.chatsystem.chatsystemproject.bean.PersonalMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PersonalMessageRepository implements IPersonalMessageRepository{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<PersonalMessage> select(){
        var sql = "select * from PERSONAL_MESSAGE";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(PersonalMessage.class));
    }

    @Override
    public void insert(PersonalMessage personalMessage){
        var sql = "insert into PERSONAL_MESSAGE(MESSAGE, POST_TIME, SENDER_USER_ID, RECEIVER_USER_ID) values (?, ?, ?, ?)";
        jdbc.update(sql, personalMessage.getMessage(), personalMessage.getPostTime(), personalMessage.getSenderUserId(), personalMessage.getReceiverUserId());
    }

    @Override
    public void delete(LocalDateTime postTime, long senderUserId, long receiverUserId){
        var sql = "delete from PERSONAL_MESSAGE where (POST_TIME, SENDER_USER_ID, RECEIVER_USER_ID) = (?,?,?)";
        jdbc.update(sql, postTime, senderUserId, receiverUserId);
    }
}
