package com.example.tiku1demo2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.TqInfor;

import java.util.List;

public class TqAdapter extends ArrayAdapter<TqInfor> {
    public TqAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(getContext()).inflate(R.layout.tq_item,null);
        TextView date=convertView.findViewById(R.id.date);
        ImageView image_weather=convertView.findViewById(R.id.image_weather);
        TextView weather=convertView.findViewById(R.id.weather);
        TextView wd=convertView.findViewById(R.id.wd);
        LinearLayout layout=convertView.findViewById(R.id.layout);
       TqInfor infor= getItem(position);
       date.setText(infor.getDate());
       weather.setText(infor.getWeather());
       wd.setText(infor.getWd());
       switch (infor.getWeather()){
           case "晴":
               image_weather.setImageResource(R.drawable.qing);
               layout.setBackgroundColor(Color.parseColor("#91D2F0"));
               break;
           case "阴":
               image_weather.setImageResource(R.drawable.yintian);
               layout.setBackgroundColor(Color.parseColor("#BBDDEC"));
               break;
       }

    return convertView;
    }
}
