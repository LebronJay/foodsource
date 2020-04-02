package com.colin.foodsource.dao;

import com.colin.foodsource.model.ArticleLikeCollect;
import com.colin.foodsource.model.EntryLikeCollect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 词条点赞收藏Mapper
 * Created by Colin on 2020/3/15 0015 下午 9:53.
 */
@Repository
@Mapper
public interface EntryLikeCollectMapper {

    /**
     * 添加词条点赞收藏
     *
     * @param articleLikeCollect
     * @return boolean
     * @author Colin
     * @date 2020/4/1 0001 下午 5:32
     */
    boolean addEntryLikeCollect(EntryLikeCollect entryLikeCollect);

    /**
     * 是否存在用户点赞收藏的词条
     *
     * @param foodEntryId
     * @param userId
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/4/1 0001 下午 5:32
     */
    Integer isExistsData(@Param("foodEntryId") String foodEntryId, @Param("userId") String userId);

    /**
     * 更新点赞状态
     *
     * @param articleId
     * @param userId
     * @param likeState
     * @return boolean
     * @author Colin
     * @date 2020/4/1 0001 下午 5:31
     */
    boolean updateLikeState(@Param("foodEntryId") String foodEntryId, @Param("userId") String userId, @Param("likeState") String likeState);

    /**
     * 更新收藏状态
     *
     * @param articleId
     * @param userId
     * @param collectState
     * @return boolean
     * @author Colin
     * @date 2020/4/1 0001 下午 5:32
     */
    boolean updateCollectState(@Param("foodEntryId") String foodEntryId, @Param("userId") String userId, @Param("collectState") String collectState);
}
