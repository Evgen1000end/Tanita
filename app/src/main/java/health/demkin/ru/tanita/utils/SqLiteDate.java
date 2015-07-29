package health.demkin.ru.tanita.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
}
