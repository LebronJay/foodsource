package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.dao.FoodEntryMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.FoodEntry;
import com.colin.foodsource.service.FoodEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Description: 菜品词条信息服务接口实现类
 * Created by Colin on 2020/2/24 0024 上午 9:52.
 */
@Service
public class FoodEntryServiceImpl implements FoodEntryService{

    protected Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private FoodEntryMapper foodEntryMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String addFoodEntry(FoodEntry foodEntry) throws AppException {
        String result = "";
        String userId = foodEntry.getoIdInput();
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if(StringUtils.isEmpty(loginNameByUserId)){
            throw new AppException("用户不存在，不能保存文章信息！");
        }
        if(StringUtils.isEmpty(foodEntry.getEntryName())){
            throw new AppException("请输入菜品名称！");
        }
        if(StringUtils.isEmpty(foodEntry.getEntryCuisine())){
            throw new AppException("请选择菜系！");
        }
        if(StringUtils.isEmpty(foodEntry.getMainIngredients())){
            throw new AppException("请选择主要食材！");
        }
        if(foodEntry.getEditCount() == 0){
            foodEntry.setEditCount(1);
        }
        foodEntry.setFoodEntryId(RandomUtils.getUUID());
        foodEntry.setInputDate(new Date());
        boolean addFoodEntry = foodEntryMapper.addFoodEntry(foodEntry);
        if (addFoodEntry) {
            result = FoodConstants.SUCCESS;
        } else {
            result = FoodConstants.FAIL;
        }
        return result;
    }
}
