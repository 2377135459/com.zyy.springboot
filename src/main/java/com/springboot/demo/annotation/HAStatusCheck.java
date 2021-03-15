package com.springboot.demo.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 *
 * @version 1.0
 * @Description 自定义注解@HAStatusCheck  拦截service层   HAStatusCheckService
 * @Author Justin zeng
 * @Date 2019-04-19
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HAStatusCheck {
    //自定义的方法描述信息
    //String description()  default "";
}