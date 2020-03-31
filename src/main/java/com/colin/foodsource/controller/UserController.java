package com.colin.foodsource.controller;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.annotation.NoneAuth;
import com.colin.foodsource.common.utils.JackSonUtils;
import com.colin.foodsource.common.utils.RedisTokenHelp;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.User;
import com.colin.foodsource.model.view.UserInfo;
import com.colin.foodsource.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
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

    @Autowired
    private RedisTokenHelp tokenHelp;

    /**
     * 添加用户(json格式提交参数)
     *
     * @param json
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/1/15 0015 下午 2:49
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Model addUser(@RequestBody String json) throws IOException, AppException {
        Model model = new ExtendedModelMap();
        User user = (User) JackSonUtils.json2Object(json, User.class);
        UserInfo result = userService.addUser(user);
        model.addAttribute("userInfo", result);
        return model;
    }

    /**
     * 根据用户id获取登录名称(动态url)
     *
     * @param userId
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/1/9 0009 上午 11:15
     */
    @RequestMapping(value = "/getLoginName/{userId}", method = RequestMethod.GET)
    public Model getLoginNameByUserId(@PathVariable("userId") String userId) throws JsonProcessingException {
        Model model = new ExtendedModelMap();
        String loginName = userService.getLoginNameByUserId(userId);
        model.addAttribute("loginName", loginName);
        return model;
    }

    /**
     * 获取所有用户(无参)
     *
     * @param
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/1/9 0009 下午 3:29
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public Model getAllUser() throws JsonProcessingException {
        Model model = new ExtendedModelMap();
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return model;
    }

    /**
     * 分页获取用户信息
     *
     * @param data
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/1/19 0019 上午 10:22
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public Model getUserList(@RequestBody Map<String, Object> data) throws JsonProcessingException {
        Model model = new ExtendedModelMap();
        int pageNum = (int) data.get("pageNum");
        int pageSize = (int) data.get("pageSize");
        PageInfo<User> userList = userService.getUserList(pageNum, pageSize);
        model.addAttribute("userList", userList);
        return model;
    }

    /**
     * 登录(form表单提交参数)
     *
     * @param loginName,passwd
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/1/10 0010 上午 9:49
     */
    @NoneAuth
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Model login(@RequestParam(value = "loginName", required = false) String loginName, @RequestParam(value = "passwd", required = false) String passwd) throws JsonProcessingException {
//    public Model login(@RequestBody Map<String, Object> data) throws JsonProcessingException {
        Model model = new ExtendedModelMap();
//        String loginName = data.get("loginName").toString();
//        String passwd = data.get("passwd").toString();
        UserInfo userInfo = userService.login(loginName, passwd);
        if (userInfo != null) {
            model.addAttribute("token", tokenHelp.getToken(userInfo.getUserId()));
        }
        model.addAttribute("userInfo", userInfo);
        return model;
    }

    /**
     * 修改密码(json格式提交参数)
     *
     * @param data
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/1/13 0013 下午 4:32
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public Model updatePassword(@RequestBody Map<String, Object> data) {
        Model model = new ExtendedModelMap();
        String userId = data.get("userId").toString();
        String newPassword = data.get("newPassword").toString();
        String oldPassword = data.get("oldPassword").toString();
        String result = userService.updateNewPassword(userId, newPassword, oldPassword);
        model.addAttribute("result", result);
        return model;
    }

    /**
     * 根据用户id删除用户(json格式提交参数)
     *
     * @param data
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/1/15 0015 下午 2:52
     */
    @RequestMapping(value = "/deleteUserByUserId", method = RequestMethod.POST)
    public Model deleteUserByUserId(@RequestBody Map<String, Object> data) {
        Model model = new ExtendedModelMap();
        String userId = data.get("userId").toString();
        String result = userService.deleteUserByUserId(userId);
        model.addAttribute("result", result);
        return model;
    }

    /**
     * 登出
     *
     * @param data
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/3/3 0003 下午 2:12
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Model logout(@RequestBody Map<String, Object> data) {
        Model model = new ExtendedModelMap();
        String userId = data.get(FoodConstants.CURRENT_USER_ID).toString();
        String result = userService.logout(userId);
        model.addAttribute("result", result);
        return model;
    }
}
