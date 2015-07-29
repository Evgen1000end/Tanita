package health.demkin.ru.tanita.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.text.SimpleDateFormat;

public class SqLiteDate {

    private final static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static String pattern;

    static{
        pattern = DEFAULT_PATTERN;
    }

    public static void setPattern(String pattern) {
        SqLiteDate.pattern = pattern;
    }

    public static DateTime StrToDateTime(String fromSQLite){

        DateTimeFormatter dateFormat = DateTimeFormat.forPattern(pattern);


        if (fromSQLite!=null){

           try {
               return dateFormat.parseDateTime(fromSQLite);
           }
           catch (Exception e){
               return null;
           }

        }else
        {
            return null;
        }
    }

    public static String DateTimeToStr(DateTime fromSource){
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern(pattern);
        return "\""+dateFormat.print(fromSource)+"\"";
    }


    public static boolean IsAnotherDay(DateTime d1, DateTime d2){
        Days d = Days.daysBetween(d1, d2);

        return d.getDays()>0 && d1.dayOfYear().get()!=d2.dayOfYear().get();
    }

    public static String diff(DateTime d1, DateTime d2){
        Period period = new Period(d1, d2);

        PeriodFormatter HHMMSSFormater =
                new PeriodFormatterBuilder()
                        .printZeroAlways().minimumPrintedDigits(2).
                        appendDays().appendSeparator(" Days ").
                        appendHours().appendSeparator(":")
                        .appendMinutes().appendSeparator(":").appendSeconds().toFormatter();
        return HHMMSSFormater.print(period);
    }
}
