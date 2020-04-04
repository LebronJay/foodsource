package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.dao.CommentMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.Comment;
import com.colin.foodsource.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description: 评论信息服务接口实现类
 * Created by Colin on 2020/4/3 0003 上午 9:59.
 */
@Service
public class CommentServiceImpl implements CommentService {

    protected Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加评论
     *
     * @param comment
     * @return java.lang.String
     * @author Colin
     * @date 2020/4/3 0003 上午 9:59
     */
    @Transactional
    @Override
    public String addComment(Comment comment) throws AppException {
        String userId = comment.getoIdUser();
        Integer existsUser = userMapper.isExistsUser(userId);
        if (existsUser == null || existsUser.intValue() == 0) {
            throw new AppException("用户不存在，不能添加评论！");
        }
        Integer existsCommentObj = commentMapper.isExistsCommentObj(comment.getParentId());
        if (existsCommentObj == null || existsCommentObj.intValue() == 0) {
            throw new AppException("评论对象已经删除，不能添加评论！");
        }
        String commentId = RandomUtils.getUUID();
        comment.setCommentId(commentId);
        comment.setInputDate(new Date());
        comment.setLastModDate(new Date());
        boolean addComment = commentMapper.addComment(comment);
        if (addComment) {
            return commentId;
        }
        return null;
    }
}
