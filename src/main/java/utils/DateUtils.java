package utils;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static boolean isDateValid(String dateString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateString);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Date convertStringToDate(String dateString)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(dateString);
        return date;
    }

    public static Date convertStringToDate2(String dateString)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateString);
        return date;
    }

    public static java.sql.Date convertJavaDateToSqlDate(Date javaDate) {
        java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
        return sqlDate;
    }

    public static Time convertStringToTime(String timeString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = formatter.parse(timeString);
        return new Time(date.getTime());
    }

    public static Time convertJavaDateToSQLTime(Date javaDate) {
        return new Time(javaDate.getTime());
    }
}
