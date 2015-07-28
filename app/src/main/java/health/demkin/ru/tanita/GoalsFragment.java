package health.demkin.ru.tanita;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

/**
 * Created by evgen1000end on 09.03.2015.
 */
public class GoalsFragment extends ListFragment {

    public static GoalsFragment newInstance(int sectionNumber) {
        GoalsFragment fragment = new GoalsFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
