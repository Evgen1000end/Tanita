package health.demkin.ru.tanita.services;

import android.content.Context;
import android.database.Cursor;

import health.demkin.ru.tanita.datasource.Session;

/**
 * Created by evgen1000end on 07.03.2015.
 */
public class SourceService {

    protected Context context;

    public SourceService(Context context) {
        this.context = context;
    }

    public Cursor getDataSet(String sql){
        return Session.get(context).getmDbHelper().getResult(sql);
    }

    public void exec(String sql){
        Session.get(context).getmDbHelper().execSQL(sql);
    }
}
