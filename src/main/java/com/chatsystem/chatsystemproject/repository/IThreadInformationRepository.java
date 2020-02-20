package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;

import java.util.List;

public interface IThreadInformationRepository {
    List<ThreadInformation> select();
}
