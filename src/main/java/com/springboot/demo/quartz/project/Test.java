package com.springboot.demo.quartz.project;

import com.springboot.demo.service.UserBaseInfoService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class Test implements Job {
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    @Resource
    private UserBaseInfoService userBaseInfoService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        Object boj = userBaseInfoService.selectBaseInfo(100863L);
        logger.info("定时任务执行，查询开始：" + boj);
    }
}
