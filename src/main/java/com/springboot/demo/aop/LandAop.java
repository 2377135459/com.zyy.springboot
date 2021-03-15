package com.springboot.demo.aop;


import com.springboot.demo.util.session.SessionTest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LandAop {
    Logger logger = LoggerFactory.getLogger(LandAop.class);

    /**
     * 定义一个切入点
     * execution 定一格式：execution([方法的可见性] 返回类型 [方法所在类的全路径名] 方法名(参数类型列表) [方法抛出的异常类型])
     * * 匹配任何数量字符
     * ..  匹配任何数量字符的重复，如在类型模式中匹配任何数量子包；而在方法参数模式中匹配任何数量参数
     * + 匹配指定类型的子类型；仅能作为后缀放在类型模式后边
     */
    @Pointcut("@annotation(com.springboot.demo.annotation.HAStatusCheck)")
    public void cutOffPoint() {
    }

    /**
     * 在切入点之前执行该方法
     */
    @Before("cutOffPoint()")
    public void beforeTest() {
        logger.info("aop前置通知执行。。。");
    }

    /**
     * 在切入点之后执行该方法
     */
    @After("cutOffPoint()")
    public void afterTest() {
        logger.info("aop后置通知执行。。。");
    }

    /**
     * 环绕通知（涵盖了 @Before and @After）
     */
    @Around("cutOffPoint()")
    public Object aroundTest(ProceedingJoinPoint pjp) {
        Long startTime = System.currentTimeMillis();
        Object obj = null;
        try {
            //切入方法执行
            obj = pjp.proceed();
            Long endTime = System.currentTimeMillis();
            logger.info("aop环绕通知执行。。。，运行时间：" + (endTime - startTime));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

    /**
     * 切入点返回之后执行，即在 @After 之后执行
     */
    @AfterReturning("cutOffPoint()")
    public void afterReturnTest() {

    }

    /**
     * 切入方法有异常抛出（可以作为项目异常总体处理）
     */
    @AfterThrowing("cutOffPoint()")
    public void afterThrowTest() {

        logger.info("请求异常。。。");
    }
}
