package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.Cxjg2Adapter;
import com.example.tiku1demo2.adapter.CxjgAdapter;
import com.example.tiku1demo2.bean.Cxjg1;
import com.example.tiku1demo2.bean.Cxjg2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class CxjgActivity extends AppCompatActivity {

    private ImageView mAdd;
    private ListView mListView;
    private ListView mListView2;
    private List<Cxjg1> CxList;
    private List<Cxjg2> CxList2;
    private List<Cxjg2> mList3;
    private AppClient mApp;
    private CxjgAdapter mAdapter;
    private Cxjg2Adapter mAdapter2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cxjg_layout);
        initView();
        initData();
        initLister();
    }
    private void initLister() {
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CxjgActivity.this,AClwzActivity.class));
                finish();
            }
        });
    }

    private void initData() {
        mApp= (AppClient) getApplication();
        CxList=mApp.getCxList();
        CxList2=mApp.getCxList2();
        mList3=new ArrayList<>();
        setData();
        mAdapter=new CxjgAdapter(this,R.layout.cxjg_item,CxList);
        mAdapter2=new Cxjg2Adapter(this,R.layout.cxjg2_item,mList3);
        mListView.setAdapter(mAdapter);
        mListView2.setAdapter(mAdapter2);
        mAdapter.setData(new CxjgAdapter.SetData() {
            @Override
            public void setdata(int lx, int index) {
                if (lx==1){
                    Cxjg1 cxjg=CxList.get(index);
                    String Cp=cxjg.getCp();
                    for (int i=CxList2.size()-1;i>=0;i--){
                        Cxjg2 cxjg2=CxList2.get(i);
                        if (cxjg2.getCp().equals(Cp)){
                            CxList2.remove(i);
                        }
                    }
                    CxList.remove(index);
                    setData();
                }else {
                    mList3.clear();
                    Cxjg1 cxjg1=CxList.get(index);
                    for (int i=0;i<CxList2.size();i++){
                        Cxjg2 cxjg2=CxList2.get(i);
                        if (cxjg1.getCp().equals(cxjg2.getCp())){
                            mList3.add(cxjg2);
                        }
                    }
                }
                mAdapter.notifyDataSetChanged();
                mAdapter2.notifyDataSetChanged();
            }
        });
        mAdapter2.setData(new Cxjg2Adapter.SetData() {
            @Override
            public void setdata() {
                startActivity(new Intent(CxjgActivity.this,JkActivity.class));
                finish();
            }
        });
    }

    private void initView() {
        mAdd=findViewById(R.id.cxjg_add);
        mListView=findViewById(R.id.cxjg1_list);
        mListView2=findViewById(R.id.cxjg2_list);
        final ImageView fh=findViewById(R.id.change);
        TextView tv=findViewById(R.id.context);
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv.setText("查询结果");
    }
    private void setData(){
        mList3.clear();
        if (CxList.size()>=1){
            Cxjg1 cxjg1=CxList.get(0);
            for (int i=0;i<CxList2.size();i++){
                Cxjg2 cxjg2=CxList2.get(i);
                if (cxjg1.getCp().equals(cxjg2.getCp())){
                    mList3.add(cxjg2);
                }
            }
        }
    }
}
