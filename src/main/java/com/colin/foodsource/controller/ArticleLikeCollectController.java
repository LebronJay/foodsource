package com.colin.foodsource.controller;

import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.service.ArticleLikeCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description: 文章点赞收藏控制器
 * Created by Colin on 2020/3/22 0022 下午 5:48.
 */
@RestController
@RequestMapping("/articleLikeCollect")
public class ArticleLikeCollectController {

    @Autowired
    private ArticleLikeCollectService articleLikeCollectService;

    /**
     * 修改文章点赞状态
     *
     * @param data
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/4/1 0001 下午 5:52
     */
    @RequestMapping(value = "/updateLikeState", method = RequestMethod.POST)
    public Model updateLikeState(@RequestBody Map<String, Object> data) throws AppException {
        Model model = new ExtendedModelMap();
        String userId = data.get("userId").toString();
        String articleId = data.get("articleId").toString();
        String likeState = data.get("likeState").toString();
        boolean result = articleLikeCollectService.updateLikeState(articleId, userId, likeState);
        model.addAttribute("result", result);
        return model;
    }

    /**
     * 修改文章收藏状态
     *
     * @param data
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/4/1 0001 下午 5:52
     */
    @RequestMapping(value = "/updateCollectState", method = RequestMethod.POST)
    public Model updateCollectState(@RequestBody Map<String, Object> data) throws AppException {
        Model model = new ExtendedModelMap();
        String userId = data.get("userId").toString();
        String articleId = data.get("articleId").toString();
        String collectState = data.get("collectState").toString();
        boolean result = articleLikeCollectService.updateCollectState(articleId, userId, collectState);
        model.addAttribute("result", result);
        return model;
    }
}
