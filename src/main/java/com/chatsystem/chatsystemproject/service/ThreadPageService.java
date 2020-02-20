package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;
import com.chatsystem.chatsystemproject.repository.IGlobalMessageInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadPageService implements IThreadPageService {

    @Autowired
    private IGlobalMessageInformationRepository  globalMessageInformationRepository;

    @Override
    public List<GlobalMessageInformation> getPostedMessageInformation(long threadId){
        return globalMessageInformationRepository.selectBy(threadId);
    }

}
