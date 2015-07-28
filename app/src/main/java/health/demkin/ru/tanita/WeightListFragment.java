package health.demkin.ru.tanita;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import health.demkin.ru.tanita.models.TanitaState;
import health.demkin.ru.tanita.services.StateService;

/**
 * Created by evgen1000end on 07.03.2015.
 */
public class WeightListFragment extends ListFragment {

    private List<TanitaState> list;

    final int MENU_DELETE = 1;
    final int MENU_STATE = 2;

    public static WeightListFragment newInstance(int sectionNumber) {
        WeightListFragment fragment = new WeightListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StateService service = new StateService(getActivity().getApplicationContext());
        List<TanitaState>  stateList = service.findAllStates();

        StateAdapter adapter = new StateAdapter(stateList);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        TanitaState ts = (TanitaState)(getListAdapter()).getItem(position);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    private class StateAdapter extends ArrayAdapter<TanitaState> {
        public StateAdapter(List<TanitaState> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.fragment_weighing_list, null);
            }

            TanitaState c = getItem(position);
            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.weight_title_in_list);
            titleTextView.setText("Вес: "+Double.toString(c.getWeight()));

            TextView titleTextView2 =
                    (TextView)convertView.findViewById(R.id.weight_title_in_list2);
            titleTextView2.setText("Жир:  "+Double.toString(c.getFat()));

            TextView titleDate =(TextView)convertView.findViewById(R.id.weight_title_date);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //.format(c.getMeasureTime());
            Date date = c.getMeasureTime();

            String measureDate;

            if (date==null)
            {
                measureDate = "No date";
            }else {
                measureDate = dateFormat.format(date);
            }

            titleDate.setText("Дата взвешивания: "+measureDate);

            return convertView;
        }





    }



}
