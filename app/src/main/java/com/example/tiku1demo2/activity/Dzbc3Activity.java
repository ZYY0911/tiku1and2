package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.Dzbc3Adapter;
import com.example.tiku1demo2.bean.Dzbc3;
import com.example.tiku1demo2.bean.Pxx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class Dzbc3Activity extends BaseActivity {

    private GridView mGridView;
    private List<Dzbc3> mList;
    private Dzbc3Adapter mAdapter;
    private TextView Rqtv;
    private Button mOk;
    private List<Pxx> RqList=new ArrayList<>();
    private String[] yl=new String[]{"18","19","20","21","22","23","24","25","26","27","28","29","30","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"};
    private String[] yi=new String[]{"十二","十三","十四","十五","劳动","十七","十八","青年","廿十","廿一","廿二","廿三","廿四","廿五","廿六","护士","廿八","廿九","四月","初一","初二","初三","初四","初五","初六","初七","初八",
            "初九","初十","十一","十二","十三","十四","十五","十六","十七","十八","十九","廿十","廿一","廿二","廿三","廿四"};
    private int[] bg={1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1};
    private int[] bg2={1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dzbc3_layout);
        initView();
        initData();
        initLister();
        addActivity(this);
    }

    private void initLister() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lister(i);
            }
        });
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dzbc3Activity.this,Dzbc4Activity.class);
                intent.putExtra("rq",Rqtv.getText().toString().trim());
                intent.putExtra("lx",getIntent().getStringExtra("lx"));
                startActivity(intent);
            }
        });

    }

    private void lister(int i){
        if (i<3||i>44){
            return;
        }
        Dzbc3 dzbc3=mList.get(i);
        int a= dzbc3.getBa();
        if (a!=2){
            dzbc3.setBa(2);
            if (i<16){
                RqList.add(new Pxx(i,"2019-9-"+dzbc3.getYal()));
            }else {
                RqList.add(new Pxx(i,"2019-10-"+dzbc3.getYal()));
            }
        }else {
            dzbc3.setBa(bg2[i-3]);
            if (i<16){
                for (int y=0;y<RqList.size();y++){
                    Pxx yl=RqList.get(y);
                    if (yl.getNr().equals("2019-9-"+dzbc3.getYal())){
                        RqList.remove(y);
                    }
                }
            }else {
                for (int y=0;y<RqList.size();y++){
                    Pxx yl=RqList.get(y);
                    if (yl.getNr().equals("2019-10-"+dzbc3.getYal())){
                        RqList.remove(y);
                    }
                }
            }
        }
        String rq="";
        Collections.sort(RqList,new Px());
        for (int y=0;y<RqList.size();y++){
            if (rq.equals("")){
                rq+=RqList.get(y).getNr();
            }else {
                rq+=","+RqList.get(y).getNr();
            }
        }
        Rqtv.setText(rq);
        mList.set(i,dzbc3);
        mAdapter.notifyDataSetChanged();
    }

    private void initData() {
        mList=new ArrayList<>();
        for (int i=0;i<3;i++){
            mList.add(new Dzbc3("","",0));
        }
        for (int i=0;i<yl.length;i++){
            mList.add(new Dzbc3(yl[i],yi[i],bg[i]));
        }
        for (int i=0;i<4;i++){
            mList.add(new Dzbc3("","",0));
        }
        mAdapter=new Dzbc3Adapter(this,mList);
        mGridView.setAdapter(mAdapter);
    }

    private void initView() {
        mGridView=findViewById(R.id.dz3_grid);
        Rqtv=findViewById(R.id.dz3_tv);
        mOk=findViewById(R.id.dz3_ok);
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private class Px implements Comparator<Pxx> {
        @Override
        public int compare(Pxx pxx, Pxx t1) {
            return pxx.getIndex()-t1.getIndex();
        }
    }
}
