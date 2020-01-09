package com.colin.foodsource.service.impl;

import com.colin.foodsource.dao.UserMapper;
import com.colin.foodsource.model.User;
import com.colin.foodsource.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用户信息服务接口实现类
 * Created by Colin on 2020/1/9 0009 上午 10:50.
 */
@Service
public class UserServiceImpl implements UserService{

    protected Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

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
}
