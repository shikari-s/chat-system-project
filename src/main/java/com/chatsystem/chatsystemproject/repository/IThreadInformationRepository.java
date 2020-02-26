package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;

import java.util.List;

public interface IThreadInformationRepository {
    List<ThreadInformation> select();

    List<ThreadInformation> selectLastTen();

    List<ThreadInformation> selectBy(Long i);

    ThreadInformation selectLastBy(Long userId);
}
