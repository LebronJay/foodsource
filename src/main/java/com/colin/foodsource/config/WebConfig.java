package com.colin.foodsource.config;

import com.colin.foodsource.common.interceptor.AuthHandlerInterceptor;
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
        registry.addInterceptor(new AuthHandlerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
