package com.chatsystem.chatsystemproject.repository;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;

import java.util.List;

public interface IThreadInformationRepository {
    List<ThreadInformation> select();

    List<ThreadInformation> selectLastTen();

    /**
     * @param userId
     * @return 自身が作成したスレッドのリスト
     */
    List<ThreadInformation> selectBy(Long userId);

    //最新の10件を書き換えるときに使用するsql
    List<ThreadInformation> selectBy(String threadName);

    /**
     * スレッドを作成したときのスレッドの情報を取得
     * @param userId
     * @return 作成したスレッド情報
     */
    ThreadInformation selectLastBy(Long userId);
}
