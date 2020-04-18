package com.colin.foodsource.dao;

import com.colin.foodsource.model.Article;
import com.colin.foodsource.model.view.ArticleDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 文章信息Mapper
 * Created by Colin on 2020/2/20 0020 上午 9:36.
 */
@Repository
@Mapper
public interface ArticleMapper {

    /**
     * 添加文章
     *
     * @param article
     * @return boolean
     * @author Colin
     * @date 2020/2/20 0020 上午 9:57
     */
    boolean addArticle(Article article);

    /**
     * 根据文章编号获取文章信息
     *
     * @param articleId
     * @return com.colin.foodsource.model.Article
     * @author Colin
     * @date 2020/3/31 0031 下午 4:43
     */
    Article getArticleById(String articleId);

    /**
     * 发表文章
     *
     * @param articleId
     * @return boolean
     * @author Colin
     * @date 2020/3/31 0031 下午 5:05
     */
    boolean publishArticle(String articleId);

    /**
     * 文章是否存在
     *
     * @param articleId
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/4/1 0001 下午 4:14
     */
    Integer isExistsArticle(String articleId);

    /**
     * 获取文章详细信息
     *
     * @param articleId
     * @param userId
     * @return com.colin.foodsource.model.view.ArticleDetail
     * @author Colin
     * @date 2020/4/16 0016 下午 5:02
     */
    ArticleDetail getArticleDetail(@Param("articleId") String articleId, @Param("userId") String userId);
}
