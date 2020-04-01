package com.colin.foodsource.service.impl;

import com.colin.foodsource.dao.ArticleLikeCollectMapper;
import com.colin.foodsource.dao.ArticleMapper;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.ArticleLikeCollect;
import com.colin.foodsource.service.ArticleLikeCollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description: 文章点赞收藏服务接口实现类
 * Created by Colin on 2020/3/20 0020 上午 9:38.
 */
@Service
public class ArticleLikeCollectServiceImpl implements ArticleLikeCollectService {

    protected Logger logger = LoggerFactory.getLogger(ArticleLikeCollectServiceImpl.class);

    @Autowired
    private ArticleLikeCollectMapper articleLikeCollectMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 修改文章点赞状态
     *
     * @param userId
     * @param articleId
     * @return boolean
     * @author Colin
     * @date 2020/3/31 0031 下午 5:48
     */
    @Transactional
    @Override
    public boolean updateLikeState(String articleId, String userId, String likeState) throws AppException {
        Integer existsUser = userMapper.isExistsUser(userId);
        if (existsUser == null || existsUser.intValue() == 0) {
            throw new AppException("用户不存在！");
        }
        Integer existsArticle = articleMapper.isExistsArticle(articleId);
        if (existsArticle == null || existsArticle.intValue() == 0) {
            throw new AppException("文章不存在！");
        }
        Integer existsData = articleLikeCollectMapper.isExistsData(articleId, userId);
        boolean result = false;
        if (existsData == null || existsData.intValue() == 0) {
            ArticleLikeCollect articleLikeCollect = new ArticleLikeCollect();
            articleLikeCollect.setArticleId(articleId);
            articleLikeCollect.setoIdUser(userId);
            articleLikeCollect.setLikeState(likeState);
            articleLikeCollect.setLikeDate(new Date());
            result = articleLikeCollectMapper.addArticleLikeCollect(articleLikeCollect);
        } else {
            result = articleLikeCollectMapper.updateLikeState(articleId, userId, likeState);
        }
        return result;
    }

    /**
     * 修改文章收藏状态
     *
     * @param userId
     * @param articleId
     * @return boolean
     * @author Colin
     * @date 2020/3/31 0031 下午 5:48
     */
    @Transactional
    @Override
    public boolean updateCollectState(String articleId, String userId, String collectState) throws AppException {
        Integer existsUser = userMapper.isExistsUser(userId);
        if (existsUser == null || existsUser.intValue() == 0) {
            throw new AppException("用户不存在！");
        }
        Integer existsArticle = articleMapper.isExistsArticle(articleId);
        if (existsArticle == null || existsArticle.intValue() == 0) {
            throw new AppException("文章不存在！");
        }
        Integer existsData = articleLikeCollectMapper.isExistsData(articleId, userId);
        boolean result = false;
        if (existsData == null || existsData.intValue() == 0) {
            ArticleLikeCollect articleLikeCollect = new ArticleLikeCollect();
            articleLikeCollect.setArticleId(articleId);
            articleLikeCollect.setoIdUser(userId);
            articleLikeCollect.setCollectState(collectState);
            articleLikeCollect.setCollectDate(new Date());
            result = articleLikeCollectMapper.addArticleLikeCollect(articleLikeCollect);
        } else {
            result = articleLikeCollectMapper.updateCollectState(articleId, userId, collectState);
        }
        return result;
    }
}
