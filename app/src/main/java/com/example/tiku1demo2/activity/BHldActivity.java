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

import com.android.volley.VolleyError;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.HldAdapter;
import com.example.tiku1demo2.bean.HldInfor;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BHldActivity extends AppCompatActivity {
    private ListView ll;
    private Spinner spinner;
    private String result="路口升序";
    private List<HldInfor> mlist;
    private HldAdapter adapter;
    private Button chaxun;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_hldgl);
        initview();
        TextView content=findViewById(R.id.content);
        content.setText("红绿灯管理");
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setListener();
        setVolley("1");
        setVolley("2");
        setVolley("3");
        setVolley("4");
        setVolley("5");


    }

    private void initData() {
        adapter=new HldAdapter(this,result,mlist);
        ll.setAdapter(adapter);
    }

    private void setVolley(String id) {
        VolleyTo volleyTo=new VolleyTo();
        volleyTo.setUrl("get_traffic_light").setJsonObject("UserName","user1").setJsonObject("number",id).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                  JSONArray array=new JSONArray(jsonObject.getString("ROWS_DETAIL"));
                  JSONObject jsonObject1=array.getJSONObject(0);
                    int id=jsonObject1.getInt("number");
                    int red=jsonObject1.getInt("red");
                    int yellow=jsonObject1.getInt("yellow");
                    int green=jsonObject1.getInt("green");
                    mlist.add(new HldInfor(id,red,green,yellow));
                    initData();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void setListener() {
        chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String content=adapterView.getItemAtPosition(i).toString();
                switch (adapterView.getId()){
                    case R.id.select :
                        result=content;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initview() {
        spinner=findViewById(R.id.select);
        ll=findViewById(R.id.lv);
        mlist=new ArrayList<>();
        chaxun=findViewById(R.id.chaxun);

    }
}
