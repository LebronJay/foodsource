package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.model.User;
import com.colin.foodsource.model.view.UserInfo;
import com.colin.foodsource.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Description: 用户信息服务接口实现类
 * Created by Colin on 2020/1/9 0009 上午 10:50.
 */
@Service
public class UserServiceImpl implements UserService {

    protected Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public String addUser(User user) {
        String result = "";
        if (StringUtils.isEmpty(user.getPermission())) {
            user.setPermission("0");
        }
        user.setUserId(RandomUtils.getUUID());
        user.setInputDate(new Date());
        user.setLastModDate(new Date());
        boolean addUser = userMapper.addUser(user);
        if (addUser) {
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }

    @Override
    public String getLoginNameByUserId(String userId) {
        String loginName = userMapper.getLoginNameByUserId(userId);
        return loginName;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUser = userMapper.getAllUser();
        return allUser;
    }

    @Override
    public UserInfo login(String loginName, String passwd) {
        UserInfo login = userMapper.login(loginName, passwd);
        return login;
    }

    @Override
    public boolean updatePassword(String userId, String newPassword, String oldPassword) {
        return userMapper.updatePassword(userId, newPassword, oldPassword);
    }

    @Override
    public Integer countUserByIdAndPasswd(String userId, String passwd) {
        return userMapper.countUserByIdAndPasswd(userId, passwd);
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword
     * @param oldPassword
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/13 0013 下午 2:05
     */
    public String updateNewPassword(String userId, String newPassword, String oldPassword) {
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if (StringUtils.isEmpty(loginNameByUserId)) {
            return "no_user";
        } else {
            Integer userCount = countUserByIdAndPasswd(userId, oldPassword);
            if (userCount == null || userCount.intValue() == 0) {
                return "password_error";
            } else {
                boolean result = updatePassword(userId, newPassword, oldPassword);
                if (result) {
                    return "success";
                } else {
                    return "fail";
                }
            }
        }
    }

    @Override
    public String deleteUserByUserId(String userId) {
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if (StringUtils.isEmpty(loginNameByUserId)) {
            return "no_user";
        }
        String result = "";
        boolean delete = userMapper.deleteUserByUserId(userId);
        if (delete) {
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }
}
