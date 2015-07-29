package health.demkin.ru.tanita;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Date;
import health.demkin.ru.tanita.models.TanitaState;
import health.demkin.ru.tanita.services.StateService;


public class WeughtInputFragment extends Fragment {

    private Button button;

    private EditText etWeight;
    private EditText etFat;
    private EditText etBodyType;
    private EditText etBone;
    private EditText etCalorieNeed;
    private EditText etFatV;
    private EditText etMuscul;
    private EditText etInnerAge;

    public static WeughtInputFragment newInstance(int sectionNumber) {
        WeughtInputFragment fragment = new WeughtInputFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weighing, parent, false);

        button = (Button)v.findViewById(R.id.button_apply);

        etBodyType = (EditText)v.findViewById(R.id.bodyType_title4);
        etBone= (EditText)v.findViewById(R.id.bone_title6);
        etCalorieNeed = (EditText)v.findViewById(R.id.calorie_title7);
        etFat = (EditText)v.findViewById(R.id.fat_title);
        etFatV = (EditText)v.findViewById(R.id.fatv_title8);
        etInnerAge = (EditText)v.findViewById(R.id.age_title);
        etMuscul  = (EditText)v.findViewById(R.id.muskul_title);
        etWeight  = (EditText)v.findViewById(R.id.weight_title);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 apply(v);
            }
        });
        return v;
    }

    public void apply(View v){
        try {
            StateService service = new StateService(getActivity().getApplicationContext());

            TanitaState ts = new TanitaState();
            ts.setWeight(Float.parseFloat(etWeight.getText().toString()));
            ts.setFat(Float.parseFloat(etFat.getText().toString()));
            ts.setBodyType(Integer.parseInt(etBodyType.getText().toString()));
            ts.setBone(Float.parseFloat(etBone.getText().toString()));
            ts.setCalorieNeed(Integer.parseInt(etCalorieNeed.getText().toString()));
            ts.setFatV(Float.parseFloat(etFatV.getText().toString()));
            ts.setMuscul(Float.parseFloat(etMuscul.getText().toString()));
            ts.setInnerAge(Integer.parseInt(etInnerAge.getText().toString()));
            ts.setMeasureTime(new Date());
            ts.setUserID(1);

            service.addState(ts);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, WeightListFragment.newInstance(1 + 1)).commit();
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(),"Ошибка ввода. Причина: "+e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

}
