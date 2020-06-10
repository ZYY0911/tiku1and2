package com.example.tiku1demo2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.Dzbc3;

import java.util.List;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class Dzbc3Adapter extends ArrayAdapter<Dzbc3> {

    private List<Dzbc3> mList;
    private LayoutInflater inflater;

    public Dzbc3Adapter(@NonNull Context context, @NonNull List<Dzbc3> objects) {
        super(context, 0, objects);
        mList=objects;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private class ViewHolder{
        LinearLayout Layout;
        TextView Yal;
        TextView Yil;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public Dzbc3 getItem(int position) {
        return mList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder=null;
        Dzbc3 dzbc3=mList.get(position);
        if (convertView==null){
            convertView=inflater.inflate(R.layout.dz3_item,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.Layout=convertView.findViewById(R.id.dz3_layout);
            viewHolder.Yal=convertView.findViewById(R.id.dz3_yal);
            viewHolder.Yil=convertView.findViewById(R.id.dz3_yil);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        if (dzbc3!=null){
            viewHolder.Yal.setText(dzbc3.getYal());
            viewHolder.Yil.setText(dzbc3.getYil());
            if (dzbc3.getBa()==0){
                viewHolder.Layout.setBackgroundResource(R.drawable.gridjq);
            }else if(dzbc3.getBa()==1){
                viewHolder.Layout.setBackgroundResource(R.drawable.gridzc);
            }else if (dzbc3.getBa()==2){
                viewHolder.Layout.setBackgroundResource(R.drawable.gridxz);
            }
        }
        return convertView;
    }
}
