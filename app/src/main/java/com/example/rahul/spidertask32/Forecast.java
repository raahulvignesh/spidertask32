package com.example.rahul.spidertask32;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rahul on 08-07-2017.
 */

public class Forecast {

    @SerializedName("forecastday")
    List<Forecastday> forecastday;


    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

    public List<Forecastday> getForecastday() {
        return forecastday;

    }


}
