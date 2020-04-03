package com.colin.foodsource.service.impl;

import com.colin.foodsource.dao.CommentLikeCollectMapper;
import com.colin.foodsource.dao.CommentMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.CommentLikeCollect;
import com.colin.foodsource.service.CommentLikeCollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description: 评论点赞收藏服务接口实现类
 * Created by Colin on 2020/4/2 0002 下午 5:51.
 */
@Service
public class CommentLikeCollectServiceImpl implements CommentLikeCollectService {

    protected Logger logger = LoggerFactory.getLogger(CommentLikeCollectServiceImpl.class);

    @Autowired
    private CommentLikeCollectMapper commentLikeCollectMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 修改评论点赞状态
     *
     * @param userId
     * @param commentId
     * @return boolean
     * @author Colin
     * @date 2020/3/31 0031 下午 5:48
     */
    @Transactional
    @Override
    public boolean updateLikeState(String commentId, String userId, String likeState) throws AppException {
        Integer existsUser = userMapper.isExistsUser(userId);
        if (existsUser == null || existsUser.intValue() == 0) {
            throw new AppException("用户不存在！");
        }
        Integer existsComment = commentMapper.isExistsComment(commentId);
        if (existsComment == null || existsComment.intValue() == 0) {
            throw new AppException("评论不存在！");
        }
        Integer existsData = commentLikeCollectMapper.isExistsData(commentId, userId);
        boolean result = false;
        if (existsData == null || existsData.intValue() == 0) {
            CommentLikeCollect commentLikeCollect = new CommentLikeCollect();
            commentLikeCollect.setCommentId(commentId);
            commentLikeCollect.setoIdUser(userId);
            commentLikeCollect.setLikeState(likeState);
            commentLikeCollect.setLikeDate(new Date());
            result = commentLikeCollectMapper.addCommentLikeCollect(commentLikeCollect);
        } else {
            result = commentLikeCollectMapper.updateLikeState(commentId, userId, likeState);
        }
        return result;
    }

    /**
     * 修改评论收藏状态
     *
     * @param userId
     * @param commentId
     * @return boolean
     * @author Colin
     * @date 2020/3/31 0031 下午 5:48
     */
    @Transactional
    @Override
    public boolean updateCollectState(String commentId, String userId, String collectState) throws AppException {
        Integer existsUser = userMapper.isExistsUser(userId);
        if (existsUser == null || existsUser.intValue() == 0) {
            throw new AppException("用户不存在！");
        }
        Integer existsComment = commentMapper.isExistsComment(commentId);
        if (existsComment == null || existsComment.intValue() == 0) {
            throw new AppException("评论不存在！");
        }
        Integer existsData = commentLikeCollectMapper.isExistsData(commentId, userId);
        boolean result = false;
        if (existsData == null || existsData.intValue() == 0) {
            CommentLikeCollect commentLikeCollect = new CommentLikeCollect();
            commentLikeCollect.setCommentId(commentId);
            commentLikeCollect.setoIdUser(userId);
            commentLikeCollect.setCollectState(collectState);
            commentLikeCollect.setCollectDate(new Date());
            result = commentLikeCollectMapper.addCommentLikeCollect(commentLikeCollect);
        } else {
            result = commentLikeCollectMapper.updateCollectState(commentId, userId, collectState);
        }
        return result;
    }
}
