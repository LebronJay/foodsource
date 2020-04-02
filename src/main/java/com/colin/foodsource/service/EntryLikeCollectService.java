package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;

/**
 * @Description: 词条点赞收藏服务接口
 * Created by Colin on 2020/4/1 0001 下午 5:34.
 */
public interface EntryLikeCollectService {

    boolean updateLikeState(String foodEntryId, String userId, String likeState) throws AppException;

    boolean updateCollectState(String foodEntryId, String userId, String collectState) throws AppException;
}
