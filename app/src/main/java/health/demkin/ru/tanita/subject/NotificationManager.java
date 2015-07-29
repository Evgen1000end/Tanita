package health.demkin.ru.tanita.subject;

import android.content.Context;

import org.joda.time.DateTime;

import java.util.Date;

import health.demkin.ru.tanita.services.StateService;

/**
 * Created by evgen1000end on 29.07.2015.
 */
public class NotificationManager {

    private Context context;

    public void NotifyInTray(){
        StateService  service = new StateService(context);

        DateTime lastMeasure = service.getLastMeasureDate();

                


    }

    public NotificationManager(Context context) {
        this.context = context;
    }
}
