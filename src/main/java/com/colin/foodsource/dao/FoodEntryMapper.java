package com.colin.foodsource.dao;

import com.colin.foodsource.model.FoodEntry;
import org.apache.ibatis.annotations.Mapper;
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
}
