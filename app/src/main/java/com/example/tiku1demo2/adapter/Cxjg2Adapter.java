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
import com.example.tiku1demo2.bean.Cxjg2;

import java.util.List;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class Cxjg2Adapter extends ArrayAdapter<Cxjg2> {

    private int mLayout;

    public interface SetData{
        void setdata();
    }

    private SetData data;

    public void setData(SetData data) {
        this.data = data;
    }

    public Cxjg2Adapter(@NonNull Context context, int resource, @NonNull List<Cxjg2> objects) {
        super(context, resource, objects);
        mLayout=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cxjg2 cxjg2=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(mLayout,parent,false);
        TextView Sj=view.findViewById(R.id.cxjg2_sj);
        TextView Nr=view.findViewById(R.id.cxjg2_nr);
        TextView Kf=view.findViewById(R.id.cxjg2_kf);
        TextView Fk=view.findViewById(R.id.cxjg2_fk);
        TextView road=view.findViewById(R.id.cxjg2_road);
        LinearLayout Layout=view.findViewById(R.id.cxjg2_layout);
        Sj.setText(cxjg2.getSj());
        Nr.setText(cxjg2.getNr());
        Kf.setText(cxjg2.getKf());
        Fk.setText(cxjg2.getFk());
        road.setText(cxjg2.getLk());
        Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setdata();
            }
        });
        return view;
    }
}
