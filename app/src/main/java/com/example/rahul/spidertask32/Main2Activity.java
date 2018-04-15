package com.example.rahul.spidertask32;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    String finalURL;
    ProgressDialog progress;
    CurrentWeather currentweather;
    RequestQueue requestQueue;
    List<recyclerclass> Forcastclass;
    recyclerclass classt;
    private static final String TAG = "Main2Activity";
    RecyclerView recyclerView;
    Recycleradapter recycleradapter;
    String formintemp;
    String forecasthumidity;
    String forwindspeed;
    String foravgtemperature;
    String formaxtemp;
    String foricon;
    String fordesc;
    String url_city;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle bundle = getIntent().getExtras();
        url_city = bundle.getString("city");


        formintemp =bundle.getString("formintemp");

        forecasthumidity=bundle.getString("forecasthumidity");
        forwindspeed=bundle.getString("forwindspeed");
        foravgtemperature=bundle.getString("foravgtemperature");
        formaxtemp=bundle.getString("formaxtemp");
        foricon = bundle.getString("foricon");
        fordesc = bundle.getString("fordesc");
        date = bundle.getString("Date");
        int it;
        String t;

        Forcastclass = new ArrayList<recyclerclass>();
        for(int i=0;i<5;i++)
        {
            classt = new recyclerclass();
            classt.setUrl_city(url_city);

            t = concat(foravgtemperature);
            classt.setForavgtemperature(t);
            it =foravgtemperature.indexOf(" ");
            foravgtemperature=foravgtemperature.substring(it+1);
            Log.i(TAG,"average temperature feeded --- "+t.toString());

            t = concat(date);
            classt.setDate(t);
            it =date.indexOf(" ");
            date=date.substring(it+1);
            Log.i(TAG,"Date feeded --- "+t.toString());

            t = concat(formintemp);
            classt.setFormintemp(t);
            it =formintemp.indexOf(" ");
            formintemp=formintemp.substring(it+1);
            Log.i(TAG,"minimum temperature feeded --- "+t.toString());

            t = concat(formaxtemp);
            classt.setFormaxtemp(t);
            it =formaxtemp.indexOf(" ");
            formaxtemp=formaxtemp.substring(it+1);
            Log.i(TAG,"maximum temperature feeded --- "+t.toString());

            t = concat(forwindspeed);
            classt.setForwindspeed(t);
            it =forwindspeed.indexOf(" ");
            forwindspeed=forwindspeed.substring(it+1);
            Log.i(TAG,"wind speed feeded --- "+t.toString());

            t = concat(foricon);
            classt.setForicon(t);
            it =foricon.indexOf(" ");
            foricon=foricon.substring(it+1);
            Log.i(TAG,"icon feeded --- "+t.toString());

            t = concat(fordesc);
            classt.setFordesc(t);
            it =fordesc.indexOf(" ");
            fordesc=fordesc.substring(it+1);
            Log.i(TAG,"des feeded --- "+t.toString());

            t = concat(forecasthumidity);
            classt.setForecasthumidity(t);
            it =forecasthumidity.indexOf(" ");
            forecasthumidity=forecasthumidity.substring(it+1);
            Log.i(TAG,"average humadity feeded --- "+t.toString());

            Forcastclass.add(classt);

        }


        recyclerView = (RecyclerView) findViewById(R.id.recyclerlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleradapter =new Recycleradapter(this,Forcastclass);
        recyclerView.setAdapter(recycleradapter);

    }


    public String concat(String temp)
    {

        int t = temp.indexOf(" ");
        return temp.substring(0,t);

    }

    public String finalstring(String temp)
    {

        int t = temp.indexOf(" ");
        return temp.substring(0,t);

    }
}
