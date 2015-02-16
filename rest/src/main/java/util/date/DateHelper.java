package util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Deniel on 04.02.2015.
 */
public class DateHelper {

    final long monthsInMillis = 60L * 60L * 1000L;

    /**
     * Format: dd.MM.yyyy hh:mm:ss
     * @return util.date
     */
    public static Date getFullDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return getDate(date, dateFormat);
    }

    /**
     * Format: dd.MM.yyyy
     * @return util.date
     */
    public static Date getDayDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return getDate(date, dateFormat);
    }


    /**
     * Format: MM.yyyy
     * @return util.date
     */
    public static Date getMonthDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.yyyy");
        return getDate(date, dateFormat);
    }

    public static Date getDate(String date, SimpleDateFormat dateFormat) {
        Date result = null;
        try {
            result = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Date addMonth(Date original, int months){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(original);
        calendar.add(Calendar.MONTH, months);

        Date result = new Date(calendar.getTimeInMillis());
        return result;
    }

}
