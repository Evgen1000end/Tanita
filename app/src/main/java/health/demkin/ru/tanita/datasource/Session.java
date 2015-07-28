package health.demkin.ru.tanita.datasource;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by evgen1000end on 07.03.2015.
 */
public class Session {
    private static Session ourInstance;
    private Context mAppContext;
    private TestAdapter mDbHelper;

    public static Session get(Context mAppContext) {

        if (ourInstance == null) {
            ourInstance = new Session(mAppContext.getApplicationContext());
        }

        return ourInstance;
    }

    private Session(Context mAppContext) {

        mDbHelper = new TestAdapter(mAppContext);
        mDbHelper.createDatabase();
        mDbHelper.open();

       // Cursor testdata = mDbHelper.getTestData();

     //   mDbHelper.close();
    }

    public TestAdapter getmDbHelper() {
        return mDbHelper;
    }

}
