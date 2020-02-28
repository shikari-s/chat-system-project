package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;
import com.chatsystem.chatsystemproject.repository.IThreadInformationRepository;
import com.chatsystem.chatsystemproject.repository.IThreadRepository;
import com.chatsystem.chatsystemproject.session.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopPageService implements ITopPageService{

    private IThreadRepository threadRepository;
    private IThreadInformationRepository threadInformationRepository;

    @Autowired
    public TopPageService(IThreadRepository threadRepos,IThreadInformationRepository threadInformationRepos) {
        this.threadRepository = threadRepos;
        this.threadInformationRepository = threadInformationRepos;
    }

    //スレッドを作成するメソッド
    @Override
    public void createThread(String createThreadName) {
        threadRepository.insert(createThreadName, LocalDateTime.now(), MySession.get().getMyUserId());
    }

    //自分で作ったスレッドのリストを表示する
    @Override
    public List<ThreadInformation> getMyThreadList(Long i) {
        return threadInformationRepository.selectBy(i);
    }

    //作成したスレッドの情報を取得する
    @Override
    public ThreadInformation getThreadInformation(Long userId) {
        return threadInformationRepository.selectLastBy(userId);
    }

}
