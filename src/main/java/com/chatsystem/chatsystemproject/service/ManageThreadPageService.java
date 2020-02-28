package com.chatsystem.chatsystemproject.service;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;
import com.chatsystem.chatsystemproject.repository.IThreadInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageThreadPageService implements IManageThreadPageService{

    @Autowired
    private IThreadInformationRepository threadInformationRepository;

    public ManageThreadPageService(IThreadInformationRepository threadInformationRepository){
        this.threadInformationRepository = threadInformationRepository;
    }

    @Override
    public List<ThreadInformation> selectBy(){
        var recentlySleddList = threadInformationRepository.selectLastTen();
        return recentlySleddList;
    }

    @Override
    public List<ThreadInformation> searchThread(String threadName){
        var searchedThreadList = threadInformationRepository.selectBy(threadName);
        return searchedThreadList;
    }

}
