package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.FoodEntry;

/**
 * @Description: 菜品词条信息服务接口
 * Created by Colin on 2020/2/24 0024 上午 9:49.
 */
public interface FoodEntryService {

    /**
     * 添加菜品词条
     *
     * @param foodEntry
     * @return java.lang.String
     * @author Colin
     * @date 2020/2/24 0024 上午 9:51
     */
    String addFoodEntry(FoodEntry foodEntry) throws AppException;
}
