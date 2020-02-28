package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;
import com.chatsystem.chatsystemproject.bean.PersonalMessageInformation;
import com.chatsystem.chatsystemproject.session.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PersonalMessageにUserを結合する(senderUserIdとreceiverUserIdの2つ分)
 */
@Repository
public class PersonalMessageInformationRepository implements IPersonalMessageInformationRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<PersonalMessageInformation> select() {
        var sql = "select SENDER.NAME as SENDER_USER_NAME, RECEIVER.NAME as RECEIVER_USER_NAME,MESSAGE,POST_TIME from PERSONAL_MESSAGE " +
                "inner join USER as SENDER on PERSONAL_MESSAGE.SENDER_USER_ID = SENDER.ID " +
                "inner join USER as RECEIVER on PERSONAL_MESSAGE.RECEIVER_USER_ID = RECEIVER.ID";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(PersonalMessageInformation.class));
    }

    @Override
    public List<PersonalMessageInformation> selectBy(long receiverUserId) {
        var sql = "select SENDER.NAME as SENDER_USER_NAME, RECEIVER.NAME as RECEIVER_USER_NAME,MESSAGE,POST_TIME from PERSONAL_MESSAGE " +
                "inner join USER as SENDER on PERSONAL_MESSAGE.SENDER_USER_ID = SENDER.ID " +
                "inner join USER as RECEIVER on PERSONAL_MESSAGE.RECEIVER_USER_ID = RECEIVER.ID " +
                "where PERSONAL_MESSAGE.RECEIVER_USER_ID = ? and PERSONAL_MESSAGE.RECEIVER_USER_ID = ?";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(PersonalMessageInformation.class), MySession.get().getMyUserId(), receiverUserId);
    }
}

