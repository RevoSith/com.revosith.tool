package com.revosith.tool.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/5/27
 */
public class DateUtils {

    /**
     * 时间格式 yyyy-MM-dd
     */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static final ParsePosition DEFAULT_POSITION = new ParsePosition(0);

    @SuppressWarnings("rawtypes")
    private static ThreadLocal<Map<String, SimpleDateFormat>> threadLocal = new ThreadLocal<Map<String, SimpleDateFormat>>() {
        protected synchronized Map<String, SimpleDateFormat> initialValue() {
            Map<String, SimpleDateFormat> formatMap = new HashMap<>();
            formatMap.put(DATE_FORMAT_YYYY_MM_DD, new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD));
            formatMap.put(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS, new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
            return formatMap;
        }
    };

    private static SimpleDateFormat getDateFormat(String format) {
        return threadLocal.get().get(format);
    }

    /**
     * 线程优化版  str->date
     *
     * @param textDate
     * @param format
     * @return
     */
    public static Date parse(String textDate, String format) {
        return getDateFormat(format).parse(textDate, DEFAULT_POSITION);
    }

    /**
     * 线程优化版 date->str
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        return getDateFormat(format).format(date);
    }

    /**
     * 区间合法性校验
     *
     * @param start  开始日期
     * @param end    结束日期
     * @param format 格式
     * @return 区间是否合法
     */
    private static Boolean dateRangeCheck(String start, String end, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);

        if (StringUtils.isBlank(start) || StringUtils.isBlank(end)) {
            return true;
        }

        return !sf.parse(start, new ParsePosition(0)).after(sf.parse(end, new ParsePosition(0)));
    }

    /**
     * str->date
     *
     * @param date   日期字符串
     * @param format format格式
     * @return 返回时间
     */
    public static Date getDate(String date, String format) {

        if (StringUtils.isBlank(date)) {
            return null;
        }
        return new SimpleDateFormat(format).parse(date, new ParsePosition(0));
    }

    /**
     * date->str
     *
     * @param date
     * @param format
     * @return
     */
    public static String formateDate(Date date, String format) {

        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }
}
