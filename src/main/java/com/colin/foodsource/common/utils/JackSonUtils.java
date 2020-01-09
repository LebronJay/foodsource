package com.colin.foodsource.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Description: JECKSON工具类
 * Created by Colin on 2020/1/9 0009 下午 3:27.
 */
public class JackSonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转换成JSON
     * @param object 需要转换的对象
     * @return jsong字符串
     * @throws JsonProcessingException
     */
    public static String object2Json(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * json转换成对象
     * @param json json字符串
     * @param clazz 对象类
     * @return Object
     * @throws IOException
     */
    public static Object json2Object(String json,Class<?> clazz) throws IOException {
        return objectMapper.readValue(json,clazz);
    }
}
