package com.colin.foodsource.controller;

import com.colin.foodsource.common.utils.JackSonUtils;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.Article;
import com.colin.foodsource.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Description: 文章信息控制器
 * Created by Colin on 2020/2/20 0020 上午 10:19.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章(json格式提交参数)
     *
     * @param json
     * @return java.lang.String
     * @author Colin
     * @date 2020/2/20 0020 上午 10:20
     */
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public Model addArticle(@RequestBody String json) throws IOException, AppException {
        Model model = new ExtendedModelMap();
        Article article = (Article) JackSonUtils.json2Object(json, Article.class);
        String result = articleService.addArticle(article);
        model.addAttribute("result",result);
        return model;
    }

    /**
     * 发布文章
     *
     * @param json
     * @return java.lang.String
     * @author Colin
     * @date 2020/2/24 0024 下午 5:43
     */
    @RequestMapping(value = "/publishArticle", method = RequestMethod.POST)
    public Model publishArticle(@RequestBody String json) throws IOException, AppException {
        Model model = new ExtendedModelMap();
        Article article = (Article) JackSonUtils.json2Object(json, Article.class);
        String result = articleService.publishArticle(article);
        model.addAttribute("result",result);
        return model;
    }
}
