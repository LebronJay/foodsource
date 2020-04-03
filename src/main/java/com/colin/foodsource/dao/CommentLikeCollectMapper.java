package com.colin.foodsource.dao;

import com.colin.foodsource.model.CommentLikeCollect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 评论点赞收藏Mapper
 * Created by Colin on 2020/3/15 0015 下午 9:53.
 */
@Repository
@Mapper
public interface CommentLikeCollectMapper {

    /**
     * 添加评论点赞收藏
     *
     * @param commentLikeCollect
     * @return boolean
     * @author Colin
     * @date 2020/3/31 0031 下午 5:41
     */
    boolean addCommentLikeCollect(CommentLikeCollect commentLikeCollect);

    /**
     * 是否存在用户点赞收藏的评论
     *
     * @param commentId
     * @param userId
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/3/31 0031 下午 5:54
     */
    Integer isExistsData(@Param("commentId") String commentId, @Param("userId") String userId);

    /**
     * 更新点赞状态
     *
     * @param commentId
     * @param userId
     * @return boolean
     * @author Colin
     * @date 2020/4/1 0001 上午 11:51
     */
    boolean updateLikeState(@Param("commentId") String commentId, @Param("userId") String userId, @Param("likeState") String likeState);

    /**
     * 更新收藏状态
     *
     * @param commentId
     * @param userId
     * @return boolean
     * @author Colin
     * @date 2020/4/1 0001 上午 11:52
     */
    boolean updateCollectState(@Param("commentId") String commentId, @Param("userId") String userId, @Param("collectState") String collectState);
}
