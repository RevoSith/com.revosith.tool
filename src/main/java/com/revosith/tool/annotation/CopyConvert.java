package com.revosith.tool.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/6
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CopyConvert {

    /**
     * 装换参数
     *
     * @return 转换参数
     */
    String param() default "";

    /**
     * 转换工具
     *
     * @return 转换工具
     */
    String convertClass();
}
