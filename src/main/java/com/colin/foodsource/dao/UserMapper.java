package com.colin.foodsource.dao;

import com.colin.foodsource.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 用户信息Mapper
 * Created by Colin on 2020/1/9 0009 上午 10:48.
 */
@Repository
@Mapper
public interface UserMapper {

    /**
    * 根据用户id获取登录名称
    * @param userId
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/1/9 0009 上午 10:49
    */
    String getLoginNameByUserId(String userId);

    /**
    * 获取所有用户
    * @param
    * @return  java.util.List<com.colin.foodsource.model.User>
    * @author  Colin
    * @date  2020/1/9 0009 下午 1:50
    */
    List<User> getAllUser();
}
