package com.hiynn.test.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ������Ŀ����ʱ�乤����
 */
public class TimeUtils {


    /**
     * ��ȡ�յ�ǰʱ��
     *
     * @param i
     * @return
     */
    public static String getDaydq(int i) {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();//ȡ��ǰʱ��
        calendar.setTime(date);
        calendar.add(calendar.DATE, i);//��������ǰ����һ�죬��������������һ���򽫸�����Ϊ����
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String shangridq = formatter.format(date);
        return shangridq;
    }

    /**
     * ��ȡ�����ʱ��
     *
     * @param i
     * @return
     */
    public static String getDayld(int i) {
        Calendar calendarld = Calendar.getInstance();
        calendarld.setTime(new Date());
        calendarld.set(Calendar.HOUR_OF_DAY, 0);
        calendarld.set(Calendar.MINUTE, 0);
        calendarld.set(Calendar.SECOND, 0);
        Date zero = calendarld.getTime();//ȡ��ǰ���ʱ��
        calendarld.setTime(zero);
        calendarld.add(calendarld.DATE, i);//��������ǰ����һ�죬��������������һ���򽫸�����Ϊ����
        zero = calendarld.getTime();
        SimpleDateFormat formatterld = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String shangrild = formatterld.format(zero);
        return shangrild;
    }


    /**
     * ��ȡ�ܵ�ǰʱ��
     *
     * @param i
     * @return
     */
    public static String getBeginDayOfWeek(int i) {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek - i);
        SimpleDateFormat formatterld = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return formatterld.format(cal.getTime());
    }

    /**
     * ��ȡ�����ʱ��
     *
     * @param i
     * @return
     */
    public static String getBeginDayOfWeekld(int i) {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek - i);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date zero = cal.getTime();//ȡ��ǰ���ʱ��
        cal.setTime(zero);
        cal.add(cal.YEAR, 0);//��������ǰ����һ�죬��������������һ���򽫸�����Ϊ����
        zero = cal.getTime();
        SimpleDateFormat formatterld = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String shangyueld = formatterld.format(zero);
        return shangyueld;
    }

    /**
     * ��ȡ�µ�ǰʱ��
     *
     * @param i
     * @return
     */
    public static String getMonthdq(int i) {
        Date date = new Date();//ȡ��ǰʱ��
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.MONTH, i);//��������ǰ����һ�죬��������������һ���򽫸�����Ϊ����
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String shangyuedq = formatter.format(date);
        return shangyuedq;
    }

    /**
     * ��ȡ�����ʱ��
     *
     * @param i
     * @return
     */
    public static String getMonthld(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - i, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        SimpleDateFormat formatterld = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String shangyueld = formatterld.format(calendar.getTime());
        return shangyueld;
    }

    //��ȡ��������һ��
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }

    //��ȡ��������һ��
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    /**
     * ��ȡ�굱ǰʱ��
     *
     * @param y ��һ��
     * @param m ��һ��
     * @return
     */
    public static String getYeardq(int y, int m) {
        Date date = new Date();//ȡ��ǰʱ��
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.YEAR, y);//��������ǰ����һ�죬��������������һ���򽫸�����Ϊ����
        calendar.add(Calendar.MONTH, m);//��
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String shangyuedq = formatter.format(date);
        return shangyuedq;
    }

    /**
     * ��ȡ�����ʱ��
     *
     * @param y ��һ��
     * @param m ��һ��
     * @return
     */
    public static String getYearld(int y, int m) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());//��
        if (m != 0) {
            cal.add(Calendar.MONTH, m);//��
        } else {
            cal.set(Calendar.MONTH, m);//��
        }
        cal.set(Calendar.DATE, 1);//��
        cal.set(Calendar.HOUR_OF_DAY, 0);//ʱ
        cal.set(Calendar.MINUTE, 0);//��
        cal.set(Calendar.SECOND, 0);//��
        cal.add(cal.YEAR, y);//��������ǰ����һ�죬��������������һ���򽫸�����Ϊ����
        SimpleDateFormat formatterld = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String shangyueld = formatterld.format(cal.getTime());
        return shangyueld;
    }
}
