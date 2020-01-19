package com.colin.foodsource.service;

import com.colin.foodsource.model.User;
import com.colin.foodsource.model.view.UserInfo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 用户信息服务接口
 * Created by Colin on 2020/1/9 0009 上午 10:44.
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param user
     * @return boolean
     * @author Colin
     * @date 2020/1/15 0015 下午 1:39
     */
    String addUser(User user);

    /**
     * 根据用户id获取登录名称
     *
     * @param userId
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/9 0009 上午 10:46
     */
    String getLoginNameByUserId(String userId);

    /**
     * 获取所有用户
     *
     * @param
     * @return java.util.List<com.colin.foodsource.model.User>
     * @author Colin
     * @date 2020/1/9 0009 下午 1:52
     */
    List<User> getAllUser();

    /**
    * 分页查询用户信息
    * @param pageNum
    * @param pageSize
    * @return  java.util.List<com.colin.foodsource.model.User>
    * @author  Colin
    * @date  2020/1/19 0019 上午 10:18
    */
    PageInfo<User> getUserList(int pageNum, int pageSize);

    /**
     * 登录
     *
     * @param loginName
     * @param passwd
     * @return com.colin.foodsource.model.view.UserInfo
     * @author Colin
     * @date 2020/1/10 0010 上午 9:42
     */
    UserInfo login(String loginName, String passwd);

    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword
     * @param oldPassword
     * @return boolean
     * @author Colin
     * @date 2020/1/13 0013 下午 1:50
     */
    boolean updatePassword(String userId, String newPassword, String oldPassword);

    /**
     * 根据用户ID和密码查询用户是否存在
     *
     * @param userId
     * @param passwd
     * @return java.lang.Integer
     * @author Colin
     * @date 2020/1/13 0013 下午 1:51
     */
    Integer countUserByIdAndPasswd(String userId, String passwd);

    /**
     * 修改密码业务处理
     *
     * @param userId
     * @param newPassword
     * @param oldPassword
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/13 0013 下午 4:31
     */
    String updateNewPassword(String userId, String newPassword, String oldPassword);

    /**
     * 根据用户id删除用户
     *
     * @param userId
     * @return boolean
     * @author Colin
     * @date 2020/1/15 0015 下午 1:39
     */
    String deleteUserByUserId(@Param("userId") String userId);
}
