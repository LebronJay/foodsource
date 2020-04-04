package com.colin.foodsource.controller;

import com.colin.foodsource.common.utils.JackSonUtils;
import com.colin.foodsource.exception.AppException;
import com.colin.foodsource.model.Comment;
import com.colin.foodsource.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Description: 评论信息控制器
 * Created by Colin on 2020/4/3 0003 上午 10:45.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论(json格式提交参数)
     *
     * @param json
     * @return org.springframework.ui.Model
     * @author Colin
     * @date 2020/4/3 0003 上午 10:46
     */
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public Model addComment(@RequestBody String json) throws IOException, AppException {
        Model model = new ExtendedModelMap();
        Comment comment = (Comment) JackSonUtils.json2Object(json, Comment.class);
        String result = commentService.addComment(comment);
        model.addAttribute("result", result);
        return model;
    }
}
