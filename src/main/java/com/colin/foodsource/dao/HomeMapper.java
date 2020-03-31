package com.colin.foodsource.dao;

import com.colin.foodsource.model.view.HomeArticle;
import com.colin.foodsource.model.view.HomeEntry;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 首页mapper
 * Created by Colin on 2020/3/30 0030 上午 11:41.
 */
@Repository
@Mapper
public interface HomeMapper {

    /**
    * 获取文章信息
    * @param
    * @return  java.util.List<com.colin.foodsource.model.view.HomeArticle>
    * @author  Colin
    * @date  2020/3/30 0030 上午 11:43
    */
    List<HomeArticle> getArticleList(String userId);

    /**
    * 获取词条信息
    * @param
    * @return  java.util.List<com.colin.foodsource.model.view.HomeEntry>
    * @author  Colin
    * @date  2020/3/30 0030 上午 11:43
    */
    List<HomeEntry> getEntryList(String userId);
}
