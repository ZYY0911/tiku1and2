package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.HJZB_GridView;
import com.example.tiku1demo2.bean.HJZB;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;
import com.example.tiku1demo2.util.SimpDate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Z_HJZBActivity extends AppCompatActivity {
    private List<HJZB> hjzbs, yz,hjzbsAll;
    private JSONObject json;
    private GridView hj_gird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjzb_layout);
        initView();
        setVolley_1();
        setOnClick();
    }

    private void setOnClick() {
        hj_gird.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Z_HJZBActivity.this,Z_SSXSActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });
    }

    private void setVolley_1() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_threshold")
                .setJsonObject("UserName", "user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (jsonObject.has("RESULT")) {
                            try {
                                yz.clear();
                                if (jsonObject.getString("RESULT").equals("S")) {
                                    JSONArray jsonArray = new JSONArray(jsonObject.getString("ROWS_DETAIL"));
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                                    yz.add(new HJZB(jsonObject1.getInt("temperature")
                                            , jsonObject1.getInt("humidity")
                                            , jsonObject1.getInt("illumination")
                                            , jsonObject1.getInt("co2")
                                            , jsonObject1.getInt("pm25")
                                            , jsonObject1.getInt("path"),""));
                                    Log.i("aaa","11111");

                                    setVolley();
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

    private void setVolley() {
        final VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_all_sense")
                .setLoop(true)
                .setTime(3000)
                .setJsonObject("UserName", "user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (jsonObject.has("RESULT")) {
                            try {
                                if (jsonObject.getString("RESULT").equals("S")) {
                                    Log.i("aaa","2222");
                                    json = jsonObject;
                                    hjzbs.clear();
                                    VolleyTo volleyTo1 = new VolleyTo();
                                    volleyTo1.setUrl("get_road_status")
                                            .setJsonObject("UserName", "user1")
                                            .setJsonObject("RoadId", "1")
                                            .setVolleyLo(new VolleyLo() {
                                                @Override
                                                public void onResponse(JSONObject jsonObject) {
                                                    if (jsonObject.has("RESULT")) {
                                                        try {
                                                            if (jsonObject.getString("RESULT").equals("S")) {
                                                                Log.i("aaa","3333");
                                                                JSONArray jsonArray = new JSONArray(jsonObject.getString("ROWS_DETAIL"));
                                                                JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                                                                hjzbs.add(new HJZB(json.getInt("temperature")
                                                                        , json.getInt("humidity")
                                                                        , json.getInt("illumination")
                                                                        , json.getInt("co2")
                                                                        , json.getInt("pm25")
                                                                        , jsonObject1.getInt("state"),""));
                                                                hjzbsAll.add(new HJZB(json.getInt("temperature")
                                                                        , json.getInt("humidity")
                                                                        , json.getInt("illumination")
                                                                        , json.getInt("co2")
                                                                        , json.getInt("pm25")
                                                                        , jsonObject1.getInt("state"), SimpDate.setData(new Date(System.currentTimeMillis()),"mm:ss")));
                                                                AppClient.setHjzbs(hjzbsAll);
                                                                List<HJZB> hjzbList = AppClient.getHjzbs();
                                                                if (hjzbList.size()==21){
                                                                    hjzbList.remove(0);
                                                                    AppClient.setHjzbs(hjzbList);

                                                                }
                                                            }
                                                            Log.i("aaa","4444");
                                                            setGridView();
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

    private void setGridView() {
        hj_gird.setAdapter(new HJZB_GridView(this,hjzbs,yz));
    }

    private void initView() {
        TextView content = findViewById(R.id.content);
        content.setText("环境指标");
        ImageView change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hjzbsAll.clear();
                AppClient.setHjzbs(hjzbsAll);
                finish();
            }
        });
        hjzbs = new ArrayList<>();
        yz = new ArrayList<>();
        hj_gird = findViewById(R.id.hj_gird);
        hjzbsAll = new ArrayList<>();
    }
}
