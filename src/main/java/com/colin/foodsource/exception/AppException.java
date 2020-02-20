package com.colin.foodsource.exception;

/**
 * @Description: 自定义异常
 * Created by Colin on 2020/2/20 0020 上午 10:09.
 */
public class AppException extends Exception{

    public AppException(String var1,Throwable var2){
        super(var1,var2);
    }

    public AppException(String var1){
        super(var1);
    }
}
