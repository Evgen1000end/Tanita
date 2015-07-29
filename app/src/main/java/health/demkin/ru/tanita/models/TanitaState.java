package health.demkin.ru.tanita.models;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by evgen1000end on 07.03.2015.
 */
public class TanitaState {

    private float weight;
    private float fat;
    private float muscul;
    private int id;
    private int innerAge;
    private int bodyType;
    private int calorieNeed;
    private float fatV;
    private float bone;
    private int userID;
    private float water;

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    private DateTime measureTime;

    public TanitaState(){

    }


    public TanitaState(float weight, float fat, float muscul, int id,
                       int innerAge, int bodyType, int calorieNeed, float fatV,
                       float bone, int userID, DateTime measureTime, float water) {
        this.weight = weight;
        this.fat = fat;
        this.muscul = muscul;
        this.id = id;
        this.innerAge = innerAge;
        this.bodyType = bodyType;
        this.calorieNeed = calorieNeed;
        this.fatV = fatV;
        this.bone = bone;
        this.userID = userID;
        this.measureTime = measureTime;
        this.water = water;
    }

    public TanitaState(int id, float weight, float fat, DateTime measureTime){
        this.weight = weight;
        this.fat = fat;
        this.id = id;
        this.measureTime = measureTime;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getMuscul() {
        return muscul;
    }

    public void setMuscul(float muscul) {
        this.muscul = muscul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInnerAge() {
        return innerAge;
    }

    public void setInnerAge(int innerAge) {
        this.innerAge = innerAge;
    }

    public int getBodyType() {
        return bodyType;
    }

    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }

    public int getCalorieNeed() {
        return calorieNeed;
    }

    public void setCalorieNeed(int calorieNeed) {
        this.calorieNeed = calorieNeed;
    }

    public float getFatV() {
        return fatV;
    }

    public void setFatV(float fatV) {
        this.fatV = fatV;
    }

    public float getBone() {
        return bone;
    }

    public void setBone(float bone) {
        this.bone = bone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public DateTime getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(DateTime measureTime) {
        this.measureTime = measureTime;
    }
}
