package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.DzbcAdapter;
import com.example.tiku1demo2.bean.Dzbc;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class ADzbcActivity extends BaseActivity {
    private ListView menu;
    private List<String> list;

    private ListView mListView;
    private List<Dzbc> mList;
    private DzbcAdapter mAdapter;
    private VolleyTo volleyTo;
    private TextView mDd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_dzbc_layout);
        initView();
        setVolley();
        initLister();
        addActivity(this);
        setLeft();
    }
    private void setLeft() {
        list = new ArrayList<>();
        list.add("");
        list.add("我的账户");
        list.add("违章视频");
        list.add("环境指标");
        list.add("阈值设置");
        list.add("出行管理");
        list.add("数据分析");
        list.add("定制班车");
        list.add("天气信息");
        list.add("红绿灯管理");
        list.add("账户管理");
        list.add("车辆违章");
        list.add("路况查询");



        menu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (list.get(position)) {
                    case "环境指标":
                        startActivity(new Intent(ADzbcActivity.this, Z_HJZBActivity.class));
                        break;
                    case "阈值设置":
                        startActivity(new Intent(ADzbcActivity.this, Z_YZSZActivity.class));
                        break;
                    case "违章视频":
                        startActivity(new Intent(ADzbcActivity.this, S_CLWZActivity.class));
                        break;
                    case "定制班车":
                        startActivity(new Intent(ADzbcActivity.this, ADzbcActivity.class));
                        finish();
                        break;
                    case "出行管理":
                        startActivity(new Intent(ADzbcActivity.this, Z_CXGLActivity.class));
                        break;
                    case "我的账户":
                        startActivity(new Intent(ADzbcActivity.this, BWdzhActivity.class));
                        break;
                    case "账户管理":
                        startActivity(new Intent(ADzbcActivity.this, BZhglActivity.class));
                        break;
                    case "红绿灯管理":
                        startActivity(new Intent(ADzbcActivity.this, BHldActivity.class));
                        break;
                    case "车辆违章":
                        startActivity(new Intent(ADzbcActivity.this, AClwzActivity.class));
                        break;
                    case "数据分析":
                        startActivity(new Intent(ADzbcActivity.this, S_SJFXActivity.class));
                        break;
                    case "路况查询":
                        startActivity(new Intent(ADzbcActivity.this, S_LKCXActivity.class));
                        break;
                    case "天气信息":
                        startActivity(new Intent(ADzbcActivity.this, BtqxxActivity.class));
                        break;
                }
            }
        });

    }

    private void initLister() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dzbc dzbc=mList.get(i);
                Intent intent=new Intent(ADzbcActivity.this,Dzbc2Activity.class);
                intent.putExtra("index",i);
                intent.putExtra("xl",dzbc.getXl());
                intent.putExtra("lc",dzbc.getLc());
                intent.putExtra("pj",dzbc.getPj());
                startActivity(intent);
            }
        });
        mDd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ADzbcActivity.this,DzbcddActivity.class));
            }
        });
    }

    private void setVolley() {
        volleyTo=new VolleyTo();
        mList=new ArrayList<>();
        volleyTo.setUrl("get_bus_info").setJsonObject("UserName","user1").setmDialog(this).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.i("aaaaaaaaaaaaaaa","cccccccccc");
                if (jsonObject.has("RESULT")){
                    try {
                        String result=jsonObject.getString("RESULT");
                        if (result.equals("S")){
                            Log.i("aaaaaaaaaaaaaaa","111111");
                            String body=jsonObject.getString("ROWS_DETAIL");
                            JSONArray jsonArray=new JSONArray(body);
                            Log.i("aaaaaaaaaaaaaaa","22222");
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                List<String> zd=new ArrayList<>();
                                JSONArray jsonArray1=new JSONArray(jsonObject1.getString("busline"));
                                Log.i("aaaaaaaaaaaaaaa","33333");
                                for (int j=0;j<jsonArray1.length();j++){
                                    zd.add(jsonArray1.getString(j));
                                }
                                Log.i("aaaaaaaaaaaaaaa","44444");
                                mList.add(new Dzbc(jsonObject1.getString("id"),zd.get(0)+"——"+zd.get(zd.size()-1),jsonObject1.getString("mileage"),jsonObject1.getString("fares"),jsonObject1.getString("time")));
                            }
                            initData();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void initData(){
        mAdapter=new DzbcAdapter(this,R.layout.dzbc_item,mList);
        mListView.setAdapter(mAdapter);
    }

    private void initView() {
        mListView=findViewById(R.id.dzbc_list);
        mDd=findViewById(R.id.dz_dd);
        final DrawerLayout drawer = findViewById(R.id.drawer);
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        menu = findViewById(R.id.menu);
    }
}
