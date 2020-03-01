package com.colin.foodsource.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 使用本注解的方法不会进行登录验证
 *
 * @author Colin
 * @date 2020/2/28 0028 下午 5:25
 */
@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface NoneAuth {
}
