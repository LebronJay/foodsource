package com.colin.foodsource.service.impl;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.model.TokenModel;
import com.colin.foodsource.common.utils.RandomUtils;
import com.colin.foodsource.common.utils.RedisTokenHelp;
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
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private RedisTokenHelp tokenHelp;

    /**
    * 添加用户
    * @param user
    * @return  com.colin.foodsource.model.view.UserInfo
    * @author  Colin
    * @date  2020/3/31 0031 下午 4:58
    */
    @Override
    @Transactional
    public UserInfo addUser(User user) throws AppException {
        String result;
        String loginName = user.getLoginName();
        String passwd = user.getPasswd();
        if(StringUtils.isEmpty(loginName)){
            throw new AppException("登录名称不能为空!");
        }
        if(StringUtils.isEmpty(passwd)){
            throw new AppException("未输入密码!");
        }
        if (StringUtils.isEmpty(user.getPermission())) {
            user.setPermission("0");
        }
        user.setUserId(RandomUtils.getUUID());
        user.setInputDate(new Date());
        user.setLastModDate(new Date());
        boolean addUser = userMapper.addUser(user);
        if (addUser) {
            UserInfo login = userMapper.login(loginName, passwd);
            return login;
        } else {
            return null;
        }
    }

    /**
    * 根据用户id获取登录名称
    * @param userId
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/3/31 0031 下午 4:59
    */
    @Override
    public String getLoginNameByUserId(String userId) {
        String loginName = userMapper.getLoginNameByUserId(userId);
        return loginName;
    }

    /**
    * 获取所有用户
    * @param
    * @return  java.util.List<com.colin.foodsource.model.User>
    * @author  Colin
    * @date  2020/3/31 0031 下午 4:59
    */
    @Override
    public List<User> getAllUser() {
        List<User> allUser = userMapper.getAllUser();
        return allUser;
    }

    /**
    * 分页查询用户信息
    * @param pageNum
    * @param pageSize
    * @return  com.github.pagehelper.PageInfo<com.colin.foodsource.model.User>
    * @author  Colin
    * @date  2020/3/31 0031 下午 4:59
    */
    @Override
    public PageInfo<User> getUserList(int pageNum, int pageSize) {
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /**
    * 登录
    * @param loginName
    * @param passwd
    * @return  com.colin.foodsource.model.view.UserInfo
    * @author  Colin
    * @date  2020/3/31 0031 下午 4:59
    */
    @Override
    public UserInfo login(String loginName, String passwd) {
        UserInfo login = userMapper.login(loginName, passwd);
        if(login != null){
            TokenModel tokenModel = tokenHelp.create(login.getUserId());
        }
        return login;
    }

    /**
    * 修改密码
    * @param userId
    * @param newPassword
    * @param oldPassword
    * @return  boolean
    * @author  Colin
    * @date  2020/3/31 0031 下午 5:00
    */
    @Override
    public boolean updatePassword(String userId, String newPassword, String oldPassword) {
        return userMapper.updatePassword(userId, newPassword, oldPassword);
    }

    /**
    * 根据用户ID和密码查询用户是否存在
    * @param userId
    * @param passwd
    * @return  java.lang.Integer
    * @author  Colin
    * @date  2020/3/31 0031 下午 5:00
    */
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
        String result;
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if (StringUtils.isEmpty(loginNameByUserId)) {
            result = FoodConstants.NO_USER;
        } else {
            Integer userCount = countUserByIdAndPasswd(userId, oldPassword);
            if (userCount == null || userCount.intValue() == 0) {
                result = FoodConstants.WRONG_PASSWORD;
            } else {
                boolean isSuccess = updatePassword(userId, newPassword, oldPassword);
                if (isSuccess) {
                    result = FoodConstants.SUCCESS;
                } else {
                    result = FoodConstants.FAIL;
                }
            }
        }
        return result;
    }

    /**
    * 根据用户id删除用户
    * @param userId
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/3/31 0031 下午 5:00
    */
    @Override
    public String deleteUserByUserId(String userId) {
        String loginNameByUserId = userMapper.getLoginNameByUserId(userId);
        if (StringUtils.isEmpty(loginNameByUserId)) {
            return FoodConstants.NO_USER;
        }
        boolean delete = userMapper.deleteUserByUserId(userId);
        if (delete) {
            return FoodConstants.SUCCESS;
        } else {
            return FoodConstants.FAIL;
        }
    }

    /**
    * 登出
    * @param userId
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/3/31 0031 下午 5:01
    */
    @Override
    public String logout(String userId){
        boolean delete = tokenHelp.delete(userId);
        if (delete){
            return FoodConstants.SUCCESS;
        }else{
            return FoodConstants.FAIL;
        }
    }
}
