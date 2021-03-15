package com.springboot.demo.util.Sig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 验证签名注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateSig {

    /**
     * body的序列化类型
     *
     * @return
     */
    Class<?> serializeType();

}
