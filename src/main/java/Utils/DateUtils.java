package Utils;/*
 *  Copyright (c) 2014-2017. 墨博云舟 All Rights Reserved.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Utils.DateUtils :
 *
 * @author zhang.lei
 * @version 1.00
 * @since 2017/12/11 9:13
 */
public class DateUtils {

    public DateUtils(){
        super();
    }

    /**
     * 返回国际标准时间  yyyy-MM-dd'T'HH:mm:ss.SSSZ
     * @param date yyyy-MM-dd HH:mm:ss
     * @return  yyyy-MM-dd'T'HH:mm:ss.SSSZ
     * @throws Exception
     */
    public static String SSSZDateFormat(String date)throws  Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return sdf1.format(sdf.parse(date));
    }

    /**
     * 返回常规时间 yyyy-MM-dd HH:mm:ss
     * @param date yyyy-MM-dd HH:mm:ss
     * @return
     * @throws Exception
     */
    public static String dateStringFormat(String date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(sdf.parse(date));
    }

    /**
     * 返回常规时间(无符号无空格) yyyyMMddHHmmss
     * @param date yyyy-MM-dd HH:mm:ss
     * @return
     * @throws Exception
     */
    public static String normalNumberDate(String date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(sdf.parse(date));
    }

    /**
     * 返回年月日 yyyy-MM-dd
     * @param date
     * @throws Exception
     */
    public static String ymd(String date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sdf.parse(date));
    }

    /**
     * 返回时分秒 HH:mm:ss
     * @param date
     * @throws Exception
     */
    public static String hms(String date) throws Exception{
        return date.substring(date.length()-8,date.length());
    }

    /**
     * 时间转时间戳
     * @param
     * @throws Exception
     */
    public static String dateToLong(String date) throws Exception{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dates = simpleDateFormat.parse(date);
        long ts = dates.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 时间戳转时间
     * @param
     * @throws Exception
     */
    public static String longToDate(String date){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(date);
        Date dates = new Date(lt);
        res = simpleDateFormat.format(dates);
        return res;
    }

    /**
     * Date转string  yyyy-MM-dd  HH:mm:ss
     * @param  date
     * @throws Exception
     */
    public static String dataToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String res=simpleDateFormat.format(date);
        return res;
    }

    /**
     * Date转string  yyyy-MM-dd
     * @param  date
     * @throws Exception
     */
    public static String dataTo24String(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String res=simpleDateFormat.format(date);
        return res;
    }


    /**
     * Date转string昨日  yyyy-MM-dd  00:00:00
     * @param  date
     * @throws Exception
     */
    public static String yesterdayDataToStringStart(Date date){
        Long yesterdayLong = date.getTime()-24*60*60*1000l;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String res=simpleDateFormat.format(new Date(yesterdayLong));
        return res;
    }

    /**
     * Date转string昨日  yyyy-MM-dd  23:59:59
     * @param  date
     * @throws Exception
     */
    public static String yesterdayDataToStringEnd(Date date){
        Long yesterdayLong = date.getTime()-24*60*60*1000l;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String res=simpleDateFormat.format(new Date(yesterdayLong));
        return res;
    }

    /**
     * 将long类型转化为Date
     * @param str
     * @return
     * @throws Exception
     */
    public static Date longToDate(long str){
        return new Date(str * 1000);
    }

    /**
     * 去年的今日
     * @return
     */
    public static String getNowOfLastYear() {
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
        // Get last month GregorianCalendar object
        aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar
                .get(Calendar.YEAR) - 1);
        String currentYearAndMonth = aSimpleDateFormat
                .format(aGregorianCalendar.getTime());
        return currentYearAndMonth;
    }

    /**
     * 获取去年这周当天
     * @return
     */
    public static Long getLastYear(){
        Calendar cla = Calendar.getInstance();
        int currentYear = cla.get(Calendar.YEAR);
        int currentWeekOfYear = cla.get(Calendar.WEEK_OF_YEAR);
        int currentDayOfWeek = cla.get(Calendar.DAY_OF_WEEK);
        cla.set(Calendar.WEEK_OF_YEAR, currentWeekOfYear);
        cla.set(Calendar.DAY_OF_WEEK, currentDayOfWeek);
        cla.set(Calendar.YEAR, currentYear - 1);//去年
        return cla.getTime().getTime()/1000;
    }


    public static void main(String[] args) throws Exception{
        System.out.print(new DateUtils().getLastYear());
    }
}
