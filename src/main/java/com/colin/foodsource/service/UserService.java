package com.colin.foodsource.service;

import com.colin.foodsource.model.User;

import java.util.List;

/**
 * @Description: 用户信息服务接口
 * Created by Colin on 2020/1/9 0009 上午 10:44.
 */
public interface UserService {

    /**
    * 根据用户id获取登录名称
    * @param userId
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/1/9 0009 上午 10:46
    */
    String getLoginNameByUserId(String userId);

    /**
    * 获取所有用户
    * @param
    * @return  java.util.List<com.colin.foodsource.model.User>
    * @author  Colin
    * @date  2020/1/9 0009 下午 1:52
    */
    List<User> getAllUser();
}
