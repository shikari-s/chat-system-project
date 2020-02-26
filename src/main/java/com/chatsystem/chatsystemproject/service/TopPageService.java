package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.Thread;
import com.chatsystem.chatsystemproject.bean.ThreadInformation;
import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.repository.IThreadInformationRepository;
import com.chatsystem.chatsystemproject.repository.IThreadRepository;
import com.chatsystem.chatsystemproject.session.MySession;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopPageService implements ITopPageService{

    private IThreadRepository threadRepos;
    //変更
    private IThreadInformationRepository threadInformationRepos;

    //変更
    @Autowired
    public TopPageService(IThreadRepository threadRepos,IThreadInformationRepository threadInformationRepos) {
        this.threadRepos = threadRepos;
        this.threadInformationRepos = threadInformationRepos;
    }

    //スレッドを作成するメソッド
    @Override
    public void createThread(String createThreadName) {
        threadRepos.insert(createThreadName, LocalDateTime.now(), MySession.get().getMyUserId());
        //変更
        //return threadInformationRepos.select();
    }

    //自分で作ったスレッドのリストを表示する
    @Override
    public List<ThreadInformation> myCreatedThreadList(Long i) {
        return threadInformationRepos.selectBy(i);
    }

    @Override
    public ThreadInformation getThreadInformation(Long userId) {
        return threadInformationRepos.selectLastBy(userId);
    }
}
