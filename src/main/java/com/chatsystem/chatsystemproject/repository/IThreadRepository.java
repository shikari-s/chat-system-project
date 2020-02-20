package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.Thread;

import java.util.List;

public interface IThreadRepository {
    List<Thread> select();
}
