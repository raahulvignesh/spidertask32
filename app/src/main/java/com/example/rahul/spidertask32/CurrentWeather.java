package com.example.rahul.spidertask32;

import java.io.Serializable;

/**
 * Created by Rahul on 08-07-2017.
 */

public class CurrentWeather  {

    Location location;

    Current current;

    Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
