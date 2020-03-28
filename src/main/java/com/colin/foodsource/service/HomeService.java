package com.colin.foodsource.service;

import com.colin.foodsource.model.view.HomeArticle;
import com.colin.foodsource.model.view.HomeEntry;

import java.util.List;

/**
 * @Description: 首页信息服务接口
 * Created by Colin on 2020/3/17 0017 上午 11:11.
 */
public interface HomeService {

    /**
    * 获取文章信息
    * @param userId
    * @return  java.util.List<com.colin.foodsource.model.view.HomeArticle>
    * @author  Colin
    * @date  2020/3/25 0025 上午 10:15
    */
    List<HomeArticle> getArticleList(String userId);

    /**
    * 获取词条信息
    * @param userId
    * @return  java.util.List<com.colin.foodsource.model.view.HomeEntry>
    * @author  Colin
    * @date  2020/3/25 0025 上午 10:15
    */
    List<HomeEntry> getEntryList(String userId);
}
