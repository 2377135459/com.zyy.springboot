package com.springboot.demo.quartz.Service;

import com.springboot.demo.util.count.Constant;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 定时任务服务
 */
@Service
public class QuartzService {

    private static final String JOB_GROUP = Constant.QuartzConstant.JOB_GROUP;
    private static final String TRIGGER_GROUP = Constant.QuartzConstant.TRIGGER_GROUP;
    @Autowired
    private Scheduler scheduler;

    /**
     * 创建定时任务
     *
     * @param jobDetailName
     * @param cronExpression
     * @param jobClass
     * @throws SchedulerException
     */
    public void createScheduleJob(String jobDetailName, String cronExpression, Class<? extends Job> jobClass) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity("task_" + jobDetailName, JOB_GROUP).storeDurably().requestRecovery().build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("task_" + jobDetailName, TRIGGER_GROUP).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
