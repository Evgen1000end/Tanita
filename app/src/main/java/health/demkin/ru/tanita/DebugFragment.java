package health.demkin.ru.tanita;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by evgen1000end on 09.03.2015.
 */
public class DebugFragment extends Fragment {

    Button startService;
    Button stopService;


    public static DebugFragment newInstance(int sectionNumber) {
        DebugFragment fragment = new DebugFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_debug, container, false);

        startService = (Button)v.findViewById(R.id.btnStart);
        stopService = (Button)v.findViewById(R.id.btnStop);


        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStart(v);
            }
        });

        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStop(v);
            }
        });


        return v;
    }


    public void onClickStart(View v) {
        getActivity().startService(new Intent(getActivity(), NotificationService.class));
    }

    public void onClickStop(View v) {
        getActivity().stopService(new Intent(getActivity(), NotificationService.class));
    }
}
