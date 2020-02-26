package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;

import java.util.List;

public interface IThreadInformationRepository {
    List<ThreadInformation> select();

    List<ThreadInformation> selectLastTen();

    //最新の10件を書き換えるときに使用するsql
    List<ThreadInformation> selectBy(String threadName);
}
