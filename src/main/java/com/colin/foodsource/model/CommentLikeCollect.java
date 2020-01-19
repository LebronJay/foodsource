package com.colin.foodsource.model;

import java.util.Date;

/**
 * @Description: 评论点赞收藏
 * Created by Colin on 2020/1/19 0019 上午 9:28.
 */
public class CommentLikeCollect {

    private String commentLikeCollectId;//点赞收藏编号
    private String commentId;//评论编号
    private String likeState;//点赞状态
    private Date likeDate;//点赞时间
    private String collectState;//收藏状态
    private Date collectDate;//收藏时间
    private String oIdUser;//用户编号
    private String state;//状态

    public String getCommentLikeCollectId() {
        return commentLikeCollectId;
    }

    public void setCommentLikeCollectId(String commentLikeCollectId) {
        this.commentLikeCollectId = commentLikeCollectId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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
