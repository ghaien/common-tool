package cn.ghaien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ghaien on 2017/7/6.
 * @see String
 * @see Date
 * @see SimpleDateFormat
 * @since 1.7
 */
public class DateUtils {

    public static final int SECOND = 1000;

    public static final int MINUTE = 60 * 1000;

    public static final int HOUR = 60 * 60 * 1000;

    public static final int DAY = 24 * 60 * 60 * 1000;

    public static final int[] UNITS = new int[]{SECOND, MINUTE, HOUR, DAY};

    /**
     * 将日期类型转换为指定格式的字符串
     * @param date 需要转换的日期
     * @param pattern 指定格式 例如:yyyy-MM-dd
     * @return 转换后的字符串
     */
    public static String dateToStr(Date date, String pattern) {
        if (date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 将指定格式的字符串转换为日期类型
     * @param str 需要转换的字符串
     * @param pattern 指定格式
     * @return 转换后的日期对象
     */
    public static Date strToDate(String str, String pattern){
        if (str == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 计算指定时间与当前时间的差值
     * 例如 当前时间是2017-07-06 传入date为2017-07-05与DateUtils.DAY返回1(天)
     * @param date 指定时间
     * @param unit 单位
     * @return 差值
     */
    public static long betweenDateToNow(Date date, int unit) {
        if (isTrueUnit(unit))
            throw new RuntimeException("'" + unit + "'不在UNITS中");

        return betweenDateToNow(date) / unit;
    }

    /**
     * 计算指定时间与当前时间相差的毫秒值
     * @param date 指定时间
     * @return 相差毫秒数
     */
    public static long betweenDateToNow(Date date) {
        if (date == null)
            return 0L;
        Date now = new Date();
        long nowLong = now.getTime();
        long dateLong = date.getTime();
        return nowLong - dateLong;
    }

    // 判断unit值是否属于UNITS数组
    private static boolean isTrueUnit(int unit) {
        for (int u : UNITS)
            if (unit == u)
                return false;
        return true;
    }

    /**
     * 计算两个时间之间的差值 例如传入unit = DAY 则求两个时间之间相差的天数
     * @param begin 开始时间
     * @param end 结束时间
     * @param unit 单位
     * @return 差值
     */
    public static long betweenDateToDate(Date begin, Date end, int unit) {
        if (isTrueUnit(unit))
            throw new RuntimeException("'" + unit + "'不在UNITS中");

        return betweenDateToDate(begin, end) / unit;
    }

    /**
     * 计算两个指定时间相差的毫秒值
     * @param begin 开始时间
     * @param end 结束时间
     * @return 相差毫秒数
     */
    public static long betweenDateToDate(Date begin, Date end) {
        if (begin == null)
            return 0L;
        if (end == null)
            return 0L;
        long beginLong = begin.getTime();
        long endLong = end.getTime();
        return endLong - beginLong;
    }

    /**
     * 获取指定日期的凌晨时间
     * @param date 指定日期
     * @return 字符串格式的凌晨日期
     */
    public static String getBeginDate(Date date) {
        String pattern = "yyyy-MM-dd 00:00:00";
        return dateToStr(date, pattern);
    }

    /**
     * 获取指定日期的午夜时间
     * @param date 指定日期
     * @return 字符串格式的午夜日期
     */
    public static String getEndDate(Date date) {
        String pattern = "yyyy-MM-dd 23:59:59";
        return dateToStr(date, pattern);
    }

}
