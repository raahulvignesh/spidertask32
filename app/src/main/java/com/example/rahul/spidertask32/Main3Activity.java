package com.example.rahul.spidertask32;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG ="Main3Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.imageicon) ;
        ImageView imageView2 = (ImageView) findViewById(R.id.imageViewlarge) ;
        Log.i(TAG,"image view set");



        final Bundle bundle =  getIntent().getExtras();
        String icon = bundle.getString("icon");

        Picasso.with(this).load("https:"+icon).resize(140,140).into(imageView);
        Picasso.with(this).load("https:"+icon).resize(200,200).into(imageView2);
        Log.i(TAG,"image loaded into image view");
        final String city = bundle.getString("City");
        Log.i(TAG,"City loaded "+city);
        final String des = bundle.getString("");
        String mini = bundle.getString("mini");
        String temp = bundle.getString("temp");
        Log.i(TAG,"temp loaded "+temp);
        String windspeed = bundle.getString("windspeed");
        Log.i(TAG,"windspeed loaded "+windspeed);
        String winddirection = bundle.getString("winddirection");
        Log.i(TAG,"winddirection loaded "+winddirection);
        String pressure = bundle.getString("pressure");
        String humidity = bundle.getString("humidity");
        Log.i(TAG,"humidity loaded "+humidity);
          final String formintemp =bundle.getString("formintemp");
        final String forecasthumidity=bundle.getString("forecasthumidity");
        final String forwindspeed=bundle.getString("forwindspeed");
        final String foravgtemperature=bundle.getString("foravgtemperature");
        final String formaxtemp=bundle.getString("formaxtemp");
        final String foricon = bundle.getString("foricon");
        final String fordesc = bundle.getString("fordesc");
        final String Date = bundle.getString("Date");


        Log.i(TAG,"forecast received");

         char ch = (char) 0x00B0;

        TextView tempmaintxt = (TextView) findViewById(R.id.maintemperature);
        tempmaintxt.setText(String.valueOf((int)Math.floor(Double.parseDouble(temp)))+ch);
        TextView citytxt = (TextView) findViewById(R.id.city);
        citytxt.setText(city.toString());
        TextView sidemini = (TextView) findViewById(R.id.textView4);
        sidemini.setText(mini);
        TextView minitext = (TextView) findViewById(R.id.textView5);
        minitext.setText(mini);
        TextView pressuretxt = (TextView) findViewById(R.id.pressuretext);
        pressuretxt.setText(String.valueOf(Math.floor(Double.parseDouble(pressure))));
        TextView humaditytxt = (TextView) findViewById(R.id.humiditytext);
        humaditytxt.setText(String.valueOf(Math.floor(Double.parseDouble(humidity))));
        TextView predirtxt = (TextView) findViewById(R.id.winddirection2);
        predirtxt.setText(winddirection);
        TextView windspeed2 = (TextView) findViewById(R.id.windspeed2);
        windspeed2.setText(String.valueOf(Math.floor(Double.parseDouble(windspeed))));


        Button b =(Button) findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtra("city",city);
                intent.putExtra("formintemp",formintemp);
                intent.putExtra("forecasthumidity",forecasthumidity);
                intent.putExtra("forwindspeed",forwindspeed);
                intent.putExtra("foravgtemperature",foravgtemperature);
                intent.putExtra("formaxtemp",formaxtemp);
                intent.putExtra("foricon",foricon);
                intent.putExtra("fordesc",fordesc);
                intent.putExtra("Date",Date);
                startActivity(intent);
            }
        });



    }

}
