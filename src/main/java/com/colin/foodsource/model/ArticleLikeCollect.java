package com.colin.foodsource.model;

import java.util.Date;

/**
 * @Description: 文章点赞收藏
 * Created by Colin on 2020/1/22 0022 上午 10:09.
 */
public class ArticleLikeCollect {

    private String articleLikeCollectId;//点赞收藏编号
    private String articleId;//评论编号
    private String likeState;//点赞状态
    private Date likeDate;//点赞时间
    private String collectState;//收藏状态
    private Date collectDate;//收藏时间
    private String oIdUser;//用户编号
    private String state;//状态

    public String getArticleLikeCollectId() {
        return articleLikeCollectId;
    }

    public void setArticleLikeCollectId(String articleLikeCollectId) {
        this.articleLikeCollectId = articleLikeCollectId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getLikeState() {
        return likeState;
    }

    public void setLikeState(String likeState) {
        this.likeState = likeState;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }

    public String getCollectState() {
        return collectState;
    }

    public void setCollectState(String collectState) {
        this.collectState = collectState;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public String getoIdUser() {
        return oIdUser;
    }

    public void setoIdUser(String oIdUser) {
        this.oIdUser = oIdUser;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
