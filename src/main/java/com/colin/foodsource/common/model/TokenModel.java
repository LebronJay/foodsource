package com.colin.foodsource.common.model;

/**
 * @Description: Token消息实体类
 * Created by Colin on 2020/2/28 0028 上午 11:35.
 */
public class TokenModel {

    private String id;
    private String token;

    public TokenModel(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
