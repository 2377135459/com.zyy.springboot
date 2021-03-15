package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "com.springboot.demo")
@EnableCaching
public class DemoApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }
/*
* 项目启动注意：
* 1.启动本地mysql 账户root 密码root 数据库 users（默认启动）
* 2.启动本地redis （默认启动）
* 3.启动本地nginx代理 nginx代理8080和8000端口tomcat nginx端口8550
* E:\nginx\nginx-1.16.1*/
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
}
