package com.colin.foodsource.model.view;

import java.util.Date;

/**
 * @Description: 首页词条信息
 * Created by Colin on 2020/3/25 0025 上午 10:03.
 */
public class HomeEntry {

    private String foodEntryId;//词条编号
    private String entryName;//词条名称
    private String entryTag;//标签
    private String oIdInput;//创建人
    private Date inputDate;//创建时间
    private String entryImgUrl;//图片
    private String entryContent;//内容
    private int skrNum;//点赞数
    private int collectionNum;//收藏数
    private String isSkr;//是否点赞
    private String isCollection;//是否收藏

    public String getFoodEntryId() {
        return foodEntryId;
    }

    public void setFoodEntryId(String foodEntryId) {
        this.foodEntryId = foodEntryId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryTag() {
        return entryTag;
    }

    public void setEntryTag(String entryTag) {
        this.entryTag = entryTag;
    }

    public String getoIdInput() {
        return oIdInput;
    }

    public void setoIdInput(String oIdInput) {
        this.oIdInput = oIdInput;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getEntryImgUrl() {
        return entryImgUrl;
    }

    public void setEntryImgUrl(String entryImgUrl) {
        this.entryImgUrl = entryImgUrl;
    }

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent) {
        this.entryContent = entryContent;
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
