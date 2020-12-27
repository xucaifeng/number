package com.cenozoic.number.util;

import com.cenozoic.number.constant.DatePatternEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期处理工具类
 *
 * @author peijin 2015年7月16日 下午2:56:51
 */
@Slf4j
public class DateUtil {

    // @TODO++++++++++++++++++++++++++++++++++++   日期 ===>>>> 日期字符串 ++++++++++++++++++++++++++++++++++++
    /**
     * 将日期转为指定格式字符串
     *
     * @param date
     * @param datePatternEnum 转化格式
     * @return
     */
    public static String getDate2FormatString(Date date, DatePatternEnum datePatternEnum) {
        return DateFormatUtils.format(date, datePatternEnum.getPattern());
    }

    /**
     * 将date转为yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getDate2FormatString(Date date) {
        return DateFormatUtils.format(date, DatePatternEnum.yyyy_MM_dd_HH_mm_ss.getPattern());
    }

    /**
     * 将date转为yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getDateFromString(Date date) {
        date.setTime(date.getTime() - 1000);
        return getDate2FormatString(date);
    }

    /**
     * date 转yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getDateString(Date date) {
        return DateFormatUtils.format(date, DatePatternEnum.yyyy_MM_dd.getPattern());
    }

    /**
     * date 转yyyyMMddHHmmss
     */
    public static String getDateString2(Date date) {
        return DateFormatUtils.format(date, DatePatternEnum.yyyyMMddHHmmss.getPattern());
    }

    /**
     * date 转yyyyMMdd
     */
    public static String getDateString3(Date date) {
        return DateFormatUtils.format(date, DatePatternEnum.yyyyMMdd.getPattern());
    }

    /**
     * date 转HH:mm:ss
     */
    public static String getDateString4(Date date) {
        return DateFormatUtils.format(date, DatePatternEnum.HH_mm_ss.getPattern());
    }

    /**
     * date 转yyyyMMddHHmmssS
     */
    public static String getDateString5(Date date) {
        return DateFormatUtils.format(date, DatePatternEnum.yyyyMMddHHmmssS.getPattern());
    }

    /**
     * 获取当前日期（指定日期格式）
     *
     * @param datePatternEnum
     * @return
     */
    public static String currentDate(DatePatternEnum datePatternEnum) {
        return DateFormatUtils.format(new Date(), datePatternEnum.getPattern());
    }

    /**
     * long型时间戳--转--String型
     *
     * @return
     */
    public static String longToString(Long dateLong, DatePatternEnum datePatternEnum) {
        String formatTime = "";
        try {
            formatTime = DateFormatUtils.format(dateLong, datePatternEnum.getPattern());
        } catch (Exception e) {
            log.error("日期格式转换异常", e);
        }
        return formatTime;
    }
    // @TODO++++++++++++++++++++++++++++++++++++   日期字符串 ===>>>>日期 ++++++++++++++++++++++++++++++++++++

    /**
     * 将yyyy-MM-dd HH:mm:ss 转date
     *
     * @param dateStr 日期字符串
     * @return
     */
    public static Date getString2Date(String dateStr) {
        Date d = null;
        if (ParamUtil.isEmpty(dateStr)) {
            return null;
        }
        try {
            d = DateUtils.parseDate(dateStr, DatePatternEnum.yyyy_MM_dd_HH_mm_ss.getPattern());
        } catch (ParseException e) {
            log.error("日期格式转换异常", e);
        }
        return d;
    }

    /**
     * 将yyyy_MM_dd 转date
     *
     * @param dateStr 日期字符串
     * @return
     */
    public static Date getString2Date2(String dateStr) {
        Date d = null;
        if (ParamUtil.isEmpty(dateStr)) {
            return null;
        }
        try {
            d = DateUtils.parseDate(dateStr, DatePatternEnum.yyyy_MM_dd.getPattern());
        } catch (ParseException e) {
            log.error("日期格式转换异常", e);
        }
        return d;
    }

