package com.colin.foodsource.model;

import java.util.Date;

/**
 * @Description: 词条点赞收藏
 * Created by Colin on 2020/1/29 0029 下午 7:28.
 */
public class EntryLikeCollect {

    private String foodEntryId;//词条编号
    private String likeState;//点赞状态
    private Date likeDate;//点赞时间
    private String collectState;//收藏状态
    private Date collectDate;//收藏时间
    private String oIdUser;//用户编号
    private String state;//状态

    public EntryLikeCollect(){
        this.likeState = "0";
        this.collectState = "0";
        this.state = "0";
    }

    public String getFoodEntryId() {
        return foodEntryId;
    }

    public void setFoodEntryId(String foodEntryId) {
        this.foodEntryId = foodEntryId;
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
