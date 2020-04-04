package com.colin.foodsource.model;

import java.util.Date;

/**
 * @Description: 评论
 * Created by Colin on 2020/2/17 0017 上午 10:34.
 */
public class Comment {

    private String commentId;//评论编号
    private String parentId;//评论对象编号
    private String commentContent;//内容
    private String oIdUser;//用户编号
    private String state;//状态
    private Date inputDate;//录入时间
    private Date lastModDate;//修改时间

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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
}
