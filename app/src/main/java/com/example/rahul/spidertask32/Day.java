package com.example.rahul.spidertask32;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Rahul on 08-07-2017.
 */

public class Day {



    Condition condition;
    String avghumidity;
    String maxtemp_c;
    String avgtemp_c;
    String mintemp_c;
    String maxwind_kph;


    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(String avghumidity) {
        this.avghumidity = avghumidity;
    }

    public String getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(String maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public String getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(String avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public String getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(String mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public String getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(String maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }


}
