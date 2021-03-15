package com.springboot.demo.quartz.Look;

import com.springboot.demo.quartz.Service.QuartzService;
import com.springboot.demo.quartz.project.Test;
import com.springboot.demo.quartz.project.VoteStatisticsTask;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 监听器，启动定时任务
 */
@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger logger = LoggerFactory.getLogger(ApplicationStartQuartzJobListener.class);

    @Autowired
    private QuartzService quartzService;

    /**
     * 初始启动quartz
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {

            quartzService.createScheduleJob("VoteStatisticsTask", "*/50 * * * * ?", VoteStatisticsTask.class);

            quartzService.createScheduleJob("Test", "*/40 * * * * ?", Test.class);
            logger.info("定时任务已经启动...");
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
        }
    }
}
