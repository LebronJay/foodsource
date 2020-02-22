package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.Constants;
import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.dao.ArticleMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.Article;
import com.colin.foodsource.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Description: 文章信息服务接口实现类
 * Created by Colin on 2020/2/20 0020 上午 9:59.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    protected Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String addArticle(Article article) throws AppException {
        String result = "";
        String userId = article.getoIdUser();
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if(StringUtils.isEmpty(loginNameByUserId)){
            throw new AppException("用户不存在，不能保存文章信息！");
        }
        if(StringUtils.isEmpty(article.getArticleTitle())){
            throw new AppException("请输入文章标题！");
        }
        if(StringUtils.isEmpty(article.getArticleContent())){
            throw new AppException("请输入文章内容！");
        }
        if(StringUtils.isEmpty(article.getArticleState())){
            article.setArticleState("0");
        }
        article.setArticleId(RandomUtils.getUUID());
        article.setInputDate(new Date());
        article.setLastModDate(new Date());
        boolean addArticle = articleMapper.addArticle(article);
        if (addArticle) {
            result = Constants.SUCCESS;
        } else {
            result = Constants.FAIL;
        }
        return result;
    }
}
