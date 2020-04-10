package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;

import java.time.LocalDateTime;
import java.util.List;

public interface IThreadPageService {
    List<GlobalMessageInformation> getSendMessageInformation(long threadId);

    void sendMessage(String message, long threadId);

    void deleteMessage(LocalDateTime postTime, long threadId);
}
