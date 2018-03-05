package com.hiynn.test.quartzJob;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 任务执行类
 * <p>Title: QuartzJob </p>
 * <p>Description: TODO </p>
 * Date: 2017年8月28日 下午9:30:55
 *
 * @author hydata@hiynn.com
 * @version 1.0 </p>
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年8月28日         hydata         创建文件,实现基本功能
 * <p>
 * ==========================================================
 */
public class QuartzJob implements Job {

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "★★★★★★★★★★★");

    }
}
