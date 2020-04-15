package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.PersonalMessageInformation;

import java.time.LocalDateTime;
import java.util.List;

public interface IPersonalMessagePageService {
    List<PersonalMessageInformation> getSendMessageInformation(long receiverUserId);

    void sendMessage(String message, long receiverUserId);

    void deleteMessage(LocalDateTime postTime, long receiverUserId);
}