    /**
     * 将日期字符串转为日期类型
     *
     * @param dateStr    日期
     * @param datePatternEnum 转化格式
     * @return
     */
    public static Date getString2Date(String dateStr, DatePatternEnum datePatternEnum) {
        Date d = null;
        try {
            d = DateUtils.parseDate(dateStr, datePatternEnum.getPattern());
        } catch (ParseException e) {
            log.error("日期格式转换异常", e);
        }
        return d;
    }

    /**
     * 将年月日格式（yyyy-MM-dd yyyyMMdd yyyy年MM月dd日）
     * 转化为date格式
     * @param dateStr
     * @return
     */
    public static Date dateStr2Date(String dateStr) {
        if (ParamUtil.isEmpty(dateStr)) {
            log.info("dateStr不能为空");
            return null;
        }
        dateStr = dateStr.replaceAll("(?:年|月|日|-)", "");
        return getString2Date(dateStr,DatePatternEnum.yyyyMMdd);
    }
    // @TODO++++++++++++++++++++++++++++++++++++   日期字符串 ===>>>>日期字符串 ++++++++++++++++++++++++++++++++++++

    /**
     * 将yyyy-MM-dd HH:mm:ss日期字符串转为指定格式字符串
     *
     * @param dateStr   日期字符串
     * @param toDatePatternEnum 转化格式
     * @return
     */
    public static String getString2DateString(String dateStr,DatePatternEnum toDatePatternEnum) {
        return getString2DateStringByFormay(dateStr, DatePatternEnum.yyyy_MM_dd_HH_mm_ss, toDatePatternEnum);
    }

    /**
     * 将日期字符串转为另一种格式化字符串
     *
     * @param dateStr     日期字符串
     * @param fromDatePatternEnum 原格式
     * @param toDatePatternEnum   转化格式
     * @return
     */
    public static String getString2DateStringByFormay(String dateStr, DatePatternEnum fromDatePatternEnum, DatePatternEnum toDatePatternEnum) {
        String resDate = "";
        try {
            Date date = getString2Date(dateStr, fromDatePatternEnum);
            resDate = getDate2FormatString(date, toDatePatternEnum);
        } catch (Exception e) {
            log.error("日期格式转换异常", e);
        }
        return resDate;
    }


    // @TODO+++++++++++++++++++++++++++++++++++++++++++++++   日期编辑 +++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * 指定时间加指定日期后的时间
     *
     * @param date     日期
     * @param timeFlag 增加日期(m-1,h-1)
     * @return
     */
    public static Date addAssignTime(Date date, String timeFlag,Date effectiveTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String[] timeoutFlag = timeFlag.split("-");
        String type = timeoutFlag[0];
        Integer time = ParamUtil.toInteger(timeoutFlag[1]);
        if (type.equals("h")) {
            return addDateHour(date, time);
        } else if (type.equals("d")) {
            if (time.equals(0)) {
                return getString2Date(addOneDay24(), DatePatternEnum.yyyyMMddHHmmss);
            }
            return addDateDay(date, time);
        } else if (type.equals("m")) {
            return addDateMonth(date, time);
        } else if (type.equals("y")) {
            return addDateYears(date, time);
        } else if (type.equals("e")) {
            if (time.equals(0)){
                return effectiveTime;
            }else {
                return addDateYears(effectiveTime, time);
            }
        } else {
            return new Date();
        }
    }
    /**
     * 指定时间加指定日期后的时间
     *
     * @param date     日期
     * @param timeFlag 增加日期(m-1,h-1)
     * @return
     */
    public static Date addAssignDate(Date date,String timeF,String timeFlag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String[] timeoutFlag = timeFlag.split("-");
        String type = timeoutFlag[0];
        Integer time = ParamUtil.toInteger(timeoutFlag[1]);
        if (type.equals("h")) {
            return addDateHour(nextHourDate(date), time);
        } else if (type.equals("d")) {
            if (time.equals(0)) {
                return getString2Date(addOneDay24(), DatePatternEnum.yyyy_MM_dd_HH_mm_ss);
            }
            if (ParamUtil.isNotEmpty(timeF)){
                String[] timeoutF = timeF.split("-");
                String typeFlag = timeoutF[0];
                Integer timeValue = ParamUtil.toInteger(timeoutF[1]);
                if (typeFlag.equals("h")){
                    return getDateHour(addDateDay(getString2Date2(getDateString(date)), time+1),timeValue);
                }
            }
            return addDateDay(getString2Date2(getDateString(date)), time);
        }else {
            return new Date();
        }
    }

