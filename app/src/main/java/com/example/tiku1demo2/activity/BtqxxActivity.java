package com.example.tiku1demo2.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.TqAdapter;
import com.example.tiku1demo2.bean.TqInfor;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BtqxxActivity extends AppCompatActivity {
    private GridView gv;
    private TextView wd_tody,date,wd,sd,pm,gzcd,gzjy,pbcd,pbjy;
    private ImageView image_yody;
    private String[] week={"今天","明天","周五","周六","周日","周一"};
    private List<TqInfor> mlist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_tqxx);
        initView();
        setVolley();
        setVolley2();
    }

    private void setVolley2() {
        VolleyTo volleyTo=new VolleyTo();
        volleyTo.setUrl("get_all_sense").setJsonObject("UserName","user1").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                   int wendu= jsonObject.getInt("temperature");
                    int shidi=jsonObject.getInt("humidity");
                    int guangzhao=jsonObject.getInt("illumination");
                   int pm25= jsonObject.getInt("pm25");
                   if (pm25>=0&&pm25<100){
                       pbcd.setText("良好");
                       pbjy.setText("气象条件会对晨练影响不大");
                   }else if (pm25>=100&&pm25<200){
                       pbcd.setText("轻度");
                       pbjy.setText("受天气影响，较不宜晨练");
                   }else if (pm25>=200&&pm25<300){
                       pbcd.setText("重度");
                       pbjy.setText("减少外出，出行注意戴口罩");
                   }else {
                       pbcd.setText("报表");
                       pbcd.setTextColor(Color.RED);
                       pbjy.setText("停止一切外出活动");
                   }

                    if (guangzhao>=0&&guangzhao<1000){
                        gzcd.setText("非常弱");
                        gzjy.setText("您无需担心紫外线");
                    }else if (guangzhao>=1000&&pm25<3000){
                        gzcd.setText("弱");
                        gzjy.setText("外出适当涂抹低倍数防晒霜");
                    }else {
                        gzcd.setText("强");
                        gzcd.setTextColor(Color.RED);
                        gzjy.setText("外出需要涂抹中倍数防晒霜");
                    }


                   wd.setText(wendu+"");
                   sd.setText(shidi+"");
                   pm.setText(pm25+"");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void setVolley() {
        VolleyTo volleyTo=new VolleyTo();
        volleyTo.setUrl("get_weather_info").setJsonObject("UserName","user1").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    mlist.clear();
                   wd_tody.setText(jsonObject.getInt("temperature")+"度");
                    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日");
                    Date date1=new Date(System.currentTimeMillis());
                    date.setText(dateFormat.format(date1));
                    switch (jsonObject.getString("weather")){
                        case "晴":
                            image_yody.setImageResource(R.drawable.qing);
                            break;
                        case "阴":
                            image_yody.setImageResource(R.drawable.yintian);
                            break;
                    }
                    JSONArray jsonArray=jsonObject.getJSONArray("ROWS_DETAIL");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        String wd=jsonObject1.getString("interval");
                        String weather=jsonObject1.getString("weather");
                        SimpleDateFormat dateForma2t=new SimpleDateFormat("dd日");
                        Date date2=new Date(System.currentTimeMillis());
                        mlist.add(new TqInfor(dateForma2t.format(date2)+"("+week[i]+")",weather,wd));
                    }
                    gv.setAdapter(new TqAdapter(BtqxxActivity.this,0,mlist));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void initView() {
        ImageView reflash=findViewById(R.id.change2);
        reflash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVolley();
            }
        });
        gv=findViewById(R.id.gv);
        wd_tody=findViewById(R.id.wd_tody);
        date=findViewById(R.id.date);
        wd=findViewById(R.id.wd);
        sd=findViewById(R.id.sd);
        pm=findViewById(R.id.pm);
        gzcd=findViewById(R.id.gzcd);
        gzjy=findViewById(R.id.gzjy);
        pbcd=findViewById(R.id.pbcd);
        pbjy=findViewById(R.id.pbjy);
        image_yody=findViewById(R.id.image_tody);
        mlist=new ArrayList<>();
    }

}
