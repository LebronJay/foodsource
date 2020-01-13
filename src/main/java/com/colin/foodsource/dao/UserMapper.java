package com.colin.foodsource.dao;

import com.colin.foodsource.model.User;
import com.colin.foodsource.model.view.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     *
     * @param userId
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/9 0009 上午 10:49
     */
    String getLoginNameByUserId(String userId);

    /**
     * 获取所有用户
     *
     * @param
     * @return java.util.List<com.colin.foodsource.model.User>
     * @author Colin
     * @date 2020/1/9 0009 下午 1:50
     */
    List<User> getAllUser();

    /**
     * 登录
     *
     * @param loginName
     * @param passwd
     * @return com.colin.foodsource.model.view.UserInfo
     * @author Colin
     * @date 2020/1/10 0010 上午 9:41
     */
    UserInfo login(@Param("loginName") String loginName, @Param("passwd") String passwd);

    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword
     * @param oldPassword
     * @return boolean
     * @author Colin
     * @date 2020/1/13 0013 下午 1:39
     */
    boolean updatePassword(@Param("userId") String userId, @Param("newPassword") String newPassword, @Param("oldPassword") String oldPassword);

    /**
     * 根据用户ID和密码查询用户是否存在(检验密码是否正确)
     *
     * @param userId
     * @param passwd
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/1/13 0013 下午 1:40
     */
    Integer countUserByIdAndPasswd(@Param("userId") String userId, @Param("passwd") String passwd);


}
