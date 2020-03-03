package com.colin.foodsource.config;

import com.colin.foodsource.common.interceptor.AuthHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by Colin on 2020/2/25 0025 上午 9:44.
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport{

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authHandlerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
    * 先创建拦截器实例再注册拦截器(防止拦截器中使用Autowired注入的对象为null)
    * @param
    * @return  com.colin.foodsource.common.interceptor.AuthHandlerInterceptor
    * @author  Colin
    * @date  2020/3/3 0003 上午 10:46
    */
    @Bean
    public AuthHandlerInterceptor authHandlerInterceptor(){
        return new AuthHandlerInterceptor();
    }
}
