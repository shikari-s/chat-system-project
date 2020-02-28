package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;

import java.util.List;

public interface ITopPageService {
    void createThread(String createThreadName);

    List<ThreadInformation> getMyThreadList(Long i);

    ThreadInformation getThreadInformation(Long myUserId);
}
