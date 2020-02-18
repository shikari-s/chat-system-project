package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;

import java.util.List;

public interface IGlobalMessageInformationRepository {
    List<GlobalMessageInformation> select();
}
