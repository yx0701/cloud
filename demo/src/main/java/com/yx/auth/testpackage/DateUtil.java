package com.yx.auth.testpackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    /*实时告警拉取时间*/
    private static String ALARM_INFO_DATE = "";
    /*告警统计拉取时间*/
    private static String ALARM_STATE_DATE = "";
    /*话单统计拉取时间*/
    private static String PERF_STATE_DATE = "";

    static {
        ALARM_INFO_DATE = getYearStart();
        ALARM_STATE_DATE = getYearStart();
        PERF_STATE_DATE = getYearStart();
    }

    //获取20分钟之后的时间
    public static Date getTwentyMinutesLater(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime2 = Calendar.getInstance();
        nowTime2.add(Calendar.MINUTE, 5);
//         df.format(nowTime2.getTime());
        return nowTime2.getTime();
    }

    //暂时任务结束时间为五年为期
    public static Date getFiveYearLater(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime2 = Calendar.getInstance();
        nowTime2.add(Calendar.YEAR, 5);
//        String currentTime = df.format(nowTime2.getTime());
        return nowTime2.getTime();
    }

    public static Date getNowDateLasterTime(long time){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }


    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    public static String dateToString(Date date, String format) {
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String TimestampToString(Timestamp date) {
        String format = "yyyy-MM-dd HH:mm:ss";

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date StringStamp2Date(String time, String format) throws ParseException{
        if (time == null || time.isEmpty() || time.equals("null")) {
            return new Date();
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(time);
    }


    public static long timeStamp2Long(String strTime,String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date strtodate = formatter.parse(strTime);
        return strtodate.getTime();

    }

    /**
     * 获取过去一个月时间 yyyy-MM-dd形式(过去30天)
     *
     * @return
     */
    public static String getLastMonthStr(String format) {
        SimpleDateFormat sdf = null;

        if (format == null || format.isEmpty()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            sdf = new SimpleDateFormat(format);
        }

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date lastMonth = c.getTime();
        return sdf.format(lastMonth);
    }

    /**
     * 获取上个月的第一天
     * @return
     */
    public static String startOfLastMonth(String format) {// 当周开始时间
        SimpleDateFormat sdf;
        if (format == null || format.isEmpty()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            sdf = new SimpleDateFormat(format);
        }
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, 1);
        currentDate.add(Calendar.MONTH, -1);
        Date date = currentDate.getTime();
        String dateBegin = sdf.format(date);
        return dateBegin;
    }

    /**
     * 获取上个月的第一天
     * @return
     */
    public static Date DatestartOfLastMonth() {// 当周开始时间
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, 1);
        currentDate.add(Calendar.MONTH, -1);
        Date date = currentDate.getTime();
        return date;
    }

    /**
     * 获取这个月的第一天
     */
    public static Date endOfLasterDay(int today,String format) throws ParseException {
        SimpleDateFormat sdf;
        if (format == null || format.isEmpty()) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        } else {
            sdf = new SimpleDateFormat(format);
        }
        Date nowday=sdf.parse(today+"");
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowday);
        int laster_day=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, laster_day);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date laster_date = cal.getTime();
        return laster_date;
    }


    /**
     * 获取今天最开始的时间秒
     * @param time
     * @return
     */


    public static long getNowStartDateTime(long time){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static long getLaterStartDateTime(long time){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTimeInMillis();
    }


    /**
     * 获取今天最开始的结束秒
     * @param time
     * @return
     */


    public static long getNowEndDateTime(long time){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE,00);
        calendar.set(Calendar.SECOND,00);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTimeInMillis();
    }

    public static long getNowHourDateStartTime(long time){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MINUTE,00);
        calendar.set(Calendar.SECOND,00);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTimeInMillis();
    }

    public static long getLasterHourDateStartTime(long time){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MINUTE,00);
        calendar.set(Calendar.SECOND,00);
        calendar.set(Calendar.MILLISECOND, 000);
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        return calendar.getTimeInMillis();
    }

    /**
     * 获得上个月的最后一天
     *
     * @return
     */
    public static String endOfLastMonth(String format) {

        SimpleDateFormat sdf;
        if (format == null || format.isEmpty()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            sdf = new SimpleDateFormat(format);
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        String dateEnd = sdf.format(date);
        return dateEnd;
    }

    /**
     * 获得当月的第一天
     *
     * @return
     */
    public static Date DatestartOfMonth() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 000);
        Date date = cal.getTime();
        return date;
    }

    /**
     * 获得昨日 yyyy-MM-dd形式
     *
     * @return
     */
    public static String getYesterDayStr(String format) {
        SimpleDateFormat sdf = null;
        if (format == null || format.isEmpty())
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        else
            sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        Date yesterDay = c.getTime();
        return sdf.format(yesterDay);
    }

    public static int getLasterMonthLasterDay(){
        //取得系统当前时间
        Calendar cal = Calendar.getInstance();
        //取得系统当前时间所在月第一天时间对象
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //日期减一,取得上月最后一天时间对象
        cal.add(Calendar.DAY_OF_MONTH, -1);
        //输出上月最后一天日期
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getLasterMonthLasterDay(String time,String format) throws ParseException {
        //取得系统当前时间
        SimpleDateFormat sdf = null;
        if (format == null || format.isEmpty())
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        else
            sdf = new SimpleDateFormat(format);
        Date mouth=sdf.parse(time);
        Calendar cal = Calendar.getInstance();
        cal.setTime(mouth);
        //输出上月最后一天日期
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获得最近一周
     *
     * @param format
     * @return
     */
    public static String getPastDateStr(int past, String format) {
        SimpleDateFormat sdf = null;
        if (format == null || format.isEmpty()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else
            sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        String result = sdf.format(today);
        return result;
    }






//    /**
//     * 终端设备输入参数
//     * @param startTime
//     * @param endTime
//     * @return
//     */
//    public static String time2JsonStrInUser(String startTime,String endTime){
//        String startTimeStr = DateUtil.timeStamp2Date(startTime,null);
//        String endTimeStr = DateUtil.timeStamp2Date(endTime,null);
//        UserTimeType userTimeType = new UserTimeType();
//        userTimeType.setStartDate(startTimeStr);
//        userTimeType.setEndDate(endTimeStr);
//        String input =  JSONObject.fromObject(userTimeType).toString();
//        return input;
//    }

    /**
     * 获取本年的第一天 yyyy-MM-dd
     *
     * @return String
     */
    public static String getYearStart() {
        return new SimpleDateFormat("yyyy").format(new Date()) + "-01-01 00:00:00";
    }

    /**
     * 获取本年的最后一天 yyyy-MM-dd
     *
     * @return
     */
    public static String getYearEnd() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, c.getActualMaximum(Calendar.MONTH));
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date currYeayLast = c.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(currYeayLast) + " 23:59:59";
    }

    /**
     * 获得过去一小时话务统计数据
     *
     * @return
     */
    public static String getLastHour() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, c.get(Calendar.HOUR) - 1);
        c.get(Calendar.DATE);
        return format.format(c.getTime());
    }


    /**
     * 告警统计输入参数 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */




    /**
     * yyyy-MM-dd HH:mm:ss 转 自定义形式 时间形式 默认是 yyyyMMddHH
     *
     * @param startStamp
     * @return
     */
    public static String time2SelfFormat(String startStamp, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat strFormat = null;
        if (format == null || format.isEmpty()) {
            strFormat = new SimpleDateFormat("yyyyMMddHH");

        } else strFormat = new SimpleDateFormat(format);

        String staStr = "";

        try {
            Date lastMoth = dateFormat.parse(startStamp);
            staStr = strFormat.format(lastMoth);
        } catch (ParseException e) {
            logger.info("" + e.getMessage());
        }
        return staStr;
    }

