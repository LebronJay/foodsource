package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.Comment;

/**
 * @Description: 评论信息服务接口
 * Created by Colin on 2020/4/3 0003 上午 9:56.
 */
public interface CommentService {

    /**
     * 添加评论
     *
     * @param comment
     * @return java.lang.String
     * @author Colin
     * @date 2020/4/3 0003 上午 9:57
     */
    String addComment(Comment comment) throws AppException;
}
