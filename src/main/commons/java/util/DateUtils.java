package util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    //是否是当月第一天，是返回true,否返回false
    public static Boolean isFirstDay(){
        Boolean result = false;
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        if(day ==1){
            result = true;
        }
        return result;
    }
    //获得当前月,比如2017-4-1,4月份,，返回date型,Sun Apr 01 00:00:00 CST 2018
    public static Date getCurrentMongth(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }
    //获得当前月,比如当前为四月份，返回4
    public static Integer getCurentMonthInteger(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.MONTH)+1;
    }
    //获得当前月，返回long型,1522512000000
    public static Long getCurrentMonthLong(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTimeInMillis();//或者是calendar.getTime().getTime()
    }
    //获得今天的日期,返回Date型，Thu Apr 19 00:00:00 CST 2018
    public static Date getCurrentDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }
    //获得当前为这个月第几天
    public static Integer getCurrentDayInteger(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.DATE);
    }
    //获得今天的日期，返回long型,1524067200000
    public static Long getCurrentDayLong(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTimeInMillis();
    }
    //Date转Long
    public static Long date2long(Date date){
        return date.getTime();
    }
    //Long转Date
    public static Date long2date(Long mill){
        return new Date(mill);
    }
    //Date转String
    public static String date2string(Date date){
        String dateFormate = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormate);
        return simpleDateFormat.format(date);
    }
    //Long转String
    public static String long2string(Long mill){
        return date2string(long2date(mill));
    }
    //String转Date
    public static Date string2date(String str){
        String dateFormate = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormate);
        ParsePosition parsePosition = new ParsePosition(0);
        return simpleDateFormat.parse(str,parsePosition);
    }
    //String转Long
    public static Long string2long(String str){
        return string2date(str).getTime();
    }
//    public static void main(String[] args){
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(new Date());
//    calendar.set(Calendar.DAY_OF_MONTH,2);
//
//    System.out.println(string2long("2018-04-19 12:33:15"));
//    }

}