//    /**
//     * 用户输入参数 yyyy-MM-dd
//     *
//     * @return
//     */
//    public static String userTime2JsonStr() {
//        String dateNow = DateUtil.timeStamp2Date(String.valueOf(System.currentTimeMillis() / 1000), "yyyy-MM-dd");
//        String dateBegin = "1970-06-07";
//
//        UserTimeType timeType = new UserTimeType();
//        timeType.setStartDate(dateBegin);
//        timeType.setEndDate(dateNow);
//        String input = JSONObject.fromObject(timeType).toString();
//        return input;
//    }

    /**
     * 获取年份中的月份 值
     *
     * @param minDate
     * @param maxDate
     * @return 月份范围
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        try {
            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(new SimpleDateFormat("yyyyMM").format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            logger.info("" + e.getMessage(), e);
        }

        return result;
    }

    /**
     * 获取月份中的天 值
     *
     * @param startStr
     * @param endStr
     * @return
     */
    public static List<String> findDates(String startStr, String endStr) {
        Calendar cStart = Calendar.getInstance();
        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startStr);
            dateEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endStr);
        } catch (ParseException e) {
            logger.info("" + e.getMessage(), e);
        }
        cStart.setTime(dateStart);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//格式化为年月日
        List dateList = new ArrayList();
        //别忘了，把起始日期加上
        dateList.add(sdf.format(dateStart));
        // 此日期是否在指定日期之后
        while (dateEnd.after(cStart.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cStart.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(sdf.format(cStart.getTime()));
        }
        return dateList;
    }

    /**
     * 时间段经历了哪几个月
     *
     * @param starTime
     * @param endTime
     * @return
     */
    public static List<String> calcuMonths(String starTime, String endTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> months = new ArrayList<>();
        //判断月份
        SimpleDateFormat yyyyMMFormat = new SimpleDateFormat("yyyyMM");
        int startMonth = 0;
        int endMonth = 0;
        //判断年份
        SimpleDateFormat yyyyFormat = new SimpleDateFormat("yyyy");
        int startYear = 0;
        int endYear = 0;
        try {
            Date startDate = format.parse(starTime);
            Date endDate = format.parse(endTime);
            startMonth = Integer.parseInt(yyyyMMFormat.format(startDate));
            endMonth = Integer.parseInt(yyyyMMFormat.format(endDate));

            startYear = Integer.parseInt(yyyyFormat.format(startDate));
            endYear = Integer.parseInt(yyyyFormat.format(endDate));
            if (startMonth == endMonth) {
                months.add(String.valueOf(startMonth));
            }
            //本年
            if (startYear == endYear) {
                if (startMonth != endMonth) {
                    for (int i = startMonth; i <= endMonth; i++) {
                        months.add(String.valueOf(i));
                    }
                }
            }

        } catch (ParseException e) {
            logger.info("calcuMonths " + e.getMessage());
        }

        return months;
    }


    /**
     *  获得两个日期之间的所有月份(解决跨年问题)
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public  static List<String> getMonthBetweenIn(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        SimpleDateFormat yyyyMMFormat = new SimpleDateFormat("yyyyMM");
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            Date currDate = curr.getTime();
            result.add(yyyyMMFormat.format(currDate));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

    /**
     * 时间yyyy-MM-dd HH:mm:ss转毫秒
     * @param time
     * @return
     */
    public static String getDateToUnixTime(String time){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(time);
            return ""+date.getTime()/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getNowMouthFirstDay(String format) {
        SimpleDateFormat sdf;
        if (format == null || format.isEmpty()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            sdf = new SimpleDateFormat(format);
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        String dateEnd = sdf.format(date);
        return dateEnd;

    }

    public static long getTimeFrirstNow(long startTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(startTime);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}
