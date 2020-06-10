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
import com.example.tiku1demo2.bean.Dzbcdd;

import java.util.List;

/**
 * Created by Administrator on 2019/9/15 0015.
 */

public class DzbcddAdapter extends ArrayAdapter<Dzbcdd> {

    private int mLayout;

    public DzbcddAdapter(@NonNull Context context, int resource, @NonNull List<Dzbcdd> objects) {
        super(context, resource, objects);
        mLayout=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(getContext()).inflate(mLayout,parent,false);
        Dzbcdd dzbcdd=getItem(position);
        TextView lx=view.findViewById(R.id.dd_xl);
        TextView xm=view.findViewById(R.id.dd_xm);
        TextView sj=view.findViewById(R.id.dd_sj);
        TextView sc=view.findViewById(R.id.dd_sc);
        TextView rq=view.findViewById(R.id.dd_rq);
        lx.setText(dzbcdd.getmXl());
        xm.setText(dzbcdd.getmXm());
        sj.setText(dzbcdd.getmSj());
        sc.setText(dzbcdd.getmSc());
        rq.setText(dzbcdd.getmRq());
        return view;
    }
}
