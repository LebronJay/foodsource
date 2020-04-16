package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.dao.FoodEntryMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.FoodEntry;
import com.colin.foodsource.model.view.EntryDetail;
import com.colin.foodsource.service.FoodEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Description: 菜品词条信息服务接口实现类
 * Created by Colin on 2020/2/24 0024 上午 9:52.
 */
@Service
public class FoodEntryServiceImpl implements FoodEntryService {

    protected Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private FoodEntryMapper foodEntryMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public String addFoodEntry(FoodEntry foodEntry) throws AppException {
        String result = "";
        String userId = foodEntry.getoIdInput();
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if (StringUtils.isEmpty(loginNameByUserId)) {
            throw new AppException("用户不存在，不能保存词条信息！");
        }
        if (StringUtils.isEmpty(foodEntry.getEntryName())) {
            throw new AppException("请输入菜品名称！");
        }
        if (StringUtils.isEmpty(foodEntry.getEntryCuisine())) {
            throw new AppException("请选择菜系！");
        }
        if (StringUtils.isEmpty(foodEntry.getMainIngredients())) {
            throw new AppException("请选择主要食材！");
        }
        if (StringUtils.isEmpty(foodEntry.getEntryState())) {
            foodEntry.setEntryState("0");
        }
        String entryId = RandomUtils.getUUID();
        foodEntry.setFoodEntryId(entryId);
        foodEntry.setInputDate(new Date());
        boolean addFoodEntry = foodEntryMapper.addFoodEntry(foodEntry);
        if (addFoodEntry) {
            return entryId;
        }
        return result;
    }

    /**
     * 提交词条
     *
     * @param foodEntry
     * @return java.lang.String
     * @author Colin
     * @date 2020/4/9 0009 下午 4:48
     */
    @Transactional
    @Override
    public String commitEntry(FoodEntry foodEntry) throws AppException {
        String foodEntryId = foodEntry.getFoodEntryId();
        if (StringUtils.isEmpty(foodEntryId)) {
            foodEntry.setEntryState("1");
            String entryId = addFoodEntry(foodEntry);
            if (!StringUtils.isEmpty(entryId)) {
                return FoodConstants.SUCCESS;
            }
        } else {
            boolean result = foodEntryMapper.commitEntry(foodEntryId);
            if (result) {
                return FoodConstants.SUCCESS;
            }
        }
        return FoodConstants.FAIL;
    }

    /**
     * 获取词条详细信息
     *
     * @param foodEntryId
     * @param userId
     * @return com.colin.foodsource.model.view.EntryDetail
     * @author Colin
     * @date 2020/4/15 0015 下午 3:38
     */
    @Override
    public EntryDetail getEntryDetail(String foodEntryId, String userId) throws AppException {
        if (StringUtils.isEmpty(foodEntryId)) {
            throw new AppException("词条编号不能为空！");
        }
        EntryDetail entryDetail = foodEntryMapper.getEntryDetail(foodEntryId, userId);
        return entryDetail;
    }
}
