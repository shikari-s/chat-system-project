package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.PersonalMessage;

import java.time.LocalDateTime;
import java.util.List;

public interface IPersonalMessageRepository {
    List<PersonalMessage> select();

    void insert(PersonalMessage personalMessage);

    void delete(LocalDateTime postTime, long senderUserId, long receiverUserId);
}
