package com.colin.foodsource.common;

/**
 * @Description: 常量类
 * Created by Colin on 2020/1/17 0017 上午 10:26.
 */
public class FoodConstants {

    /**
     * 操作状态：成功
     */
    public static final String STATUS_OK = "ok";

    /**
     * 操作状态：错误
     */
    public static final String STATUS_ERROR = "error";

    /**
     * 返回信息：成功
     */
    public static final String SUCCESS = "success";

    /**
     * 返回信息：失败
     */
    public static final String FAIL = "fail";

    /**
     * 返回信息：用户不存在
     */
    public static final String NO_USER = "no_user";

    /**
     * 返回信息：密码错误
     */
    public static final String WRONG_PASSWORD = "wrong_password";

    /**
     * Response消息头：消息内容类型KEY
     */
    public static final String HEADER_CONTENT_TYPE_KEY = "Content-type";

    /**
     * Response消息头：消息内容VALUE
     */
    public static final String HEADER_CONTENT_TYPE_VALUE = "text/html;charset=UTF-8";

    /**
     * Response消息编码字符 :UTF-8
     */
    public static final String HEADER_CHARACTER_ENCODING = "UTF-8";

    /**
     * 操作状态：服务器内部错误：500
     */
    public static final int STATE_ERROR_500 = 500;

    /**
     * 操作状态：成功
     */
    public static final int STATE_SUCCESS_200 = 200;

    /**
     * redis缓存时间
     */
    public static final long REDIS_EXPIRATION_SECONDS = 30 * 60;

    /**
     * 操作状态：权限未认证
     */
    public static final int STATE_NOT_AUTH_401 = 401;

    /**
     * 前端token key值
     */
    public static final String AUTHORIZATION = "authStr";

    /**
     * 用户编号字符串
     */
    public static final String CURRENT_USER_ID = "userId";
}
