package com.colin.foodsource.dao;

import com.colin.foodsource.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description: 评论点赞收藏Mapper
 * Created by Colin on 2020/3/15 0015 下午 9:53.
 */
@Repository
@Mapper
public interface CommentMapper {

    /**
     * 添加评论
     *
     * @param comment
     * @return boolean
     * @author Colin
     * @date 2020/4/3 0003 上午 9:50
     */
    boolean addComment(Comment comment);

    /**
     * 评论是否存在
     *
     * @param commentId
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/4/3 0003 上午 9:55
     */
    Integer isExistsComment(String commentId);

    /**
     * 评论对象是否存在
     *
     * @param parentId
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/4/3 0003 上午 11:00
     */
    Integer isExistsCommentObj(String parentId);
}
