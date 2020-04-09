package com.colin.foodsource.service.impl;

import com.colin.foodsource.dao.HomeMapper;
import com.colin.foodsource.model.view.HomeArticle;
import com.colin.foodsource.model.view.HomeEntry;
import com.colin.foodsource.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 首页信息服务接口实现类
 * Created by Colin on 2020/3/17 0017 上午 11:12.
 */
@Service
public class HomeServiceImpl implements HomeService{

    protected Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<HomeArticle> getArticleList(String userId) {
        List<HomeArticle> articleList = homeMapper.getArticleList(userId);
        return articleList;
    }

    @Override
    public List<HomeEntry> getEntryList(String userId) {
        List<HomeEntry> entryList = homeMapper.getEntryList(userId);
        return entryList;
    }
}
