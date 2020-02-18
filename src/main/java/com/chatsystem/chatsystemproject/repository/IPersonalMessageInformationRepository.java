package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.PersonalMessageInformation;

import java.util.List;

public interface
IPersonalMessageInformationRepository {
    List<PersonalMessageInformation> select();
}
