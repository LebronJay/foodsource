package com.colin.foodsource.controller;

import com.colin.foodsource.common.utils.JackSonUtils;
import com.colin.foodsource.model.User;
import com.colin.foodsource.model.view.UserInfo;
import com.colin.foodsource.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    * 根据用户id获取登录名称
    * @param userId
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/1/9 0009 上午 11:15
    */
    @RequestMapping(value = "/getLoginName/{userId}" , method = RequestMethod.GET)
    public String getLoginNameByUserId(@PathVariable("userId") String userId) throws JsonProcessingException {
        String loginName = userService.getLoginNameByUserId(userId);
        return JackSonUtils.object2Json(loginName);
    }

    /**
    * 获取所有用户
    * @param
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/1/9 0009 下午 3:29
    */
    @RequestMapping(value = "/getAllUser" , method = RequestMethod.GET)
    public String getAllUser() throws JsonProcessingException {
        List<User> allUser = userService.getAllUser();
        return JackSonUtils.object2Json(allUser);
    }

    /**
    * 登录
    * @param request
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/1/10 0010 上午 9:49
    */
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String login(@RequestParam(value = "loginName",required = false) String loginName,@RequestParam(value = "passwd",required = false) String passwd) throws JsonProcessingException {
        UserInfo login = userService.login(loginName, passwd);
        return JackSonUtils.object2Json(login);
    }
}
