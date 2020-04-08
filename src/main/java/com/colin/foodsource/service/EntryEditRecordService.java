package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.EntryEditRecord;

/**
 * @Description: 词条编辑记录服务接口
 * Created by Colin on 2020/4/1 0001 下午 5:34.
 */
public interface EntryEditRecordService {

    String addEntryEditRecord(EntryEditRecord entryEditRecord) throws AppException;

    String commitRecord(EntryEditRecord entryEditRecord) throws AppException;
}
