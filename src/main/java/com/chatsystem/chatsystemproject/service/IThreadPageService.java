package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;

import java.util.List;

public interface IThreadPageService {
    List<GlobalMessageInformation> getPostedMessageInformation(long threadId);

    void sendMessage(String message, long threadId);
}
