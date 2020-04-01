package com.colin.foodsource.dao;

import com.colin.foodsource.model.ArticleLikeCollect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 文章点赞收藏Mapper
 * Created by Colin on 2020/3/15 0015 下午 9:53.
 */
@Repository
@Mapper
public interface ArticleLikeCollectMapper {

    /**
     * 添加文章点赞收藏
     *
     * @param articleLikeCollect
     * @return boolean
     * @author Colin
     * @date 2020/3/31 0031 下午 5:41
     */
    boolean addArticleLikeCollect(ArticleLikeCollect articleLikeCollect);

    /**
     * 是否存在用户点赞收藏的文章
     *
     * @param articleId
     * @param userId
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/3/31 0031 下午 5:54
     */
    Integer isExistsData(@Param("articleId")String articleId, @Param("userId")String userId);

    /**
     * 更新点赞状态
     *
     * @param articleId
     * @param userId
     * @return boolean
     * @author Colin
     * @date 2020/4/1 0001 上午 11:51
     */
    boolean updateLikeState(@Param("articleId")String articleId, @Param("userId")String userId, @Param("likeState")String likeState);

    /**
     * 更新收藏状态
     *
     * @param articleId
     * @param userId
     * @return boolean
     * @author Colin
     * @date 2020/4/1 0001 上午 11:52
     */
    boolean updateCollectState(@Param("articleId")String articleId, @Param("userId")String userId, @Param("collectState")String collectState);
}
