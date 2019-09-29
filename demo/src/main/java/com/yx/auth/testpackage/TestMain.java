package com.yx.auth.testpackage;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) throws ParseException {
        testMonth();
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(date);
//        Date date2 = new Date(System.currentTimeMillis()-30*24*60*60*1000L);
//        System.out.println(date2);


//        Date strStartTime = DateUtil.DatestartOfLastMonth();
//        Date strEndTime = DateUtil.DatestartOfMonth();
//            Date strStartTime = new Date(System.currentTimeMillis()-30*24*60*60*1000L);
//            Date strEndTime = new Date(System.currentTimeMillis());
//        long timeMillsStart = strStartTime.getTime();
//        long timeMillsEnd = strEndTime.getTime();
//
//        int timeMillsnowMouthDay=Integer.parseInt(DateUtil.getNowMouthFirstDay("yyyyMMdd"));
////        int lastMouthLasterDay = DateUtil.getLasterMonthLasterDay();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        int startTimeMouth = Integer.parseInt(sdf.format(strStartTime));
//        int startMonth = Integer.parseInt(String.valueOf(startTimeMouth).substring(4,6));
//        int startDay = Integer.parseInt(String.valueOf(startTimeMouth).substring(6,8));
//        int endTimeMouth = Integer.parseInt(sdf.format(strEndTime));
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(strStartTime);
//        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//
//        for (int i = 0; i <days; i++) {
//            int dayTmp = (i+startDay)%days;
//            if((dayTmp)==0){
//                startMonth++;
//                dayTmp++;
//            }
//            String yearTmp = String.valueOf(startTimeMouth).substring(0,4);
//            String strMonth="";
//            String strDay="";
//            if(startMonth<10){
//                strMonth = "0"+startMonth;
//            }else{
//                strMonth = String.valueOf(startMonth);
//            }
//            if(dayTmp<10){
//                strDay = "0"+dayTmp;
//            }else{
//                strDay = String.valueOf(dayTmp);
//            }
//            System.out.println(yearTmp+strMonth+strDay);
//        }
//        System.out.println();

//        Date strStartTime = DateUtil.DatestartOfLastMonth();
//        Date strEndTime = DateUtil.DatestartOfMonth();
    }

    public static void testDay() throws ParseException {
        String yesterDay = DateUtil.getYesterDayStr(null);
        String strStartTime = DateUtil.time2SelfFormat(yesterDay, "yyyyMMddHH");
        String strEndTime = new SimpleDateFormat("yyyyMMddHH").format(new Date());
        long timeMillsStart = DateUtil.timeStamp2Long(strStartTime, "yyyyMMddHH");
        long timeMillsEnd = DateUtil.timeStamp2Long(strEndTime, "yyyyMMddHH");
        int startTime = Integer.parseInt(strStartTime);
        int endTime = Integer.parseInt(strEndTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int startDay = startTime / 100;
        int endDay = endTime / 100;

        int nowDay = startDay;
        int start = 0;
        int end = 0;
        for (int i = 0; i < 24; i++) {
            int startHour = (hour + i) % 24;
            int endHour = (startHour + 1) % 24;
            if (endHour == 0) {
                start = nowDay * 100 + startHour;
                nowDay = endDay;
                end = nowDay * 100 + endHour;
            } else {
                start = nowDay * 100 + startHour;
                end = nowDay * 100 + endHour;
            }
            System.out.println(start + "  " + end);

        }
        System.out.println();


    }

    public static void testYear() throws ParseException {
        String thisYearBegin = DateUtil.getYearStart();
        String thisYearEnd = DateUtil.getYearEnd();
        int startTime = Integer.parseInt(DateUtil.time2SelfFormat(thisYearBegin, "yyyyMM"));
        int endTime = Integer.parseInt(DateUtil.time2SelfFormat(thisYearEnd, "yyyyMM"));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int lastYear = calendar.get(Calendar.YEAR) - 1;
        int thisYear = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int startYearMonth = lastYear * 100 + month;
        Date queryDateEndTime = DateUtil.StringStamp2Date(startYearMonth + "", "yyyyMM");
        Timestamp startTimestamp = new Timestamp(queryDateEndTime.getTime());
        int lastMouthLasterDay = DateUtil.getLasterMonthLasterDay(startTimestamp + "", "yyyyMM");
        int startYear = lastYear;
        int endYear = lastYear;
        int startMonth = 0;
        int endMonth = 0;
        int start = 0;
        int end = 0;
        boolean flag = false;
        for (int i = 0; i < 13; i++) {
            if (flag)
                startYear = thisYear;
            startMonth = (month + i) % 12;
            if (startMonth == 0) {
                startMonth = 12;
                flag = true;
            }
            endMonth = (month + i + 1) % 12;
            if (endMonth == 0) {
                endMonth = 12;
                start = startYear * 100 + startMonth;
                end = endYear * 100 + endMonth;
                endYear = thisYear;
            } else {
                start = startYear * 100 + startMonth;
                end = endYear * 100 + endMonth;
            }
            System.out.println(start + "----" + end);

        }

        System.out.println();
    }

    public static void testMonth() throws ParseException {
        Date strStartTime = new Date(System.currentTimeMillis() - 30 * 24 * 60 * 60 * 1000L);
        Date strEndTime = new Date(System.currentTimeMillis());
        long timeMillsStart = strStartTime.getTime();
        long timeMillsEnd = strEndTime.getTime();
//            int timeMillsnowMouthDay=Integer.parseInt(DateUtil.getNowMouthFirstDay("yyyyMMdd"));
//            int lastMouthLasterDay = DateUtil.getLasterMonthLasterDay();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int startTimeMouth = Integer.parseInt(sdf.format(strStartTime));
        int startMonth = Integer.parseInt(String.valueOf(startTimeMouth).substring(4, 6));
        int startDay = Integer.parseInt(String.valueOf(startTimeMouth).substring(6, 8));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strStartTime);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int nowMonth = startMonth+1;
        boolean flag = false;
        for (int i = 0; i < days; i++) {
            if(flag)
                startMonth=nowMonth;
            int dayTmp = (i + startDay) % days;
            if ((dayTmp) == 0) {
                dayTmp=days;
                flag = true;
            }
            String yearTmp = String.valueOf(startTimeMouth).substring(0, 4);
            String strMonth = "";
            String strDay = "";
            if (startMonth < 10) {
                strMonth = "0" + startMonth;
            } else {
                strMonth = String.valueOf(startMonth);
            }
            if (dayTmp < 10) {
                strDay = "0" + dayTmp;
            } else {
                strDay = String.valueOf(dayTmp);
            }
            System.out.println(yearTmp+strMonth+strDay);
        }
    }
}
