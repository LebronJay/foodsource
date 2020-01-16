package com.colin.foodsource.model;

import java.util.Date;

/**
 * @Description: 热搜
 * Created by Colin on 2020/1/16 0016 下午 4:57.
 */
public class HotSearch {

    private String hotSearchId;//热搜编号
    private String searchId;//搜索编号
    private String searchType;//搜索类型
    private Date searchDate;//搜索时间
    private String oIdUser;//用户编号
    private String state;//状态

    public String getHotSearchId() {
        return hotSearchId;
    }

    public void setHotSearchId(String hotSearchId) {
        this.hotSearchId = hotSearchId;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
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
