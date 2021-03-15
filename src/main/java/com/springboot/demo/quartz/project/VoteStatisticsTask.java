package com.springboot.demo.quartz.project;

import com.springboot.demo.service.LandService;
import com.springboot.demo.util.date.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 执行类，被定时的任务
 */
public class VoteStatisticsTask implements Job {
    private static Logger logger = LoggerFactory.getLogger(VoteStatisticsTask.class);

    // @Resource
    //被定时的服务
    // private LandService landService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        String dates = DateUtil.parseDateToStr(new Date(), DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        logger.info("系统自动更新数据" + dates);
    }
}
