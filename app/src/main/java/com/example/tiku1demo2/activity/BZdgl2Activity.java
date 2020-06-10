package com.example.tiku1demo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.ZdglAdapter;
import com.example.tiku1demo2.adapter.ZdglAdapter2;
import com.example.tiku1demo2.bean.WdzhInfor;
import com.example.tiku1demo2.bean.ZdglInfor;

import java.util.List;

public class BZdgl2Activity extends AppCompatActivity {
    private Spinner select;
    private Button chaxun;
    private List<ZdglInfor> mlist;
    private String result="时间降序";
    private ListView lv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zdgl2);
        initView();
        initData();
    }

    private void initData() {
        ZdglAdapter2 adapter=new ZdglAdapter2(this,result,mlist);
        lv.setAdapter(adapter);
    }

    private void initView() {
        TextView content=findViewById(R.id.content);
        content.setText("账单管理");
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        select=findViewById(R.id.select);
        chaxun=findViewById(R.id.chaxun);
        mlist= AppClient.getList();
        lv=findViewById(R.id.lv);
        select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              result=adapterView.getItemAtPosition(i).toString();
              switch (adapterView.getId()){
                  case R.id.select:
                      break;
              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });

    }
}
