package com.example.tiku1demo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.WdzhInfor;
import com.example.tiku1demo2.bean.ZdglInfor;

import java.util.ArrayList;
import java.util.List;

public class ZdglAdapter2 extends BaseAdapter {
    private Context context;
    private List<ZdglInfor> mlist;

    public ZdglAdapter2(Context context, String result, List<ZdglInfor> mlist) {
        this.context = context;

        if (result.equals("时间升序")){
            this.mlist = mlist;
        }else {
           this.mlist=new ArrayList<>();
            for (int i=mlist.size()-1;i>=0;i--){
                this.mlist.add(mlist.get(i));
            }
        }
    }

    @Override
    public int getCount() {
        if (mlist.size()==0){
            return 1;
        }
        return mlist.size();

    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
     if (mlist.size()==0){
         View view1=LayoutInflater.from(context).inflate(R.layout.infornull,null);
         return view1;
     }
        view= LayoutInflater.from(context).inflate(R.layout.zdgl_item2,null);
        ZdglInfor infor=mlist.get(i);
        TextView xh=view.findViewById(R.id.xuhao_z);
        TextView carnumber=view.findViewById(R.id.chehao_z);
        TextView jine=view.findViewById(R.id.jine_z);
        TextView caozuo=view.findViewById(R.id.caozuo_z);
        TextView time=view.findViewById(R.id.shijian_z);

        xh.setText(i+1+"");
        carnumber.setText(infor.getCarnumber());
        jine.setText(infor.getJine());
        caozuo.setText(infor.getName());
        time.setText(infor.getTime());

        return view;
    }
}