package com.colin.foodsource.service.impl;

import com.colin.foodsource.dao.EntryLikeCollectMapper;
import com.colin.foodsource.dao.FoodEntryMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.EntryLikeCollect;
import com.colin.foodsource.service.EntryLikeCollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description: 词条点赞收藏服务接口实现类
 * Created by Colin on 2020/4/1 0001 下午 5:35.
 */
@Service
public class EntryLikeCollectServiceImpl implements EntryLikeCollectService{

    protected Logger logger = LoggerFactory.getLogger(EntryLikeCollectServiceImpl.class);

    @Autowired
    private EntryLikeCollectMapper entryLikeCollectMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FoodEntryMapper foodEntryMapper;

    @Transactional
    @Override
    public boolean updateLikeState(String foodEntryId, String userId, String likeState) throws AppException {
        Integer existsUser = userMapper.isExistsUser(userId);
        if (existsUser == null || existsUser.intValue() == 0) {
            throw new AppException("用户不存在！");
        }
        Integer existsEntry = foodEntryMapper.isExistsEntry(foodEntryId);
        if (existsEntry == null || existsEntry.intValue() == 0) {
            throw new AppException("词条不存在！");
        }
        Integer existsData = entryLikeCollectMapper.isExistsData(foodEntryId, userId);
        boolean result = false;
        if (existsData == null || existsData.intValue() == 0) {
            EntryLikeCollect entryLikeCollect = new EntryLikeCollect();
            entryLikeCollect.setFoodEntryId(foodEntryId);
            entryLikeCollect.setoIdUser(userId);
            entryLikeCollect.setLikeState(likeState);
            entryLikeCollect.setLikeDate(new Date());
            result = entryLikeCollectMapper.addEntryLikeCollect(entryLikeCollect);
        } else {
            result = entryLikeCollectMapper.updateLikeState(foodEntryId, userId, likeState);
        }
        return result;
    }

    @Transactional
    @Override
    public boolean updateCollectState(String foodEntryId, String userId, String collectState) throws AppException {
        Integer existsUser = userMapper.isExistsUser(userId);
        if (existsUser == null || existsUser.intValue() == 0) {
            throw new AppException("用户不存在！");
        }
        Integer existsEntry = foodEntryMapper.isExistsEntry(foodEntryId);
        if (existsEntry == null || existsEntry.intValue() == 0) {
            throw new AppException("词条不存在！");
        }
        Integer existsData = entryLikeCollectMapper.isExistsData(foodEntryId, userId);
        boolean result = false;
        if (existsData == null || existsData.intValue() == 0) {
            EntryLikeCollect entryLikeCollect = new EntryLikeCollect();
            entryLikeCollect.setFoodEntryId(foodEntryId);
            entryLikeCollect.setoIdUser(userId);
            entryLikeCollect.setCollectState(collectState);
            entryLikeCollect.setCollectDate(new Date());
            result = entryLikeCollectMapper.addEntryLikeCollect(entryLikeCollect);
        } else {
            result = entryLikeCollectMapper.updateCollectState(foodEntryId, userId, collectState);
        }
        return result;
    }
}
