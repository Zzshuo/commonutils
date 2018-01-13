import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author zeus
 * @date 2017/11/1
 */
public class DateUtils {
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static String format(Date date) {
        return format(date, FORMAT);
    }

    public static String format(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String format(long time) {
        return format(time, FORMAT);
    }

    public static String format(long time, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return format(calendar.getTime(), format);
    }


    /**
     * 本周第几天
     *
     * @return
     */
    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 本周第几天
     *
     * @param time
     * @return
     */
    public static int getDayOfWeek(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 本月第几天
     *
     * @return
     */
    public static int getDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 本月第几天
     *
     * @param time
     * @return
     */
    public static int getDayOfMonth(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 本年第几天
     *
     * @return
     */
    public static int getDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 本年第几天
     *
     * @param time
     * @return
     */
    public static int getDayOfYear(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 当前天数（从1970年起1月1日）
     *
     * @return
     */
    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return (int) ((calendar.getTimeInMillis() + calendar.get(Calendar.ZONE_OFFSET)) / org.apache.commons.lang3.time.DateUtils.MILLIS_PER_DAY);
    }

}
