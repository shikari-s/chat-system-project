package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;
import com.chatsystem.chatsystemproject.repository.IGlobalMessageInformationRepository;
import com.chatsystem.chatsystemproject.repository.IGlobalMessageRepository;
import com.chatsystem.chatsystemproject.session.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ThreadPageService implements IThreadPageService {
    private IGlobalMessageInformationRepository  globalMessageInformationRepos;
    private IGlobalMessageRepository globalMessageRepos;

    @Autowired
    public ThreadPageService(IGlobalMessageRepository globalMessageRepos, IGlobalMessageInformationRepository globalMessageInformationRepos){
        this.globalMessageRepos = globalMessageRepos;
        this.globalMessageInformationRepos = globalMessageInformationRepos;
    }

    @Override
    public List<GlobalMessageInformation> getPostedMessageInformation(long threadId){
        return globalMessageInformationRepos.selectBy(threadId);
    }

    @Override
    public void sendMessage(String message, long threadId){
        globalMessageRepos.insert(message, LocalDateTime.now(), MySession.get().getMyUserId(), threadId);
    }
}
