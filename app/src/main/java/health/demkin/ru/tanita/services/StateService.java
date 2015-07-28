package health.demkin.ru.tanita.services;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import health.demkin.ru.tanita.models.TanitaState;

/**
 * Created by evgen1000end on 07.03.2015.
 */
public class StateService extends  SourceService {

    public StateService(Context context) {
        super(context);
    }

    public List<TanitaState> findAllStates(){
        Cursor c = getDataSet("Select * from progress");

        List<TanitaState> stateList = new ArrayList<>();

        if (c.getCount()==0) return stateList;


        while (!c.isLast()){

            stateList.add(new TanitaState(c.getInt(0), c.getFloat(1),c.getFloat(2) ));

            c.moveToNext();
        }

        c.moveToLast();
        stateList.add(new TanitaState(c.getInt(0), c.getFloat(1),c.getFloat(2) ));

        return stateList;

    }

    public void delete(int id){
        String script = String.format("delete from progress where id =%d", id);
        exec(script);
    }

    public List<TanitaState> findStatesForDays(int days){
        return null;
    }

    public List<TanitaState> findStateByID(int id){
        return null;
    }

    public int addState(TanitaState tanitaState){

        String script = String.format
        ("Insert into progress (weight, fat, user_id, inner_age, muscul, body_type,calorie_need,fat_v, bone, water,measure_time )" +
                        " values (%f, %f, %d, %d, %f, %d, %d, %f, %f, %f,%f)",tanitaState.getWeight(),
                tanitaState.getFat(), tanitaState.getUserID(), tanitaState.getInnerAge(),tanitaState.getMuscul(),
                tanitaState.getBodyType(), tanitaState.getCalorieNeed(), tanitaState.getFatV(), tanitaState.getBone(),
                tanitaState.getWater(), tanitaState.getMeasureTime()
                ) ;

        exec(script);


        //todo - возвращать ID добавленной записи
        return 0;
    }

    public int deleteStateById(int id){
        return 0;
    }

    public int updateStateById(int id){
        return 0;
    }

}
