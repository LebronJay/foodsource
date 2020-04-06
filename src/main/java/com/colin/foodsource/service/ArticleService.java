package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.Article;

/**
 * @Description: 文章信息服务接口
 * Created by Colin on 2020/2/20 0020 上午 9:58.
 */
public interface ArticleService {

    String addArticle(Article article) throws AppException;

    String publishArticle(Article article) throws AppException;

    Article getArticleById(String articleId);
}
