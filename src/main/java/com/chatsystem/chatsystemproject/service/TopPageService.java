package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.repository.IThreadRepository;
import com.chatsystem.chatsystemproject.session.MySession;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopPageService implements ITopPageService{

    private IThreadRepository threadRepos;

    @Autowired
    public TopPageService(IThreadRepository threadRepos) {
        this.threadRepos = threadRepos;
    }

    //スレッドを作成するメソッド
    @Override
    public void createThread(String createThreadName) {
        threadRepos.insert(createThreadName, LocalDateTime.now(), MySession.get().getMyUserId());
    }
}
