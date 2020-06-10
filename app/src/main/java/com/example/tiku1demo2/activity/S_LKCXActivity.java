package com.example.tiku1demo2.activity;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dell on 2019/9/18.
 */

public class S_LKCXActivity extends AppCompatActivity {
    private ImageView dh1,dh2;
    private TextView riqi,xingqi,wendu,shidu,pm;
    private ImageView shuxin;
    private AnimationDrawable animationDrawable;
    private TextView hcksl,hcksl1,hcksl2,xyl,yyl,lxl,xfl,hcgs,tcc;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_lkcxactivity);
        inview();
        donghua();
        huoqu();
        setdianji();
        huoqu1();

    }

    private void adddata(String bianhao,String zhi) {
        if (bianhao.equals("1"))
        {
            switch (zhi)
            {
                case "1":
                    xyl.setBackgroundColor(Color.parseColor("#6ab82e"));
                    break;
                case "2":
                    xyl.setBackgroundColor(Color.parseColor("#ece93a"));
                    break;
                case "3":
                    xyl.setBackgroundColor(Color.parseColor("#f49b25"));
                    break;
                case "4":
                    xyl.setBackgroundColor(Color.parseColor("#e33532"));
                    break;
                case "5":
                    xyl.setBackgroundColor(Color.parseColor("#b01e23"));
                    break;


            }
        }else  if (bianhao.equals("2"))
        {
            switch (zhi)
            {
                case "1":
                    lxl.setBackgroundColor(Color.parseColor("#6ab82e"));
                    break;
                case "2":
                    lxl.setBackgroundColor(Color.parseColor("#ece93a"));
                    break;
                case "3":
                    lxl.setBackgroundColor(Color.parseColor("#f49b25"));
                    break;
                case "4":
                    lxl.setBackgroundColor(Color.parseColor("#e33532"));
                    break;
                case "5":
                    lxl.setBackgroundColor(Color.parseColor("#b01e23"));
                    break;


            }
        }else  if (bianhao.equals("3"))
        {
            switch (zhi)
            {
                case "1":
                    yyl.setBackgroundColor(Color.parseColor("#6ab82e"));
                    break;
                case "2":
                    yyl.setBackgroundColor(Color.parseColor("#ece93a"));
                    break;
                case "3":
                    yyl.setBackgroundColor(Color.parseColor("#f49b25"));
                    break;
                case "4":
                    yyl.setBackgroundColor(Color.parseColor("#e33532"));
                    break;
                case "5":
                    yyl.setBackgroundColor(Color.parseColor("#b01e23"));
                    break;


            }
        }
        else  if (bianhao.equals("4"))
        {
            switch (zhi)
            {
                case "1":
                    xfl.setBackgroundColor(Color.parseColor("#6ab82e"));
                    break;
                case "2":
                    xfl.setBackgroundColor(Color.parseColor("#ece93a"));
                    break;
                case "3":
                    xfl.setBackgroundColor(Color.parseColor("#f49b25"));
                    break;
                case "4":
                    xfl.setBackgroundColor(Color.parseColor("#e33532"));
                    break;
                case "5":
                    xfl.setBackgroundColor(Color.parseColor("#b01e23"));
                    break;


            }
        }
        else  if (bianhao.equals("5")) {
            switch (zhi) {
                case "1":
                    hcksl.setBackgroundColor(Color.parseColor("#6ab82e"));
                    hcksl1.setBackgroundColor(Color.parseColor("#6ab82e"));
                    hcksl2.setBackgroundColor(Color.parseColor("#6ab82e"));
                    break;
                case "2":
                    hcksl.setBackgroundColor(Color.parseColor("#ece93a"));
                    hcksl1.setBackgroundColor(Color.parseColor("#ece93a"));
                    hcksl2.setBackgroundColor(Color.parseColor("#ece93a"));
                    break;
                case "3":
                    hcksl.setBackgroundColor(Color.parseColor("#f49b25"));
                    hcksl1.setBackgroundColor(Color.parseColor("#f49b25"));
                    hcksl2.setBackgroundColor(Color.parseColor("#f49b25"));
                    break;
                case "4":
                    hcksl.setBackgroundColor(Color.parseColor("#e33532"));
                    hcksl1.setBackgroundColor(Color.parseColor("#e33532"));
                    hcksl2.setBackgroundColor(Color.parseColor("#e33532"));
                    break;
                case "5":
                    hcksl.setBackgroundColor(Color.parseColor("#b01e23"));
                    hcksl1.setBackgroundColor(Color.parseColor("#b01e23"));
                    hcksl2.setBackgroundColor(Color.parseColor("#b01e23"));
                    break;


            }

        }
        else  if (bianhao.equals("6"))
        {
            switch (zhi)
            {
                case "1":
                    hcgs.setBackgroundColor(Color.parseColor("#6ab82e"));
                    break;
                case "2":
                    hcgs.setBackgroundColor(Color.parseColor("#ece93a"));
                    break;
                case "3":
                    hcgs.setBackgroundColor(Color.parseColor("#f49b25"));
                    break;
                case "4":
                    hcgs.setBackgroundColor(Color.parseColor("#e33532"));
                    break;
                case "5":
                    hcgs.setBackgroundColor(Color.parseColor("#b01e23"));
                    break;


            }
        }
        else  if (bianhao.equals("7"))
        {
            switch (zhi)
            {
                case "1":
                    tcc.setBackgroundColor(Color.parseColor("#6ab82e"));
                    break;
                case "2":
                    tcc.setBackgroundColor(Color.parseColor("#ece93a"));
                    break;
                case "3":
                    tcc.setBackgroundColor(Color.parseColor("#f49b25"));
                    break;
                case "4":
                    tcc.setBackgroundColor(Color.parseColor("#e33532"));
                    break;
                case "5":
                    tcc.setBackgroundColor(Color.parseColor("#b01e23"));
                    break;


            }
        }
    }

    private void huoqu1() {
        VolleyTo volleyTo  =new VolleyTo();
        volleyTo.setUrl("get_road_status").setJsonObject("UserName","user1").setJsonObject("RoadId","0").setTime(3000).setLoop(true).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    String arr  =jsonObject.getString("ROWS_DETAIL");
                    JSONArray jsonArray  =new JSONArray(arr);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        adddata(jsonObject1.getString("roadId"),jsonObject1.getString("state"));
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void setdianji() {
        shuxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                huoqu();
            }
        });
    }

    private void huoqu() {
        VolleyTo volleyTo  =new VolleyTo();
        volleyTo.setUrl("get_all_sense").setJsonObject("UserName","user1").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
                    Date date  =new Date(System.currentTimeMillis());
                    String time = format.format(date);
                    riqi.setText(time);
                    Calendar c=Calendar.getInstance();
                    int xq=c.get(Calendar.DAY_OF_WEEK);
                    switch (xq)
                    {
                        case 1:
                            xingqi.setText("星期日" );
                            break;
                        case 2:
                            xingqi.setText("星期一" );
                            break;
                        case 3:
                            xingqi.setText("星期二" );
                            break;
                        case 4:
                            xingqi.setText("星期三" );
                            break;
                        case 5:
                            xingqi.setText("星期四" );
                            break;
                        case 6:
                            xingqi.setText("星期五" );
                            break;
                        case 7:
                            xingqi.setText("星期六" );
                            break;
                    }
                    wendu.setText(jsonObject.getString("temperature")+"℃");
                    shidu.setText(jsonObject.getString("humidity")+"%");
                    pm.setText(jsonObject.getString("pm25")+"ug/m3");
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void inview() {
        dh1  =findViewById(R.id.dh1);
        dh2  =findViewById(R.id.dh2);
        riqi  =findViewById(R.id.riqi);
        hcksl  =findViewById(R.id.hcksl);
        hcksl1  =findViewById(R.id.hcksl1);
        hcksl2  =findViewById(R.id.hcksl2);
        TextView contetn = findViewById(R.id.content);
        contetn.setText("路况查询");
        ImageView change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tcc = findViewById(R.id.tcc);
        xfl  =findViewById(R.id.xfl);
        xyl  =findViewById(R.id.xyl);
        lxl  =findViewById(R.id.lxl);
        yyl  =findViewById(R.id.yyl);
        hcgs  =findViewById(R.id.hcgs);
        xingqi  =findViewById(R.id.xingqi);
        wendu  =findViewById(R.id.wendu);
        shidu = findViewById(R.id.shidu);
        pm  =findViewById(R.id.pm);
        shuxin = findViewById(R.id.shuaxin);
    }

    private void donghua() {
        dh1.setBackgroundResource(R.drawable.jiaojing1);
        animationDrawable  =(AnimationDrawable) dh1.getBackground();
        animationDrawable.start();
        dh2.setBackgroundResource(R.drawable.jiaojing2);
        animationDrawable  =(AnimationDrawable) dh2.getBackground();
        animationDrawable.start();
    }
}
