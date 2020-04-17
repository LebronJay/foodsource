package com.colin.foodsource.model.view;

import java.util.Date;

/**
 * @Description: 文章详细信息
 * Created by Colin on 2020/4/16 0016 下午 4:50.
 */
public class ArticleDetail {

    private String articleId;//文章编号
    private String articleTitle;//文章标题
    private String articleTag;//文章标签
    private String articleContent;//内容
    private String oIdUser;//作者
    private Date publishDate;//发表时间
    private int articleBrowseCount;//文章浏览数
    private String articleImg1;//图片1
    private String articleImg2;//图片2
    private String articleImg3;//图片3
    private String articleImg4;//图片4
    private String articleImg5;//图片5
    private Date inputDate;//录入时间
    private Date lastModDate;//修改时间
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

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
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

    public int getArticleBrowseCount() {
        return articleBrowseCount;
    }

    public void setArticleBrowseCount(int articleBrowseCount) {
        this.articleBrowseCount = articleBrowseCount;
    }

    public String getArticleImg1() {
        return articleImg1;
    }

    public void setArticleImg1(String articleImg1) {
        this.articleImg1 = articleImg1;
    }

    public String getArticleImg2() {
        return articleImg2;
    }

    public void setArticleImg2(String articleImg2) {
        this.articleImg2 = articleImg2;
    }

    public String getArticleImg3() {
        return articleImg3;
    }

    public void setArticleImg3(String articleImg3) {
        this.articleImg3 = articleImg3;
    }

    public String getArticleImg4() {
        return articleImg4;
    }

    public void setArticleImg4(String articleImg4) {
        this.articleImg4 = articleImg4;
    }

    public String getArticleImg5() {
        return articleImg5;
    }

    public void setArticleImg5(String articleImg5) {
        this.articleImg5 = articleImg5;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Date lastModDate) {
        this.lastModDate = lastModDate;
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
