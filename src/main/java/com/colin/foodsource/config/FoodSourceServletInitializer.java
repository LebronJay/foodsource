package com.colin.foodsource.config;

import com.colin.FoodSourceApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Description: Servlet初始化配置(用于应用服务器部署启动)
 * Created by Colin on 2020/1/17 0017 上午 11:39.
 */
public class FoodSourceServletInitializer extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FoodSourceApplication.class);
    }
}
