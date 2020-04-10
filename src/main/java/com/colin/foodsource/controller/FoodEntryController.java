package com.colin.foodsource.controller;

import com.colin.foodsource.common.utils.JackSonUtils;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.FoodEntry;
import com.colin.foodsource.service.FoodEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Description: 菜品词条信息控制器
 * Created by Colin on 2020/2/24 0024 上午 10:02.
 */
@RestController
@RequestMapping("/entry")
public class FoodEntryController {

    @Autowired
    private FoodEntryService foodEntryService;

    /**
     * 添加菜品词条(json格式提交参数)
     *
     * @param json
     * @return java.lang.String
     * @author Colin
     * @date 2020/2/24 0024 上午 10:03
     */
    @RequestMapping(value = "/backupNewEntry", method = RequestMethod.POST)
    public Model backupNewEntry(@RequestBody String json) throws IOException, AppException {
        Model model = new ExtendedModelMap();
        FoodEntry foodEntry = (FoodEntry) JackSonUtils.json2Object(json, FoodEntry.class);
        String entryId = foodEntryService.addFoodEntry(foodEntry);
        model.addAttribute("entryId", entryId);
        return model;
    }

    /**
     * 提交词条
     *
     * @param json
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/4/9 0009 下午 5:00
     */
    @RequestMapping(value = "/commitEntry", method = RequestMethod.POST)
    public Model commitEntry(@RequestBody String json) throws IOException, AppException {
        Model model = new ExtendedModelMap();
        FoodEntry foodEntry = (FoodEntry) JackSonUtils.json2Object(json, FoodEntry.class);
        String result = foodEntryService.commitEntry(foodEntry);
        model.addAttribute("result", result);
        return model;
    }
}
