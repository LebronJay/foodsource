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
    private String status;

    /**
    * 错误信息
    */
    private String error;

    /**
     * 消息体
     */
    private Map<String,Object> data;

    public ResponseMessage(String status,String error, Map<String, Object> data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
