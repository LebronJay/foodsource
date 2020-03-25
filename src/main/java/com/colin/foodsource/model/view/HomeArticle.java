package com.colin.foodsource.model.view;

import java.util.Date;

/**
 * @Description: 首页文章信息
 * Created by Colin on 2020/3/25 0025 上午 9:58.
 */
public class HomeArticle {

    private String articleId;//文章编号
    private String articleTitle;//文章标题
    private String articleTag;//标签
    private String oIdUser;//作者
    private Date publishDate;//发表时间
    private String articleContent;//内容
    private int skrNum;//点赞数
    private int collectionNum;//收藏数
    private String isSkr;//是否点赞
    private String isCollection;//是否收藏

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = articleTag;
    }

    public String getoIdUser() {
        return oIdUser;
    }

    public void setoIdUser(String oIdUser) {
        this.oIdUser = oIdUser;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public int getSkrNum() {
        return skrNum;
    }

    public void setSkrNum(int skrNum) {
        this.skrNum = skrNum;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

    public String getIsSkr() {
        return isSkr;
    }

    public void setIsSkr(String isSkr) {
        this.isSkr = isSkr;
    }

    public String getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(String isCollection) {
        this.isCollection = isCollection;
    }
}
