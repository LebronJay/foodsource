package com.colin.foodsource.model;

import java.util.Date;

/**
 * @Description: 菜品词条
 * Created by Colin on 2020/2/17 0017 上午 10:46.
 */
public class FoodEntry {
    private String foodEntryId;//词条编号
    private String entryName;//词条名称
    private String entryEnglishName;//词条英文名
    private String entryTag;//词条标签
    private String entryTaste;//口味
    private String entryCuisine;//菜系
    private String mainIngredients;//主要食材
    private String makeWay;//制作方式
    private String commonArea;//地域
    private String entryIntroduction;//简介
    private String entryHistory;//历史文化
    private String entryContent;//内容
    private String entryImg1;//图片1
    private String entryImg2;//图片2
    private String entryImg3;//图片3
    private String entryImg4;//图片4
    private String entryImg5;//图片5
    private String state;//状态
    private String oIdInput;//录入人
    private Date inputDate;//录入时间
    private String oIdModify;//修改人
    private Date lastModDate;//修改时间
    private String entryState;//词条状态

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

    public String getEntryEnglishName() {
        return entryEnglishName;
    }

    public void setEntryEnglishName(String entryEnglishName) {
        this.entryEnglishName = entryEnglishName;
    }

    public String getEntryTag() {
        return entryTag;
    }

    public void setEntryTag(String entryTag) {
        this.entryTag = entryTag;
    }

    public String getEntryTaste() {
        return entryTaste;
    }

    public void setEntryTaste(String entryTaste) {
        this.entryTaste = entryTaste;
    }

    public String getEntryCuisine() {
        return entryCuisine;
    }

    public void setEntryCuisine(String entryCuisine) {
        this.entryCuisine = entryCuisine;
    }

    public String getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(String mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public String getMakeWay() {
        return makeWay;
    }

    public void setMakeWay(String makeWay) {
        this.makeWay = makeWay;
    }

    public String getCommonArea() {
        return commonArea;
    }

    public void setCommonArea(String commonArea) {
        this.commonArea = commonArea;
    }

    public String getEntryIntroduction() {
        return entryIntroduction;
    }

    public void setEntryIntroduction(String entryIntroduction) {
        this.entryIntroduction = entryIntroduction;
    }

    public String getEntryHistory() {
        return entryHistory;
    }

    public void setEntryHistory(String entryHistory) {
        this.entryHistory = entryHistory;
    }

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent) {
        this.entryContent = entryContent;
    }

    public String getEntryImg1() {
        return entryImg1;
    }

    public void setEntryImg1(String entryImg1) {
        this.entryImg1 = entryImg1;
    }

    public String getEntryImg2() {
        return entryImg2;
    }

    public void setEntryImg2(String entryImg2) {
        this.entryImg2 = entryImg2;
    }

    public String getEntryImg3() {
        return entryImg3;
    }

    public void setEntryImg3(String entryImg3) {
        this.entryImg3 = entryImg3;
    }

    public String getEntryImg4() {
        return entryImg4;
    }

    public void setEntryImg4(String entryImg4) {
        this.entryImg4 = entryImg4;
    }

    public String getEntryImg5() {
        return entryImg5;
    }

    public void setEntryImg5(String entryImg5) {
        this.entryImg5 = entryImg5;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getoIdModify() {
        return oIdModify;
    }

    public void setoIdModify(String oIdModify) {
        this.oIdModify = oIdModify;
    }

    public Date getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Date lastModDate) {
        this.lastModDate = lastModDate;
    }

    public String getEntryState() {
        return entryState;
    }

    public void setEntryState(String entryState) {
        this.entryState = entryState;
    }
}
