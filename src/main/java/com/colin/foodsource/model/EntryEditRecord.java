package com.colin.foodsource.model;

import java.util.Date;

/**
 * @Description: 词条编辑记录
 * Created by Colin on 2020/1/17 0017 上午 10:01.
 */
public class EntryEditRecord {

    private String entryEditRecordId;//编辑记录编号
    private String foodEntryId;//词条编号
    private String editContent;//编辑内容
    private Date editDate;//编辑时间
    private String oIdUser;//用户编号
    private String entryState;//词条状态
    private String state;//状态

    public String getEntryEditRecordId() {
        return entryEditRecordId;
    }

    public void setEntryEditRecordId(String entryEditRecordId) {
        this.entryEditRecordId = entryEditRecordId;
    }

    public String getFoodEntryId() {
        return foodEntryId;
    }

    public void setFoodEntryId(String foodEntryId) {
        this.foodEntryId = foodEntryId;
    }

    public String getEditContent() {
        return editContent;
    }

    public void setEditContent(String editContent) {
        this.editContent = editContent;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getoIdUser() {
        return oIdUser;
    }

    public void setoIdUser(String oIdUser) {
        this.oIdUser = oIdUser;
    }

    public String getEntryState() {
        return entryState;
    }

    public void setEntryState(String entryState) {
        this.entryState = entryState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
