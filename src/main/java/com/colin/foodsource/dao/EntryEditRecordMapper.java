package com.colin.foodsource.dao;

import com.colin.foodsource.model.EntryEditRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description: 词条编辑记录Mapper
 * Created by Colin on 2020/3/15 0015 下午 9:53.
 */
@Repository
@Mapper
public interface EntryEditRecordMapper {

    /**
     * 添加词条编辑记录
     *
     * @param entryEditRecord
     * @return boolean
     * @author Colin
     * @date 2020/4/8 0008 上午 10:35
     */
    boolean addEntryEditRecord(EntryEditRecord entryEditRecord);

    /**
     * 提交记录
     *
     * @param recordId
     * @return boolean
     * @author Colin
     * @date 2020/4/8 0008 上午 10:52
     */
    boolean commitRecord(String recordId);
}
