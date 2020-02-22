package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.Article;

/**
 * @Description: 文章信息服务接口
 * Created by Colin on 2020/2/20 0020 上午 9:58.
 */
public interface ArticleService {

    /**
     * 添加文章
     *
     * @param article
     * @return java.lang.String
     * @author Colin
     * @date 2020/2/20 0020 上午 9:58
     */
    String addArticle(Article article) throws AppException;
}
