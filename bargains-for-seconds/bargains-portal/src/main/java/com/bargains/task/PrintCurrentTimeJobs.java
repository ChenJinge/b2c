package com.bargains.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class PrintCurrentTimeJobs extends QuartzJobBean {
    private static final Log LOG_RECORD = LogFactory.getLog(PrintCurrentTimeJobs.class);

    @Autowired
    private ProduceHtmlTask clusterQuartz;


    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG_RECORD.info("begin to execute task," + DateUtils.dateToString(new Date()));

        clusterQuartz.produceHtml();

        LOG_RECORD.info("end to execute task," + DateUtils.dateToString(new Date()));

    }
}
