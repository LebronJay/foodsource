package com.colin.foodsource.common.interceptor;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.annotation.NoneAuth;
import com.colin.foodsource.common.model.ResponseMessage;
import com.colin.foodsource.common.model.TokenModel;
import com.colin.foodsource.common.utils.JackSonUtils;
import com.colin.foodsource.common.utils.RedisTokenHelp;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 请求拦截处理类
 * Created by Colin on 2020/2/25 0025 上午 9:47.
 */
public class AuthHandlerInterceptor implements HandlerInterceptor {

//    preHandler -> Controller -> postHandler -> model渲染 -> afterCompletion

    @Autowired
    private RedisTokenHelp tokenHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //如果被@NoneAuth注解代表不需要登录验证，直接通过
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.getAnnotation(NoneAuth.class) != null) return true;
        //token验证
        String authStr = request.getHeader(FoodConstants.AUTHORIZATION);
        TokenModel model = tokenHelper.get(authStr);

        //验证通过
        if(tokenHelper.check(model)) {
            request.setAttribute(FoodConstants.CURRENT_USER_ID, model.getId());
            return true;
        }
        //验证未通过
        Map<String,Object> map = new HashMap<>();
        map.put("result","权限未认证");
        ResponseMessage message = new ResponseMessage(FoodConstants.STATE_NOT_AUTH_401,map);
        response.setHeader(FoodConstants.HEADER_CONTENT_TYPE_KEY, FoodConstants.HEADER_CONTENT_TYPE_VALUE);
        response.setCharacterEncoding(FoodConstants.HEADER_CHARACTER_ENCODING);
        response.getWriter().write(JackSonUtils.object2Json(message));
        return false;
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
