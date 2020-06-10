package com.example.tiku1demo2.adapter;

import android.content.Context;
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
import com.example.tiku1demo2.bean.Cxjg1;

import java.util.List;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class CxjgAdapter extends ArrayAdapter<Cxjg1> {

    private int mLayout;
    public interface SetData{
        void setdata(int lx, int index);
    }

    private SetData data;

    public void setData(SetData data) {
        this.data = data;
    }

    public CxjgAdapter(@NonNull Context context, int resource, @NonNull List<Cxjg1> objects) {
        super(context, resource, objects);
        mLayout=resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cxjg1 cxjg1=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(mLayout,parent,false);
        TextView Cp=view.findViewById(R.id.cxjg_cp);
        TextView Wcl=view.findViewById(R.id.cxjg_wcl);
        TextView Kf=view.findViewById(R.id.cxjg_kf);
        TextView Fk=view.findViewById(R.id.cxjg_fk);
        ImageView Jh=view.findViewById(R.id.cxjg_jh);
        LinearLayout layout=view.findViewById(R.id.cxjg_layout);
        Cp.setText(cxjg1.getCp());
        Wcl.setText(cxjg1.getWcl());
        Fk.setText(cxjg1.getFk());
        Kf.setText(cxjg1.getKf());
        Jh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setdata(1,position);
            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setdata(2,position);
            }
        });
        return view;
    }
}