    public static Date getDateHour(Date date,int value) {
        date.setTime(date.getTime() - value*60*1000);
        return date;
    }
    //取传入时间的下一个小时整数时间
    public static Date nextHourDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //获得当前时间下一个小时
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 计算当前时间加一天后的时间
     *
     * @return yyyy-MM-dd时间格式字符串
     */
    public static String addOneDay() {
        return dateAddDay(new Date(), 1);
    }

    /**
     * 当前日期编辑指定天数后的日期
     *
     * @param dayAmount 天数(正加，负减)
     * @return yyyy-MM-dd时间格式字符串
     */
    public static String nowAddDay(int dayAmount) {
        return dateAddDay(new Date(), dayAmount);
    }

    /**
     * 指定日期编辑指定天数后的日期
     *
     * @param date
     * @param dayAmount 天数(正加，负减)
     * @return yyyy-MM-dd时间格式字符串
     */
    public static String dateAddDay(Date date, int dayAmount) {
        Date date1 = DateUtils.addDays(date, dayAmount);
        return getDate2FormatString(date1);
    }


    /**
     * 编辑日期b并返回指定格式
     * @param date
     * @param dayAmount 天数（-1，为负，1为正）
     * @param datePatternEnum
     * @return
     */
    public static String dateAddDayAnd2Format(Date date, int dayAmount,DatePatternEnum datePatternEnum) {
        Date date1 = DateUtils.addDays(date, dayAmount);
        return getDate2FormatString(date1,datePatternEnum);
    }

    /**
     * 编辑当前日期
     *
     * @param dayNum
     * @param monthNum
     * @param yearNum
     * @return
     */
    public static Date editDate(int dayNum, int monthNum, int yearNum) {
        return editDate(null, dayNum, monthNum, yearNum,0);
    }

    /**
     * 编辑指定日期
     *
     * @param date
     * @param dayNum
     * @param monthNum
     * @param yearNum
     * @return
     */
    public static Date editDate(Date date, int dayNum, int monthNum, int yearNum, int hourNum) {
        if (null == date) {
            date = new Date();
        }
        return editDate(date, dayNum, monthNum, yearNum, hourNum, 0, 0);
    }

    /**
     * 编辑指定日期
     *
     * @param dayNum
     * @param monthNum
     * @param yearNum
     * @return
     */
    public static Date editDate(Date date, int dayNum, int monthNum, int yearNum, int hhNum, int mmNum, int ssNum) {
        Calendar cl = Calendar.getInstance();
        cl.setTimeInMillis(date.getTime());
        if (dayNum != 0) {
            cl.add(Calendar.DAY_OF_YEAR, dayNum);
        }
        if (monthNum != 0) {
            cl.add(Calendar.MONTH, monthNum);
        }
        if (yearNum != 0) {
            cl.add(Calendar.YEAR, yearNum);
        }
        if (hhNum != 0) {
            cl.add(Calendar.HOUR, hhNum);
        }
        if (mmNum != 0) {
            cl.add(Calendar.MINUTE, mmNum);
        }
        if (ssNum != 0) {
            cl.add(Calendar.SECOND, ssNum);
        }
        return new Date(cl.getTimeInMillis());
    }

