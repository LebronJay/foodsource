package com.colin.foodsource.common.utils;

import java.util.UUID;

/**
 * @Description: 随机数据工具类
 * Created by Colin on 2020/1/15 0015 下午 3:47.
 */
public class RandomUtils {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}
