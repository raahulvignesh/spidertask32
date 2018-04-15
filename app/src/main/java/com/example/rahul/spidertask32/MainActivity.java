package com.example.rahul.spidertask32;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.DownloadManager;
import android.app.ProgressDialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter arrayAdapter;
    ImageView image;
    private static final String TAG="MainaActivity";
    RequestQueue requestQueue;
    RequestQueue requestQueue2;
    CurrentWeather currentweather;
    ProgressDialog progress;
    String finalURL;
    String finalURL2;
    Button button;
    String url_city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView button3 = (TextView) findViewById(R.id.details);

        final EditText textView = (EditText) findViewById(R.id.autotext);


        List<Citydetails> citydetailses = new ArrayList<Citydetails>();
        citydetailses= citylist();

        List<Citydetails2> citydetails2 = new ArrayList<Citydetails2>();
        citydetails2= citylist2();
        ArrayList<String> tempname = new ArrayList<String>();
        for(int i=0;i<citydetailses.size();i++)
            tempname.add(citydetailses.get(i).getName());
        for(int i=0;i<citydetails2.size();i++)
            tempname.add(citydetails2.get(i).name);
        Log.i(TAG,"Created array with size" +String.valueOf(tempname.size()));

        arrayAdapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,tempname);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autotext);
        autoCompleteTextView.setAdapter(arrayAdapter);





        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               try {

                   Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                   intent.putExtra("City", currentweather.location.name);
                   Log.i(TAG, "city name passed " + currentweather.location.name.toString());

                   intent.putExtra("mini", currentweather.current.condition.text);
                   intent.putExtra("icon", currentweather.current.condition.icon);
                   intent.putExtra("temp", currentweather.current.temp_c);
                   Log.i(TAG, " Temperature loaded " + currentweather.current.temp_c);
                   intent.putExtra("pressure", currentweather.current.pressure_in);
                   intent.putExtra("humidity", currentweather.current.humidity);
                   intent.putExtra("windspeed", currentweather.current.wind_kph);
                   intent.putExtra("winddirection", currentweather.current.wind_dir);


                   StringBuffer date = new StringBuffer();
                   for (int i = 0; i < 5; i++)
                       date.append(currentweather.forecast.forecastday.get(i).date + " ");
                   Log.i(TAG, date.toString());
                   StringBuffer maxtemp = new StringBuffer();
                   for (int i = 0; i < 5; i++)
                       maxtemp.append(String.valueOf((int) Float.parseFloat(currentweather.forecast.forecastday.get(i).day.maxtemp_c)) + " ");
                   Log.i(TAG, maxtemp.toString());

                   StringBuffer avgtemp = new StringBuffer();
                   for (int i = 0; i < 5; i++)
                       avgtemp.append(String.valueOf((int) Float.parseFloat(currentweather.forecast.forecastday.get(i).day.avgtemp_c)) + " ");
                   Log.i(TAG, avgtemp.toString());
                   StringBuffer mintemp = new StringBuffer();
                   for (int i = 0; i < 5; i++)
                       mintemp.append(String.valueOf((int) Float.parseFloat(currentweather.forecast.forecastday.get(i).day.mintemp_c)) + " ");
                   Log.i(TAG, mintemp.toString());
                   StringBuffer avgwinspeed = new StringBuffer();
                   for (int i = 0; i < 5; i++)
                       avgwinspeed.append(String.valueOf((int) Float.parseFloat(currentweather.forecast.forecastday.get(i).day.mintemp_c)) + " ");
                   Log.i(TAG, avgwinspeed.toString());
                   StringBuffer hum = new StringBuffer();
                   for (int i = 0; i < 5; i++)
                       hum.append(String.valueOf((int) Float.parseFloat(currentweather.forecast.forecastday.get(i).day.avghumidity)) + " ");
                   Log.i(TAG, hum.toString());
                   StringBuffer iconforecast = new StringBuffer();
                   for (int i = 0; i < 5; i++)
                       iconforecast.append("https:" + currentweather.forecast.forecastday.get(i).day.condition.icon + " ");
                   Log.i(TAG, iconforecast.toString());
                   StringBuffer des = new StringBuffer();
                   for (int i = 0; i < 5; i++)
                       des.append(currentweather.forecast.forecastday.get(i).day.condition.text + " ");
                   Log.i(TAG, des.toString());

                   intent.putExtra("formintemp", mintemp.toString());
                   intent.putExtra("forecasthumidity", hum.toString());
                   intent.putExtra("forwindspeed", avgwinspeed.toString());
                   intent.putExtra("foravgtemperature", avgtemp.toString());
                   intent.putExtra("formaxtemp", maxtemp.toString());
                   intent.putExtra("foricon", iconforecast.toString());
                   intent.putExtra("fordesc", des.toString());
                   intent.putExtra("Date", date.toString());

                   startActivity(intent);
                   Log.i(TAG, "intent started");
               }
               catch(Exception e)
               {
                   Toast.makeText(v.getContext(),"Please Search Before You Load",Toast.LENGTH_SHORT).show();
               }


            }
        });

        image =  (ImageView) findViewById(R.id.imagesearch);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url_city = textView.getText().toString();

                finalURL = "http://api.apixu.com/v1/forecast.json?key=a972d354b3294c69934182725170707&q="+url_city+"&days=5";
                Log.i(TAG,finalURL);

                loadingdetails(finalURL);



            }
        });


    }
    public void loadingdetails(String URL_1)
    {
        progress = new ProgressDialog(MainActivity.this);
        progress.setMessage("Fetching Data...");
        progress.show();
        requestQueue = Volley.newRequestQueue(this);
        fetchdetails(URL_1);
    }
    public  List<Citydetails> citylist()
    {

        try {
            InputStream inputStream= getAssets().open("citylist5.json");
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer stringBuffer = new StringBuffer();
            String temp="";

            while ((temp=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(temp+"\n");
            }

            String json = stringBuffer.toString();
            Log.i(TAG,"created json string\\\\    "+json);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();

            List<Citydetails> citydetailses = Arrays.asList(gson.fromJson(json,Citydetails[].class));
            Log.i(TAG,"list created with size "+citydetailses.size());
            return citydetailses;

        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG,e.toString());
            return null;
        }

    }
    public  List<Citydetails2> citylist2()
    {

        try {
            InputStream inputStream= getAssets().open("citylist4.json");
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer stringBuffer = new StringBuffer();
            String temp="";

            while ((temp=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(temp+"\n");
            }

            String json = stringBuffer.toString();
            Log.i(TAG,"created json string\\\\    "+json);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();

            List<Citydetails2> citydetail2 = Arrays.asList(gson.fromJson(json,Citydetails2[].class));
            Log.i(TAG,"list created with size "+citydetail2.size());
            return citydetail2;

        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG,e.toString());
            return null;
        }

    }




    public void fetchdetails(String URL) {

        StringRequest request = new StringRequest(Request.Method.GET,URL,onloaded,onerror);
        requestQueue.add(request);

    }

    private final Response.Listener<String> onloaded = new Response.Listener<String>()
    {

        @Override
        public void onResponse(String response) {

            Log.i(TAG,response);
            try {
                GsonBuilder gsonbuilder = new GsonBuilder();
                Gson gson = gsonbuilder.create();

                currentweather = gson.fromJson(response, CurrentWeather.class);
                String temp = currentweather.location.name;
                Log.i(TAG,"Current weather class loaded "+temp);
                StringBuffer stringBuffer = new StringBuffer();



                progress.dismiss();
            }
            catch(Exception e)
            {
                Log.e(TAG,e.toString());
            }






        }
    };
    private  final Response.ErrorListener onerror = new Response.ErrorListener(){

        @Override
        public void onErrorResponse(VolleyError error) {

            progress.dismiss();
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setMessage("Error Fetching The Data... Check The Connectivity And The City Name").setCancelable(false);
            alert.setPositiveButton("Search again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    loadingdetails(finalURL);
                }
            }).setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    dialog.dismiss();
                }
            });

           AlertDialog alertDialog = alert.create();
            alert.setTitle("Error");
            alertDialog.show();

        }

    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setMessage("Doy you Want To Exit The Application?").setCancelable(false);
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = alert.create();
            alert.setTitle("EXIT");
            alertDialog.show();

        }





        return super.onOptionsItemSelected(item);
    }
}
