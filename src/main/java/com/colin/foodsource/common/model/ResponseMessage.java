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
     * 消息体
     */
    private Map<String,Object> messageBody;

    public ResponseMessage(String status, Map<String, Object> messageBody) {
        this.status = status;
        this.messageBody = messageBody;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Map<String, Object> messageBody) {
        this.messageBody = messageBody;
    }
}
