package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.Constants;
import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.User;
import com.colin.foodsource.model.view.UserInfo;
import com.colin.foodsource.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public String addUser(User user) throws AppException {
        String result = "";
        String loginName = user.getLoginName();
        if(StringUtils.isEmpty(loginName)){
            throw new AppException("登录名称不能为空!");
        }
        if (StringUtils.isEmpty(user.getPermission())) {
            user.setPermission("0");
        }
        user.setUserId(RandomUtils.getUUID());
        user.setInputDate(new Date());
        user.setLastModDate(new Date());
        boolean addUser = userMapper.addUser(user);
        if (addUser) {
            result = Constants.SUCCESS;
        } else {
            result = Constants.FAIL;
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
    public PageInfo<User> getUserList(int pageNum, int pageSize) {
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
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
            return Constants.NO_USER;
        } else {
            Integer userCount = countUserByIdAndPasswd(userId, oldPassword);
            if (userCount == null || userCount.intValue() == 0) {
                return Constants.WRONG_PASSWORD;
            } else {
                boolean result = updatePassword(userId, newPassword, oldPassword);
                if (result) {
                    return Constants.SUCCESS;
                } else {
                    return Constants.FAIL;
                }
            }
        }
    }

    @Override
    public String deleteUserByUserId(String userId) {
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if (StringUtils.isEmpty(loginNameByUserId)) {
            return Constants.NO_USER;
        }
        String result = "";
        boolean delete = userMapper.deleteUserByUserId(userId);
        if (delete) {
            result = Constants.SUCCESS;
        } else {
            result = Constants.FAIL;
        }
        return result;
    }
}
