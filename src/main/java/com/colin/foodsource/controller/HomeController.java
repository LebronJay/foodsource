package com.colin.foodsource.controller;

import com.colin.foodsource.common.annotation.NoneAuth;
import com.colin.foodsource.model.view.HomeArticle;
import com.colin.foodsource.model.view.HomeEntry;
import com.colin.foodsource.service.HomeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description: 首页信息
 * Created by Colin on 2020/3/16 0016 下午 1:25.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    /**
     * 获取首页显示信息
     * @param data
     * @return  org.springframework.ui.Model
     * @author  Colin
     * @date  2020/3/25 0025 上午 10:14
     */
    @NoneAuth
    @RequestMapping(value = "/getHomeDetail", method = RequestMethod.POST)
    public Model getUserList(@RequestBody Map<String, Object> data) throws JsonProcessingException {
        Model model = new ExtendedModelMap();
        String userId = (String) data.get("userId");
        List<HomeArticle> articleList = homeService.getArticleList(userId);
        List<HomeEntry> entryList = homeService.getEntryList(userId);
        model.addAttribute("articleList", articleList);
        model.addAttribute("entryList", entryList);
        return model;
    }
}
