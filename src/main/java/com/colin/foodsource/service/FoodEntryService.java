package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.FoodEntry;
import com.colin.foodsource.model.view.EntryDetail;

/**
 * @Description: 菜品词条信息服务接口
 * Created by Colin on 2020/2/24 0024 上午 9:49.
 */
public interface FoodEntryService {

    String addFoodEntry(FoodEntry foodEntry) throws AppException;

    String commitEntry(FoodEntry foodEntry) throws AppException;

    EntryDetail getEntryDetail(String foodEntryId, String userId) throws AppException;
}
