package Utils;/*
 *  Copyright (c) 2014-2017. 墨博云舟 All Rights Reserved.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

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
     * @return
     * @throws Exception
     */
    public static String getSSSZDate(String date)throws  Exception{
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
    public static String getNormalDate(String date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(sdf.parse(date));
    }

    /**
     * 返回常规时间(无符号无空格) yyyy-MM-dd HH:mm:ss
     * @param date yyyy-MM-dd HH:mm:ss
     * @return
     * @throws Exception
     */
    public static String getNormalNumberDate(String date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(sdf.parse(date));
    }

    /**
     * 返回年月日 yyyy-MM-dd
     * @param date
     * @throws Exception
     */
    public static String getYmd(String date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sdf.parse(date));
    }

    /**
     * 返回时分秒 HH:mm:ss
     * @param date
     * @throws Exception
     */
    public static String getHms(String date) throws Exception{
        return date.substring(date.length()-8,date.length());
    }

    /**
     * 时间转时间戳
     * @param
     * @throws Exception
     */
    public static String dateToStamp(String date) throws Exception{
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
    public static String stampToDate(String date){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(date);
        Date dates = new Date(lt);
        res = simpleDateFormat.format(dates);
        return res;
    }

    public static void main(String[] args) throws Exception{
        System.out.print(new DateUtils().getSSSZDate("2017-12-01 00:00:00"));
        System.out.print(new DateUtils().getNormalDate("2017-12-01 00:00:00"));
        System.out.print(new DateUtils().getNormalNumberDate("2017-12-01 00:00:00"));
        System.out.print(new DateUtils().getYmd("2017-12-01 00:00:00"));
        System.out.print(new DateUtils().getHms("2017-12-01 00:00:00"));
        System.out.print(new DateUtils().dateToStamp("2017-12-11 00:00:00"));
        System.out.print(new DateUtils().stampToDate("1512921600000"));
    }
}
