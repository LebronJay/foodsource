package com.colin.foodsource.dao;

import com.colin.foodsource.model.Article;
import org.apache.ibatis.annotations.Mapper;
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
}
