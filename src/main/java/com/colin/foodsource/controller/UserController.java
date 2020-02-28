package com.colin.foodsource.controller;

import com.colin.foodsource.common.utils.JackSonUtils;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.User;
import com.colin.foodsource.model.view.UserInfo;
import com.colin.foodsource.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户信息控制器
 * Created by Colin on 2020/1/9 0009 上午 10:59.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户(json格式提交参数)
     *
     * @param json
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/15 0015 下午 2:49
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Model addUser(@RequestBody String json) throws IOException, AppException {
        User user = (User) JackSonUtils.json2Object(json, User.class);
        Model result = userService.addUser(user);
        return result;
    }

    /**
     * 根据用户id获取登录名称(动态url)
     *
     * @param userId
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/9 0009 上午 11:15
     */
    @RequestMapping(value = "/getLoginName/{userId}", method = RequestMethod.GET)
    public String getLoginNameByUserId(@PathVariable("userId") String userId) throws JsonProcessingException {
        String loginName = userService.getLoginNameByUserId(userId);
        return JackSonUtils.object2Json(loginName);
    }

    /**
     * 获取所有用户(无参)
     *
     * @param
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/9 0009 下午 3:29
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAllUser() throws JsonProcessingException {
        List<User> allUser = userService.getAllUser();
        return allUser;
    }

    /**
     * 分页获取用户信息
     *
     * @param data
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/19 0019 上午 10:22
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public PageInfo<User> getUserList(@RequestBody Map<String, Object> data) throws JsonProcessingException {
        int pageNum = (int) data.get("pageNum");
        int pageSize = (int) data.get("pageSize");
        PageInfo<User> userList = userService.getUserList(pageNum, pageSize);
        return userList;
    }

    /**
     * 登录(form表单提交参数)
     *
     * @param loginName,passwd
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/10 0010 上午 9:49
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserInfo login(@RequestParam(value = "loginName", required = false) String loginName, @RequestParam(value = "passwd", required = false) String passwd) throws JsonProcessingException {
        UserInfo login = userService.login(loginName, passwd);
        return login;
    }

    /**
     * 修改密码(json格式提交参数)
     *
     * @param data
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/13 0013 下午 4:32
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public Model updatePassword(@RequestBody Map<String, Object> data) {
        String userId = data.get("userId").toString();
        String newPassword = data.get("newPassword").toString();
        String oldPassword = data.get("oldPassword").toString();
        Model result = userService.updateNewPassword(userId, newPassword, oldPassword);
        return result;
    }

    /**
     * 根据用户id删除用户(json格式提交参数)
     *
     * @param data
     * @return java.lang.String
     * @author Colin
     * @date 2020/1/15 0015 下午 2:52
     */
    @RequestMapping(value = "/deleteUserByUserId", method = RequestMethod.POST)
    public String deleteUserByUserId(@RequestBody Map<String, Object> data) {
        String userId = data.get("userId").toString();
        return userService.deleteUserByUserId(userId);
    }
}
