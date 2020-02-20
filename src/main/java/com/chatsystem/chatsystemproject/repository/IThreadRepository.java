package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.Thread;

import java.time.LocalDateTime;
import java.util.List;

public interface IThreadRepository {
    List<Thread> select();

    /**
     * @param createThreadName スレッド名
     * @param createTime　スレッド作成時間
     * @param creatorUserId　スレッド作成者のid
     */
    void insert(String createThreadName, LocalDateTime createTime, long creatorUserId);
}
