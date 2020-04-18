package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.dao.ArticleMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.Article;
import com.colin.foodsource.model.view.ArticleDetail;
import com.colin.foodsource.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Description: 文章信息服务接口实现类
 * Created by Colin on 2020/2/20 0020 上午 9:59.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    protected Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加文章
     *
     * @param article
     * @return java.lang.String
     * @author Colin
     * @date 2020/3/31 0031 下午 5:01
     */
    @Transactional
    @Override
    public String addArticle(Article article) throws AppException {
        String result = "";
        String userId = article.getoIdUser();
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if (StringUtils.isEmpty(loginNameByUserId)) {
            throw new AppException("用户不存在，不能保存文章信息！");
        }
        if (StringUtils.isEmpty(article.getArticleTitle())) {
            throw new AppException("请输入文章标题！");
        }
        if (StringUtils.isEmpty(article.getArticleContent())) {
            throw new AppException("请输入文章内容！");
        }
        if (StringUtils.isEmpty(article.getArticleState())) {
            article.setArticleState("0");
        }
        String articleId = RandomUtils.getUUID();
        article.setArticleId(articleId);
        article.setInputDate(new Date());
        article.setLastModDate(new Date());
        boolean addArticle = articleMapper.addArticle(article);
        if (addArticle) {
            return articleId;
        }
        return null;
    }

    /**
     * 发布文章
     *
     * @param article
     * @return java.lang.String
     * @author Colin
     * @date 2020/3/31 0031 下午 5:02
     */
    @Transactional
    @Override
    public String publishArticle(Article article) throws AppException {
        String articleId = article.getArticleId();
        if (StringUtils.isEmpty(articleId)) {
            article.setArticleState("1");
            String addArticle = addArticle(article);
            if (!StringUtils.isEmpty(addArticle)) {
                return FoodConstants.SUCCESS;
            }
        } else {
            boolean publishArticle = articleMapper.publishArticle(articleId);
            if (publishArticle) {
                return FoodConstants.SUCCESS;
            }
        }
        return FoodConstants.FAIL;
    }

    /**
     * 根据文章编号获取文章信息
     *
     * @param articleId
     * @return com.colin.foodsource.model.Article
     * @author Colin
     * @date 2020/3/31 0031 下午 5:02
     */
    @Override
    public Article getArticleById(String articleId) {
        Article articleById = articleMapper.getArticleById(articleId);
        return articleById;
    }

    /**
     * 获取文章详细信息
     *
     * @param articleId
     * @param userId
     * @return com.colin.foodsource.model.view.ArticleDetail
     * @author Colin
     * @date 2020/4/16 0016 下午 5:04
     */
    @Override
    public ArticleDetail getArticleDetail(String articleId, String userId) throws AppException {
        if (StringUtils.isEmpty(articleId)) {
            throw new AppException("文章编号不能为空！");
        }
        ArticleDetail articleDetail = articleMapper.getArticleDetail(articleId, userId);
        return articleDetail;
    }
}
