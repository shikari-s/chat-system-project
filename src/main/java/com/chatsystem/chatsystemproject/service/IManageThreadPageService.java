package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;

import java.util.List;

public interface IManageThreadPageService {

        public List<ThreadInformation> selectBy();

    List<ThreadInformation> searchThread(String threadName);
}
