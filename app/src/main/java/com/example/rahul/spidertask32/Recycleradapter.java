package com.example.rahul.spidertask32;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rahul on 08-07-2017.
 */

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.ViewHolder> {

    Context context;
    List<recyclerclass> recyclerclassList;
    private static String TAG ="Recycleradapter";

    public Recycleradapter(Context context, List<recyclerclass> recyclerclassList) {
        this.context = context;
        this.recyclerclassList=recyclerclassList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

          recyclerclass forecastday=recyclerclassList.get(position);


        String url_city;
        String formintemp;
        String forecasthumidity;
        String forwindspeed;
        String foravgtemperature;
        String formaxtemp;
        String foricon;
        String fordesc;

        char ch = (char) 0x00B0;
        Picasso.with(context).load(forecastday.foricon).resize(100,100).into(holder.imageView);

        Log.i(TAG,"image into recyclerview");
        holder.datetxt.setText(forecastday.date);
        Log.i(TAG,"Date into recyclerview");
        holder.maintemptxt.setText(forecastday.foravgtemperature+ch);
        Log.i(TAG,"main temp into recyclerview");
        holder.humadityfortxt.setText(forecastday.forecasthumidity);
        Log.i(TAG,"humadity into recyclerview");
        holder.maxtemptxt.setText(forecastday.formaxtemp+ch);
        Log.i(TAG,"maxtemp into recyclerview");
        holder.mintemptxt.setText(forecastday.formintemp+ch);
        Log.i(TAG,"mintemp into recyclerview");
        holder.windspeed.setText(forecastday.forwindspeed);
        Log.i(TAG,"windspeed into recyclerview");
        holder.descripition.setText(forecastday.fordesc);
        Log.i(TAG,"description into recyclerview");


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView datetxt;
        public TextView maintemptxt;
        public TextView humadityfortxt;
        public TextView maxtemptxt;
        public TextView mintemptxt;
        public TextView windspeed;
        public TextView descripition;
        public ImageView imageView;

        public ViewHolder(View itemView) {

            super(itemView);
            datetxt = (TextView) itemView.findViewById(R.id.Date);
            maintemptxt= (TextView) itemView.findViewById(R.id.maintempcard);
            humadityfortxt = (TextView) itemView.findViewById(R.id.avghumtxt);
            maxtemptxt = (TextView) itemView.findViewById(R.id.maxitemptxtfor);
            mintemptxt = (TextView) itemView.findViewById(R.id.minitemptxtfor);
            windspeed = (TextView) itemView.findViewById(R.id.avgwindspetxt);
            descripition = (TextView) itemView.findViewById(R.id.des1);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewicon1);

        }
    }
}
