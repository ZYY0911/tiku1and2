package com.example.tiku1demo2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.HJZB;

import java.util.List;

/**
 * Create by 张瀛煜 on 2019-09-18
 */
public class HJZB_GridView extends BaseAdapter {
    Context context; List<HJZB> hjzbs;List<HJZB>yz;
    private String name[] = {"温度","湿度","光照","CO2","PM2.5","道路状态"};
    public HJZB_GridView(Context context, List<HJZB> hjzbs,List<HJZB>yz){
        this.context = context;
        this.hjzbs = hjzbs;
        this.yz = yz;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       HJZB hjzb = hjzbs.get(0);
       HJZB yzs = yz.get(0);
        View view = LayoutInflater.from(context).inflate(R.layout.hjzb_gridview,parent,false);
        RelativeLayout bg_colors = view.findViewById(R.id.bg_colors);
        TextView title = view.findViewById(R.id.title);
        TextView message = view.findViewById(R.id.message);
        switch (position){
            case 0:
                if (hjzb.getTemperature()>yzs.getTemperature()){
                    bg_colors.setBackgroundColor(Color.RED);
                }else {
                    bg_colors.setBackgroundColor(Color.GREEN);
                }
                title.setText(name[position]);
                message.setText(hjzb.getTemperature()+"");
                break;
            case 1:
                if (hjzb.getHumidity()>yzs.getHumidity()){
                    bg_colors.setBackgroundColor(Color.RED);
                }else {
                    bg_colors.setBackgroundColor(Color.GREEN);
                }
                title.setText(name[position]);
                message.setText(hjzb.getHumidity()+"");
                break;
            case 2:
                if (hjzb.getIllumination()>yzs.getIllumination()){
                    bg_colors.setBackgroundColor(Color.RED);
                }else {
                    bg_colors.setBackgroundColor(Color.GREEN);
                }
                title.setText(name[position]);
                message.setText(hjzb.getIllumination()+"");
                break;
            case 3:
                if (hjzb.getCo2()>yzs.getCo2()){
                    bg_colors.setBackgroundColor(Color.RED);
                }else {
                    bg_colors.setBackgroundColor(Color.GREEN);
                }
                title.setText(name[position]);
                message.setText(hjzb.getCo2()+"");
                break;
            case 4:
                if (hjzb.getPm25()>yzs.getPm25()){
                    bg_colors.setBackgroundColor(Color.RED);
                }else {
                    bg_colors.setBackgroundColor(Color.GREEN);
                }
                title.setText(name[position]);
                message.setText(hjzb.getPm25()+"");
                break;
            case 5:
                if (hjzb.getDlzt()>yzs.getDlzt()){
                    bg_colors.setBackgroundColor(Color.RED);
                }else {
                    bg_colors.setBackgroundColor(Color.GREEN);
                }
                title.setText(name[position]);
                message.setText(hjzb.getDlzt()+"");
                break;
        }
        return view;
    }
}
