package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.GlobalMessage;
import com.chatsystem.chatsystemproject.bean.PersonalMessage;
import com.chatsystem.chatsystemproject.bean.PersonalMessageInformation;
import com.chatsystem.chatsystemproject.repository.IPersonalMessageInformationRepository;
import com.chatsystem.chatsystemproject.repository.IPersonalMessageRepository;
import com.chatsystem.chatsystemproject.session.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonalMessagePageService implements IPersonalMessagePageService{
    private IPersonalMessageInformationRepository personalMessageInformationRepository;
    private IPersonalMessageRepository personalMessageRepository;

    @Autowired
    public PersonalMessagePageService(IPersonalMessageInformationRepository personalMessageInformationRepository, IPersonalMessageRepository personalMessageRepository){
        this.personalMessageInformationRepository = personalMessageInformationRepository;
        this.personalMessageRepository = personalMessageRepository;
    }

    @Override
    public List<PersonalMessageInformation> getSendMessageInformation(long receiverUserId){
        return personalMessageInformationRepository.selectBy(receiverUserId);
    }

    @Override
    public void sendMessage(String message, long receiverUserId){
        personalMessageRepository.insert(new PersonalMessage(message, LocalDateTime.now(), MySession.get().getMyUserId(), receiverUserId));
    }
}