    //小时
    public static Date addDateHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    //24时
    public static Date addDateToHour(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, days);
        return calendar.getTime();
    }

    /**
     * 在指定的date上 + days 天
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDateDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days); //天
        return calendar.getTime();
    }

    /**
     * 在指定的date上 +  月
     *
     * @param date
     * @param months
     * @return
     */
    public static Date addDateMonth(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months); //天

        return calendar.getTime();
    }

    /**
     * 在指定的date上 +  年
     *
     * @param date
     * @param years
     * @return
     */
    public static Date addDateYears(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years); //天
        return calendar.getTime();
    }

    /**
     * 根据一个时间用 m-*、y-*、d-*
     * type "-" 代表减去时间
     */
    public static Date getDateByFlagAndType(Date date, String flag, String type, int age) {
        String[] flags = flag.split("-");
        String dateFlag = flags[0];
        int timeValue = Integer.parseInt(flags[1]);
        if ("-".equals(type)) {
            timeValue = -timeValue;
        }
        if ("d".equals(dateFlag)) {
            return addDateDay(date, timeValue);
        } else if ("m".equals(dateFlag)) {
            return addDateMonth(date, timeValue);
        } else if ("y".equals(dateFlag)) {
            return addDateYears(date, timeValue);
        } else if ("yy".equals(dateFlag)) {
            return addDateYears(date, timeValue - age);
        } else {
            return new Date();
        }
    }

    /**
     * 按天加减日期
     *
     * @param dayNum
     * @return
     */
    public static Date addDateByDay(int dayNum) {
        return editDate(dayNum, 0, 0);
    }

    /**
     * 按月加减日期
     *
     * @param monthNum
     * @return
     */
    public static Date addDateByMonth(int monthNum) {
        return editDate(0, monthNum, 0);
    }

    /**
     * 按年加减日期
     *
     * @param yearNum
     * @return
     */
    public static Date addDateByYear(int yearNum) {
        return editDate(0, 0, yearNum);
    }

    /**
     * 获取当天24点
     *
     * @return
     */
    public static Long getTimesNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 计算当天时间与今天结束的时候
     *
     * @return
     */
    public static Long getTimeOfNowToTodayEnd() {
        long nowTime = System.currentTimeMillis();
        long todayTime = getTimesNight();
        return todayTime - nowTime;
    }

    /**
     * 比较输入的日期与当前日期24点的时间大小
     *
     * @param date
     * @return
     */
    public static long compareDateWithToday(Date date) {
        long dateTime = date.getTime();
        long todayTime = getTimesNight();
        return todayTime - dateTime;
    }


    public static Date getDateByFlag(String flag) {
        return getDateByFlagAndType(flag, null);
    }

    public static Date getDateByFlagAndType(String flag, String type) {
        String[] flags = flag.split("-");
        String dateFlag = flags[0];
        int timeValue = Integer.parseInt(flags[1]);
        if ("-".equals(type)) {
            timeValue = -timeValue;
        }
        if ("d".equals(dateFlag)) {
            return addDateByDay(timeValue);
        } else if ("m".equals(dateFlag)) {
            return addDateByMonth(timeValue);
        } else if ("y".equals(dateFlag)) {
            return addDateByYear(timeValue);
        } else {
            return new Date();
        }
    }

    public static Date dateAddTime(String endDate, int addNum) {
        Date sDate = getString2Date(endDate, DatePatternEnum.yyyy_MM_dd);
        //要实现日期+1 需要String转成Date类型
        Calendar c = Calendar.getInstance();
        c.setTime(sDate);
        c.add(Calendar.DAY_OF_MONTH, addNum);  //利用Calendar 实现 Date日期+1天
        sDate = c.getTime();
        //将日期转成String类型
        return sDate;
    }
    // @TODO+++++++++++++++++++++++++++++++++++++++++++++++   处理时间差额 +++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * 获取两个时间之间小时数
     *
     * @param fromTime
     * @param toTime
     * @return
     */
    public static int getDaysBetweenTimeHH(String fromTime, String toTime) {
        Date from = getString2Date(fromTime, DatePatternEnum.yyyy_MM_dd_HH_mm_ss);
        Date to = getString2Date(toTime, DatePatternEnum.yyyy_MM_dd_HH_mm_ss);
        long days = (to.getTime() - from.getTime()) / (1000 * 60 * 60);
        return (int) days;
    }

    /**
     * 计算两个日期之间相差的时间
     *
     * @param smallDayFlag
     * @param largeDayFlag
     * @param intervalType
     * @return
     */
    public static int getInterval(String smallDayFlag, String largeDayFlag, String intervalType) {
        Date smallDate = getDateByFlag(smallDayFlag);
        Date largeDate = getDateByFlag(largeDayFlag);
        return getIntervalByDate(smallDate, largeDate, intervalType);
    }

    /**
     * 计算两个日期之间相差的时间
     *
     * @param smallDate
     * @param largeDate
     * @param intervalType
     * @return
     */
    public static int getIntervalByDate(Date smallDate, Date largeDate, String intervalType) {
        long millisecond = largeDate.getTime() - smallDate.getTime();
        if ("ss".equals(intervalType)) { //秒
            return (int) (millisecond / 1000);
        } else if ("mm".equals(intervalType)) { //分
            return (int) (millisecond / (1000 * 60));
        } else if ("HH".equals(intervalType)) { //小时
            return (int) (millisecond / (1000 * 60 * 60));
        } else if ("dd".equals(intervalType)) { //天
            return (int) (millisecond / (1000 * 60 * 60 * 24));
        }
        return 0;
    }

    public static int getBirthdayToNowInterval(String birthdayNoYear, String intervalType) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        Date birthday = DateUtil.getString2Date(year + birthdayNoYear, DatePatternEnum.yyyyMMdd);
        Date nowDay = getString2Date(getDate2FormatString(new Date(), DatePatternEnum.yyyyMMdd), DatePatternEnum.yyyyMMdd);
        int interval = DateUtil.getIntervalByDate(nowDay, birthday, intervalType);
        return interval;
    }

    public static Date getMiddleDate(Date from, Date end) {
        int intervalDay = getIntervalByDate(from, end, "dd");
        if (intervalDay % 2 != 0) {
            intervalDay += 1;
        }
        int addDay = intervalDay / 2;
        Calendar cl = Calendar.getInstance();
        cl.setTimeInMillis(from.getTime());
        cl.add(Calendar.DAY_OF_YEAR, addDay);
        return cl.getTime();
    }

    public static boolean isInDate(Date checkDate, Date fromDate, Date toDate) {
        long checkDateTime = checkDate.getTime();
        long fromTime = fromDate.getTime();
        long toTime = toDate.getTime();
        if (fromTime - checkDateTime <= 0 && toTime - checkDateTime >= 0) {
            return true;
        }
        return false;
    }


    /**
     * 获取两个时间之间的天数（后面时间-前面时间）
     *
     * @param fromTime
     * @param toTime
     * @return
     */
    public static int getDaysBetweenTime(String fromTime, String toTime) {
        Date from = getString2Date(fromTime, DatePatternEnum.yyyy_MM_dd_HH_mm_ss);
        Date to = getString2Date(toTime, DatePatternEnum.yyyy_MM_dd_HH_mm_ss);
        return getDaysBetweenTime(from, to);
    }

    /**
     * 两个时间相差的秒数
     *
     * @param begin
     * @param end
     * @return
     */
    public static long compareDifferSecond(Date begin, Date end) {
        if (begin == null || end == null) {
            return 0;
        }
        long second = (end.getTime() - begin.getTime()) / 1000;    //转换成秒
        return second;
    }

    /**
     * 两个时间相差的小时数
     *
     * @param begin
     * @param end
     * @return
     */
    public static long compareDifferHours(Date begin, Date end) {
        if (null == begin || null == end) {
            return -1;
        }
        long intervalMilli = end.getTime() - begin.getTime();
        return intervalMilli / (60 * 60 * 1000);
    }

    /**
     * @return java.lang.Long
     * @Author zhouqifen
     * @Description 获得两个时间差的毫秒数
     * @Date 2018/8/22 15:17
     * @Param [endDate, nowDate]
     **/
    public static Long getPoorMilliSecond(Date endDate, Date nowDate) {
        Long millisecond = endDate.getTime() - nowDate.getTime();
        return millisecond;
    }

    /**
     * @return java.lang.Long
     * @Author DateString
     * @Description 获得两个时间差的毫秒数
     * @Date 2018/8/22 15:17
     * @Param [endDate, nowDate]
     **/
    public static Long getPoorMilliSecond(String nowDate, String endDate) {
        Date endDateTem = getString2Date(endDate, DatePatternEnum.yyyy_MM_dd_HH_mm_ss);
        Date nowDateTem = getString2Date(nowDate, DatePatternEnum.yyyy_MM_dd_HH_mm_ss);
        return getPoorMilliSecond(endDateTem, nowDateTem);
    }

    /**
     * @return java.lang.Long
     * @Author zhouqifen
     * @Description 获得当天的23:59:59 到当前的时间差秒
     * @Date 2018/9/12 15:31
     * @Param []
     **/
    public static int getPoorTime() {
        Date endTime = getEndOfDay(new Date());
        Long diff = endTime.getTime() - new Date().getTime();
        return (int) (diff / 1000);
    }

    /**
     * 获取两个时间之间的天数（后面时间-前面时间）
     */
    public static int getDaysBetweenTime(Date fromTime, Date toTime) {
        Long days = (toTime.getTime() - fromTime.getTime()) / (1000 * 60 * 60 * 24);
        return days.intValue();
    }

    /**
     * 获取当前日期与下个生日的时间差
     *
     * @param clidate 生日 yyyy-MM-dd
     * @return
     */
    public static long getNowToBirthdayDays(String clidate) {
        try {
            Calendar cToday = Calendar.getInstance(); // 存今天
            Calendar cBirth = Calendar.getInstance(); // 存生日
            cBirth.setTime(getString2Date(clidate, DatePatternEnum.yyyy_MM_dd)); // 设置生日
            cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR)); // 修改为本年
            int days;
            if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
                // 生日已经过了，要算明年的了
                days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
                days += cBirth.get(Calendar.DAY_OF_YEAR);
            } else {
                // 生日还没过
                days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
            }
            // 输出结果
            if (days == 0) {
                log.info("今天生日");
                return 0;
            } else {
                log.info("距离生日还有：" + days + "天");
                return days;
            }
        } catch (Exception e) {
            log.error("getNowToBirthdayDays异常", e);
        }
        return 0;
    }

    /**
     * 计算两个时间之间的月份差
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */

    public static int getDaysBetweenMonth(Date  date1,Date  date2){
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(date1);
        end.setTime(date2);
        int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);
    }

    /**
     * 差值超过9个月算1年个月内
     * @param date1
     * @param date2
     * @return
     */
    public static long getDaysBetweenYear(Date  date1,Date  date2){
        long diff = Math.abs(date1.getTime() - date2.getTime());
        long year = diff / (1000L * 60L * 60L*24L * 365L);
        long days = (diff-year*(1000L * 60L * 60L*24L * 365L)) / (1000L * 60L * 60L * 24L);
        if(days>275){
            year++;
        }
        return year;
    }


    // @TODO+++++++++++++++++++++++++++++++++++++++++++++++   获取特定时间 +++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * 本月第一天
     *
     * @return
     */
    public static Date getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 下月第一天
     * @return
     */
    public static Date getFirstDayOfNextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 下月几号
     * @param date
     * @return
     */
    public static Date getDayOfNextMonth(int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 本月的最后一天
     *
     * @return
     */
    public static Date getLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date getDayOfCurrentMonth(int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    public static String getCHNMonth(int month) {
        String chnMonth = "";
        switch (month) {
            case 1:
                chnMonth = "一";
                break;
            case 2:
                chnMonth = "二";
                break;
            case 3:
                chnMonth = "三";
                break;
            case 4:
                chnMonth = "四";
                break;
            case 5:
                chnMonth = "五";
                break;
            case 6:
                chnMonth = "六";
                break;
            case 7:
                chnMonth = "七";
                break;
            case 8:
                chnMonth = "八";
                break;
            case 9:
                chnMonth = "九";
                break;
            case 10:
                chnMonth = "十";
                break;
            case 11:
                chnMonth = "十一";
                break;
            case 12:
                chnMonth = "十二";
                break;
            default:
                chnMonth = "";
        }
        return chnMonth;
    }


    /**
     * 当天24点
     *
     * @return
     */
    public static String addOneDay24() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return longToString(cal.getTimeInMillis(), DatePatternEnum.yyyyMMddHHmmss);
    }


    /**
     * 获取当前小时
     */
    public static String getNowHourForGreetings() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        String content = "";
        if (hour >= 3 && hour <= 7) {
            content = "早上好";
        }
        if (hour >= 8 && hour <= 10) {
            content = "上午好";
        }
        if (hour >= 11 && hour <= 13) {
            content = "中午好";
        }
        if (hour >= 14 && hour <= 19) {
            content = "下午好";
        }
        if (hour >= 20 || hour <= 2) {
            content = "晚上好";
        }
        return content;
    }

    /**
     * @return java.util.Date
     * @Author zhouqifen
     * @Description 获得某天的23:59:59
     * @Date 2018/9/12 15:29
     * @Param [date]
     **/
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        ;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 判断日期是否为yyyy-mm-dd格式
     * true:yyyy-mm-dd，false:其他格式
     *
     * @param Date
     * @return
     */
    public static boolean isValidDate(String Date) {
        String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
        String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
                + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
                + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
                + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
                + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
                + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
        if ((Date != null)) {
            Pattern pattern = Pattern.compile(datePattern1);
            Matcher match = pattern.matcher(Date);
            if (match.matches()) {
                pattern = Pattern.compile(datePattern2);
                match = pattern.matcher(Date);
                return match.matches();
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * @return java.util.Date
     * @Author zhouqifen
     * @Description 获得某天的 00:00:00
     * @Date 2018/9/12 15:30
     * @Param [date]
     **/
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String addByTimeUnit(String beginDateStr, int amount, int unit, DatePatternEnum pattern) {
        Date date = addByTimeUnit(beginDateStr, amount, unit);
        return new SimpleDateFormat(pattern.getPattern()).format(date);
    }


    public static Date addByTimeUnit(String beginDateStr, int amount, int unit) {
        return addByTimeUnit(dateStr2Date(beginDateStr), amount, unit);
    }


    public static Date addByTimeUnit(Date beginDate, int amount, int unit) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(beginDate);
        cl.add(unit, amount);
        return cl.getTime();
    }

    /**
     * 获取本月第几天
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static boolean isBirthdayFlag(String birthday,String effectiveDateStart) throws Exception{
        String[] d = effectiveDateStart.split("-");
        String s = d[1];
        String[] birthdayAs = birthday.split("-");
        LocalDate dateOfBirth = LocalDate.of(Integer.valueOf(birthdayAs[0]), Integer.valueOf(birthdayAs[1]), Integer.valueOf(birthdayAs[2]));
        MonthDay birthdayA = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        LocalDate tomorrow = LocalDate.now().plusDays(Integer.valueOf(s));
        MonthDay currentMonthDay = MonthDay.from(tomorrow);
        if (currentMonthDay.equals(birthdayA)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否生日
     * @param birthday  yyyy_MM_dd 格式
     * @param effectivetime yyyy_MM_dd_HH_mm_ss 格式
     * @return
     * @throws Exception
     */
    public static boolean whetherBirthday(String birthday,String effectivetime) throws Exception{
        String birthdayMMdd = DateUtil.getString2DateStringByFormay(birthday, DatePatternEnum.yyyy_MM_dd, DatePatternEnum.MMdd);
        String effectivetimeMMdd = DateUtil.getString2DateStringByFormay(effectivetime, DatePatternEnum.yyyy_MM_dd_HH_mm_ss, DatePatternEnum.MMdd);
        if(birthdayMMdd.equals(effectivetimeMMdd)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = dateAddDay(new Date(), -1);
        System.out.println(s);
        String endTime = DateUtil.dateAddDayAnd2Format(new Date(),-1,DatePatternEnum.yyyyMMdd);
        System.out.println(endTime);
        System.out.println(DateUtil.getDateString(addDateByMonth(-1)));
        System.out.println(getFirstDayOfNextMonth());
    }
}
