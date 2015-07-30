package health.demkin.ru.tanita.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import health.demkin.ru.tanita.subject.NotificationManager;

public class TaskReceiver extends BroadcastReceiver {

    public TaskReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

       // PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
      //  PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
      //  wl.acquire();

        Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
        NotificationManager  nm = new NotificationManager(context);
        nm.NotifyInTray();

     //   wl.release();

    }
}
