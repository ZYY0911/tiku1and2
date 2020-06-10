package com.example.tiku1demo2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.Dzbc;

import java.util.List;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class DzbcAdapter extends ArrayAdapter<Dzbc> {

    private int mLayout;

    public DzbcAdapter(@NonNull Context context, int resource, @NonNull List<Dzbc> objects) {
        super(context, resource, objects);
        mLayout=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(getContext()).inflate(mLayout,parent,false);
        Dzbc dzbc=getItem(position);
        TextView hx=view.findViewById(R.id.dzbc_hx);
        TextView xl=view.findViewById(R.id.dzbc_lx);
        TextView pj=view.findViewById(R.id.dzbc_pjlc);
        TextView sj=view.findViewById(R.id.dzbc_sj);
        TextView sj2=view.findViewById(R.id.dzbc_sj2);
        hx.setText(dzbc.getHx()+"路");
        xl.setText(dzbc.getXl());
        pj.setText("票价：￥"+dzbc.getPj()+".0 里程："+dzbc.getLc()+".0km");
        String[] Sjs=dzbc.getSj().split("~");
        sj.setText(Sjs[0]);
        sj2.setText(Sjs[1]);
        return view;
    }
}
