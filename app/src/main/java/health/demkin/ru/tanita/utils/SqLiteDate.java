package health.demkin.ru.tanita.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by evgen1000end on 28.07.2015.
 */
public class SqLiteDate {

    private final static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static String pattern;

    static{
        pattern = DEFAULT_PATTERN;
    }

    public static void setPattern(String pattern) {
        SqLiteDate.pattern = pattern;
    }

    public static Date StrToDateTime(String fromSQLite){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, Locale.getDefault());

        if (fromSQLite!=null){

           try {
               return dateFormat.parse(fromSQLite);
           }
           catch (Exception e){
               return null;
           }

        }else
        {
            return null;
        }
    }

    public static String DateTimeToStr(Date fromSource){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return "\""+dateFormat.format(fromSource)+"\"";
    }
}
