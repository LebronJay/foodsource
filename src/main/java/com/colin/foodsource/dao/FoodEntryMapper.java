package com.colin.foodsource.dao;

import com.colin.foodsource.model.FoodEntry;
import com.colin.foodsource.model.view.EntryDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 菜品词条信息Mapper
 * Created by Colin on 2020/2/24 0024 上午 9:46.
 */
@Repository
@Mapper
public interface FoodEntryMapper {

    /**
     * 添加菜品词条
     *
     * @param foodEntry
     * @return boolean
     * @author Colin
     * @date 2020/2/24 0024 上午 9:49
     */
    boolean addFoodEntry(FoodEntry foodEntry);

    /**
     * 词条是否存在
     *
     * @param foodEntryId
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/4/1 0001 下午 5:45
     */
    Integer isExistsEntry(String foodEntryId);

    /**
     * 提交词条
     *
     * @param foodEntryId
     * @return boolean
     * @author Colin
     * @date 2020/4/9 0009 下午 4:46
     */
    boolean commitEntry(String foodEntryId);

    /**
     * 获取词条详细信息
     *
     * @param foodEntryId
     * @param userId
     * @return com.colin.foodsource.model.view.EntryDetail
     * @author Colin
     * @date 2020/4/15 0015 下午 3:33
     */
    EntryDetail getEntryDetail(@Param("foodEntryId") String foodEntryId, @Param("userId") String userId);
}
