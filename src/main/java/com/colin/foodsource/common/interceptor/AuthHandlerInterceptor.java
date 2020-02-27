package com.colin.foodsource.common.interceptor;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.model.ResponseMessage;
import com.colin.foodsource.common.utils.JackSonUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 请求拦截处理类
 * Created by Colin on 2020/2/25 0025 上午 9:47.
 */
public class AuthHandlerInterceptor implements HandlerInterceptor {

//    preHandler -> Controller -> postHandler -> model渲染 -> afterCompletion

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        if(null == modelAndView)
            return;
        Map<String,Object> map = new HashMap<>();
        Map<String, Object> modelMap = modelAndView.getModel();
        for(String key : modelMap.keySet()){
            if(StringUtils.startsWithIgnoreCase(key, "org.springframework.validation.BindingResult"))
                continue;
            map.put(key,modelMap.get(key));
        }
        ResponseMessage message = new ResponseMessage(FoodConstants.STATE_SUCCESS_200,map);
        //把所有返回都当作ResponseBody
        modelAndView.clear();
        response.setHeader(FoodConstants.HEADER_CONTENT_TYPE_KEY, FoodConstants.HEADER_CONTENT_TYPE_VALUE);
        response.setCharacterEncoding(FoodConstants.HEADER_CHARACTER_ENCODING);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            String jecksonData2 = JackSonUtils.object2Json(message);
            writer.write(jecksonData2);
            writer.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
