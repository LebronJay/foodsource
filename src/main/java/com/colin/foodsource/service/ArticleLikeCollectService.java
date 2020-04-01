package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;

/**
 * @Description: 文章点赞收藏服务接口
 * Created by Colin on 2020/3/20 0020 上午 9:37.
 */
public interface ArticleLikeCollectService {

    boolean updateLikeState(String articleId, String userId, String likeState) throws AppException;

    boolean updateCollectState(String articleId, String userId, String collectState) throws AppException;
}
