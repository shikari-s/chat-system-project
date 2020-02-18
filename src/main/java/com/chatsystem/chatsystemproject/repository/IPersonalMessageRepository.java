package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.PersonalMessage;

import java.util.List;

public interface IPersonalMessageRepository {
    List<PersonalMessage> select();
}
