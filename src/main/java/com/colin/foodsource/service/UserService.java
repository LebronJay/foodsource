package com.colin.foodsource.service;

import com.colin.foodsource.exception.AppException;
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

    UserInfo addUser(User user) throws AppException;

    String getLoginNameByUserId(String userId);

    List<User> getAllUser();

    PageInfo<User> getUserList(int pageNum, int pageSize);

    UserInfo login(String loginName, String passwd);

    boolean updatePassword(String userId, String newPassword, String oldPassword);

    Integer countUserByIdAndPasswd(String userId, String passwd);

    String updateNewPassword(String userId, String newPassword, String oldPassword);

    String deleteUserByUserId(@Param("userId") String userId);

    String logout(String userId);
}
