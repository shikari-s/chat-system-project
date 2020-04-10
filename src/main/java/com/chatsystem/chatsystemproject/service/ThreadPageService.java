package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.GlobalMessage;
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
    private IGlobalMessageInformationRepository globalMessageInformationRepository;
    private IGlobalMessageRepository globalMessageRepository;

    @Autowired
    public ThreadPageService(IGlobalMessageRepository globalMessageRepository, IGlobalMessageInformationRepository globalMessageInformationRepository){
        this.globalMessageRepository = globalMessageRepository;
        this.globalMessageInformationRepository = globalMessageInformationRepository;
    }

    @Override
    public List<GlobalMessageInformation> getSendMessageInformation(long threadId){
        return globalMessageInformationRepository.selectBy(threadId);
    }

    @Override
    public void sendMessage(String message, long threadId){
        globalMessageRepository.insert(new GlobalMessage(message, LocalDateTime.now(), MySession.get().getMyUserId(), threadId));
    }

    @Override
    public void deleteMessage(LocalDateTime postTime, long threadId){
        globalMessageRepository.delete(postTime, MySession.get().getMyUserId(), threadId);
    }
}
