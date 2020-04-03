package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;

/**
 * @Description: 评论点赞收藏服务接口
 * Created by Colin on 2020/4/2 0002 下午 5:50.
 */
public interface CommentLikeCollectService {

    boolean updateLikeState(String commentId, String userId, String likeState) throws AppException;

    boolean updateCollectState(String commentId, String userId, String collectState) throws AppException;
}
