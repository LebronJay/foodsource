package com.colin.foodsource.common.model;

import java.util.Map;

/**
 * @Description: 返回信息对象
 * Created by Colin on 2020/1/17 0017 上午 10:30.
 */
public class ResponseMessage {

    /**
     * 状态
     */
    private int status;

    /**
     * 消息体
     */
    private Map<String,Object> data;

    public ResponseMessage(){
    }

    public ResponseMessage(int status, Map<String, Object> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
