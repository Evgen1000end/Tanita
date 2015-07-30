package health.demkin.ru.tanita.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import health.demkin.ru.tanita.subject.NotificationManager;

public class TaskReceiver extends BroadcastReceiver {

    public TaskReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
        NotificationManager  nm = new NotificationManager(context);
        nm.NotifyInTray();

    }
}
