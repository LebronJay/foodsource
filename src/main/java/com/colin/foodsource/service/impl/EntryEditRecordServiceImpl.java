package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.dao.EntryEditRecordMapper;
import com.colin.foodsource.dao.FoodEntryMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.EntryEditRecord;
import com.colin.foodsource.service.EntryEditRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 词条编辑记录服务接口实现类
 * Created by Colin on 2020/4/8 0008 上午 10:38.
 */
@Service
public class EntryEditRecordServiceImpl implements EntryEditRecordService {

    protected Logger logger = LoggerFactory.getLogger(EntryEditRecordServiceImpl.class);

    @Autowired
    private EntryEditRecordMapper entryEditRecordMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FoodEntryMapper foodEntryMapper;

    /**
     * 添加编辑记录
     *
     * @param entryEditRecord
     * @return java.lang.String
     * @author Colin
     * @date 2020/4/8 0008 上午 10:46
     */
    @Transactional
    @Override
    public String addEntryEditRecord(EntryEditRecord entryEditRecord) throws AppException {
        Integer existsUser = userMapper.isExistsUser(entryEditRecord.getoIdInput());
        if (existsUser == null || existsUser.intValue() == 0) {
            throw new AppException("用户不存在！");
        }
        Integer existsEntry = foodEntryMapper.isExistsEntry(entryEditRecord.getFoodEntryId());
        if (existsEntry == null || existsEntry.intValue() == 0) {
            throw new AppException("词条不存在！");
        }
        if (StringUtils.isEmpty(entryEditRecord.getEntryName())) {
            throw new AppException("请输入菜品名称！");
        }
        if (StringUtils.isEmpty(entryEditRecord.getEntryCuisine())) {
            throw new AppException("请选择菜系！");
        }
        if (StringUtils.isEmpty(entryEditRecord.getMainIngredients())) {
            throw new AppException("请选择主要食材！");
        }
        String recordId = RandomUtils.getUUID();
        entryEditRecord.setEntryEditRecordId(recordId);
        entryEditRecord.setEditDate(new Date());
        if (StringUtils.isEmpty(entryEditRecord.getEntryState())) {
            entryEditRecord.setEntryState("0");
        }
        boolean record = entryEditRecordMapper.addEntryEditRecord(entryEditRecord);
        if (record) {
            return recordId;
        }
        return null;
    }

    /**
     * 提交记录
     *
     * @param entryEditRecord
     * @return java.lang.String
     * @author Colin
     * @date 2020/4/8 0008 上午 10:48
     */
    @Transactional
    @Override
    public String commitRecord(EntryEditRecord entryEditRecord) throws AppException {
        String recordId = entryEditRecord.getEntryEditRecordId();
        if (StringUtils.isEmpty(recordId)) {
            entryEditRecord.setEntryState("1");
            String addEntryEditRecord = addEntryEditRecord(entryEditRecord);
            if (!StringUtils.isEmpty(addEntryEditRecord)) {
                return FoodConstants.SUCCESS;
            }
        } else {
            boolean record = entryEditRecordMapper.commitRecord(recordId);
            if (record) {
                return FoodConstants.SUCCESS;
            }
        }
        return FoodConstants.FAIL;
    }
}
