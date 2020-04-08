package com.colin.foodsource.controller;

import com.colin.foodsource.common.utils.JackSonUtils;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.EntryEditRecord;
import com.colin.foodsource.service.EntryEditRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 词条编辑控制器
 * Created by Colin on 2020/4/8 0008 上午 11:00.
 */
@RestController
@RequestMapping("/entryRecord")
public class EntryEditRecordController {

    @Autowired
    private EntryEditRecordService entryEditRecordService;

    /**
     * 添加词条记录
     *
     * @param json
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/4/8 0008 上午 11:02
     */
    @RequestMapping(value = "/addEntryEditRecord", method = RequestMethod.POST)
    public Model addEntryEditRecord(@RequestBody String json) throws IOException, AppException {
        Model model = new ExtendedModelMap();
        EntryEditRecord entryEditRecord = (EntryEditRecord) JackSonUtils.json2Object(json, EntryEditRecord.class);
        String result = entryEditRecordService.addEntryEditRecord(entryEditRecord);
        model.addAttribute("recordId", result);
        return model;
    }

    /**
     * 提交记录
     *
     * @param json
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/4/8 0008 上午 11:03
     */
    @RequestMapping(value = "/commitRecord", method = RequestMethod.POST)
    public Model commitRecord(@RequestBody String json) throws IOException, AppException {
        Model model = new ExtendedModelMap();
        EntryEditRecord entryEditRecord = (EntryEditRecord) JackSonUtils.json2Object(json, EntryEditRecord.class);
        String result = entryEditRecordService.commitRecord(entryEditRecord);
        model.addAttribute("result", result);
        return model;
    }
}
