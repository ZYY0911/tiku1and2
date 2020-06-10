package com.example.tiku1demo2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.tiku1demo2.Interface.SetData;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.ZhglInfor;

import java.util.List;

public class ZhglAdapter extends ArrayAdapter<ZhglInfor> {
    private SetData data;

    public void setData(SetData data) {
        this.data = data;
    }

    public ZhglAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.b_zhgl_item,null);
        TextView number=convertView.findViewById(R.id.number);
        ImageView icon=convertView.findViewById(R.id.icon);
        TextView chepai=convertView.findViewById(R.id.chepai);
        TextView name=convertView.findViewById(R.id.name);
        TextView yue=convertView.findViewById(R.id.money);
        final CheckBox check=convertView.findViewById(R.id.check);
        Button chongzhi=convertView.findViewById(R.id.chongzhi);
        LinearLayout item=convertView.findViewById(R.id.list_item);



      ZhglInfor infor=getItem(position);

        if (infor.getMin()>Integer.parseInt(infor.getYue())){
            item.setBackgroundColor(Color.parseColor("#ffcc00"));
        }

      number.setText(infor.getId()+"");
      chepai.setText(infor.getCarnumber());
      name.setText("车主："+infor.getName());
      yue.setText("余额："+infor.getYue()+"元");
      check.setChecked(infor.isIscheck());
      switch (infor.getPinpai()){
          case "奔驰" :
              icon.setImageResource(R.drawable.benchi);
              break;
          case "宝马" :
              icon.setImageResource(R.drawable.bentian);
              break;
          case "中华" :
              icon.setImageResource(R.drawable.zhonghua);
              break;
          case "奥迪" :
              icon.setImageResource(R.drawable.mazhida);
              break;
      }
      check.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
                if (check.isChecked()){
                    data.setdata(position,true,1);
                }else {
                    data.setdata(position,false,1);
                }
          }
      });
      chongzhi.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              data.setdata(position,true,2);
          }
      });

        return convertView;
    }
}
