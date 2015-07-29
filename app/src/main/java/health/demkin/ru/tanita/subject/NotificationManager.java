package health.demkin.ru.tanita.subject;

import android.content.Context;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;

import java.util.Date;

import health.demkin.ru.tanita.services.StateService;
import health.demkin.ru.tanita.utils.SqLiteDate;

/**
 * Created by evgen1000end on 29.07.2015.
 */
public class NotificationManager {

    private Context context;

    public void NotifyInTray(){
        StateService  service = new StateService(context);

        DateTime lastMeasure = service.getLastMeasureDate();
        DateTime now = new DateTime();


        if (SqLiteDate.IsAnotherDay(lastMeasure, now)){
            String difference = SqLiteDate.diff(lastMeasure, now);

            //Todo показать сообщение в трей
        }


    }

    public NotificationManager(Context context) {
        this.context = context;
    }
}
