package com.example.tiku1demo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.HldInfor;

import java.util.List;

public class HldAdapter extends BaseAdapter {

    private List<HldInfor> mlist;
    private Context context;
    public HldAdapter(Context context, String result, List<HldInfor> mlist) {
        this.mlist=mlist;
        this.context=context;
        if (result.equals("路口升序")){
            for (int i=0;i<mlist.size()-1;i++){
                for (int j=0;j<mlist.size()-i-1;j++){
                    HldInfor inforq= mlist.get(j);
                    HldInfor inforh= mlist.get(j+1);
                    if (inforq.getId()>inforh.getId()){
                        mlist.set(j,inforh);
                        mlist.set(j+1,inforq);

                    }
                }
            }
        }else if (result.equals("路口降序")){
            for (int i=0;i<mlist.size()-1;i++){
                for (int j=0;j<mlist.size()-i-1;j++){
                    HldInfor inforq= mlist.get(j);
                    HldInfor inforh= mlist.get(j+1);
                    if (inforq.getId()<inforh.getId()){
                        mlist.set(j,inforh);
                        mlist.set(j+1,inforq);

                    }
                }
            }
        }else if (result.equals("红灯升序")){
            for (int i=0;i<mlist.size()-1;i++){
                for (int j=0;j<mlist.size()-i-1;j++){
                    HldInfor inforq= mlist.get(j);
                    HldInfor inforh= mlist.get(j+1);
                    if (inforq.getRed()>inforh.getRed()){
                        mlist.set(j,inforh);
                        mlist.set(j+1,inforq);

                    }
                }
            }
        }else if (result.equals("红灯降序")){
            for (int i=0;i<mlist.size()-1;i++){
                for (int j=0;j<mlist.size()-i-1;j++){
                    HldInfor inforq= mlist.get(j);
                    HldInfor inforh= mlist.get(j+1);
                    if (inforq.getRed()<inforh.getRed()){
                        mlist.set(j,inforh);
                        mlist.set(j+1,inforq);

                    }
                }
            }
        }else if (result.equals("黄灯升序")){
            for (int i=0;i<mlist.size()-1;i++){
                for (int j=0;j<mlist.size()-i-1;j++){
                    HldInfor inforq= mlist.get(j);
                    HldInfor inforh= mlist.get(j+1);
                    if (inforq.getYellow()>inforh.getYellow()){
                        mlist.set(j,inforh);
                        mlist.set(j+1,inforq);

                    }
                }
            }
        }else if (result.equals("黄灯降序")){
            for (int i=0;i<mlist.size()-1;i++){
                for (int j=0;j<mlist.size()-i-1;j++){
                    HldInfor inforq= mlist.get(j);
                    HldInfor inforh= mlist.get(j+1);
                    if (inforq.getYellow()<inforh.getYellow()){
                        mlist.set(j,inforh);
                        mlist.set(j+1,inforq);

                    }
                }
            }
        }else if (result.equals("绿灯升序")){
            for (int i=0;i<mlist.size()-1;i++){
                for (int j=0;j<mlist.size()-i-1;j++){
                    HldInfor inforq= mlist.get(j);
                    HldInfor inforh= mlist.get(j+1);
                    if (inforq.getGreen()>inforh.getGreen()){
                        mlist.set(j,inforh);
                        mlist.set(j+1,inforq);

                    }
                }
            }
        }else if (result.equals("绿灯降序")){
            for (int i=0;i<mlist.size()-1;i++){
                for (int j=0;j<mlist.size()-i-1;j++){
                    HldInfor inforq= mlist.get(j);
                    HldInfor inforh= mlist.get(j+1);
                    if (inforq.getGreen()<inforh.getGreen()){
                        mlist.set(j,inforh);
                        mlist.set(j+1,inforq);

                    }
                }
            }
        }
    }

    @Override
    public int getCount() {
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
        View view1= LayoutInflater.from(context).inflate(R.layout.b_hldtem,null);
        TextView road=view1.findViewById(R.id.tv_road);
        TextView red=view1.findViewById(R.id.tv_red);
        TextView yellow=view1.findViewById(R.id.tv_yellow);
        TextView green=view1.findViewById(R.id.tv_green);
        HldInfor infor=mlist.get(i);
        road.setText(infor.getId()+"");
        red.setText(infor.getRed()+"");
        green.setText(infor.getGreen()+"");
        yellow.setText(infor.getYellow()+"");
        return view1;
    }
}
