package com.hiynn.test.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.hiynn.test.utils.CronDateUtils;
import com.hiynn.test.utils.TimeUtils;

public class quartzDataTest {

    public static void main(String[] args) {  
        /*Date now = new Date();  
        System.out.println(CronDateUtils.getCron(now));  
  
        String cron = "20 28 17 02 08 ? 2016";  
  
        Date cronDate = CronDateUtils.getDate(cron);  
        System.out.println("===================");  
        System.out.println(cronDate.toString());*/  
    	
    	/*System.err.println("���տ�ʼʱ��"+TimeUtils.getDayld(0));
    	System.err.println("���յ�ǰʱ��"+TimeUtils.getDaydq(0));
    	System.err.println("���յ�ǰʱ��"+TimeUtils.getDaydq(-1));
    	System.err.println("���տ�ʼʱ��"+TimeUtils.getDayld(-1));
    	System.err.println("���¿�ʼʱ��"+TimeUtils.getMonthld(1));
    	System.err.println("���µ�ǰʱ��"+TimeUtils.getMonthdq(0));
    	System.err.println("���¿�ʼʱ��"+TimeUtils.getMonthld(2));
    	System.err.println("���µ�ǰʱ��"+TimeUtils.getMonthdq(-1));*/
        System.err.println("���꿪ʼʱ��" + TimeUtils.getYearld(0, 0));
        System.err.println("���굱ǰʱ��" + TimeUtils.getYeardq(0, 0));
        System.err.println("���꿪ʼʱ��" + TimeUtils.getYearld(-1, 0));
        System.err.println("���굱ǰʱ��" + TimeUtils.getYeardq(-1, 0));
    	/*System.err.println("���ܿ�ʼʱ��"+TimeUtils.getBeginDayOfWeekld(0));
    	System.err.println("���ܵ�ǰʱ��"+TimeUtils.getBeginDayOfWeek(0));
    	System.err.println("���ܿ�ʼʱ��"+TimeUtils.getBeginDayOfWeekld(7));
    	System.err.println("���ܵ�ǰʱ��"+TimeUtils.getBeginDayOfWeek(7));*/
        System.err.println("ȥ�����µ�ǰʱ��" + TimeUtils.getYeardq(-1, -1));
        System.err.println("ȥ�����¿�ʼʱ��" + TimeUtils.getYearld(-1, -1));

    }


}  
