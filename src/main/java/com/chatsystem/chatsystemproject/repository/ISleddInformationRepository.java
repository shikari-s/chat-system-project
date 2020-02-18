package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.SleddInformation;

import java.util.List;

public interface ISleddInformationRepository {
    List<SleddInformation> select();
}
