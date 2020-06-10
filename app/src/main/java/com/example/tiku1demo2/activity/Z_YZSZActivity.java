package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;
import com.example.tiku1demo2.service.YzService;
import com.example.tiku1demo2.util.ShowDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by 张瀛煜 on 2019-09-18
 */
public class Z_YZSZActivity extends AppCompatActivity {
    private TextView switch_text;
    private Switch switch_info;
    private EditText tv_wd, tv_sd, tv_gz, tv_co, tv_pm, tv_dl;
    private Button save_bt;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yzsz_layout);
        intent = new Intent(Z_YZSZActivity.this, YzService.class);
        initView();
        onListen();
        initData(AppClient.getEnable());
        setVolley();
        setOnClick();
    }

    private void setOnClick() {
        save_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_wd.getText().toString().equals("")){
                    ShowDialog.show(Z_YZSZActivity.this,"温度阈值不能为空");
                    return;
                }
                if (tv_sd.getText().toString().equals("")){
                    ShowDialog.show(Z_YZSZActivity.this,"湿度阈值不能为空");
                    return;
                }
                if (tv_gz.getText().toString().equals("")){
                    ShowDialog.show(Z_YZSZActivity.this,"光照阈值不能为空");
                    return;
                }
                if (tv_co.getText().toString().equals("")){
                    ShowDialog.show(Z_YZSZActivity.this,"CO2阈值不能为空");
                    return;
                }
                if (tv_pm.getText().toString().equals("")){
                    ShowDialog.show(Z_YZSZActivity.this,"PM2.5阈值不能为空");
                    return;
                }
                if (tv_dl.getText().toString().equals("")){
                    ShowDialog.show(Z_YZSZActivity.this,"道路状态阈值不能为空");
                    return;
                }
                VolleyTo volleyTo = new VolleyTo();
                volleyTo.setUrl("set_threshold")
                        .setJsonObject("UserName","user1")
                        .setJsonObject("temperature",tv_wd.getText().toString())
                        .setJsonObject("humidity",tv_sd.getText().toString())
                        .setJsonObject("illumination",tv_gz.getText().toString())
                        .setJsonObject("co2",tv_co.getText().toString())
                        .setJsonObject("pm25",tv_pm.getText().toString())
                        .setJsonObject("path",tv_dl.getText().toString())
                        .setmDialog(Z_YZSZActivity.this)
                        .setVolleyLo(new VolleyLo() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                if (jsonObject.has("RESULT")){
                                    try {
                                        if (jsonObject.getString("RESULT").equals("S")){
                                            ShowDialog.show(Z_YZSZActivity.this,"设置成功");
                                            setVolley();
                                        }else {
                                            ShowDialog.show(Z_YZSZActivity.this,"设置失败");
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                ShowDialog.show(Z_YZSZActivity.this,"设置失败");
                            }
                        }).start();
            }
        });
    }

    private void setVolley() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_threshold")
                .setJsonObject("UserName","user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (jsonObject.has("RESULT")){
                            try {
                                if (jsonObject.getString("RESULT").equals("S")){
                                    JSONArray jsonArray = new JSONArray(jsonObject.getString("ROWS_DETAIL"));
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                                    tv_wd.setText(jsonObject1.getString("temperature"));
                                    tv_sd.setText(jsonObject1.getString("humidity"));
                                    tv_gz.setText(jsonObject1.getString("illumination"));
                                    tv_co.setText(jsonObject1.getString("co2"));
                                    tv_pm.setText(jsonObject1.getString("pm25"));
                                    tv_dl.setText(jsonObject1.getString("path"));

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

    private void onListen() {
        switch_info.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    initData(true);
                } else {
                    initData(false);
                }
            }
        });
    }

    private void initData(boolean is) {
        if (is) {
            switch_text.setText("开");
            startService(intent);
            save_bt.setEnabled(false);
            AppClient.setEnable(true);
        }else {
            switch_text.setText("关");
            save_bt.setEnabled(true);
            stopService(intent);
            AppClient.setEnable(false);
        }
        tv_wd.setEnabled(!is);
        tv_sd.setEnabled(!is);
        tv_gz.setEnabled(!is);
        tv_co.setEnabled(!is);
        tv_pm.setEnabled(!is);
        tv_dl.setEnabled(!is);

    }

    private void initView() {
        save_bt = findViewById(R.id.save_bt);
        tv_wd = findViewById(R.id.tv_wd);
        tv_sd = findViewById(R.id.tv_sd);
        tv_gz = findViewById(R.id.tv_gz);
        tv_co = findViewById(R.id.tv_co);
        tv_pm = findViewById(R.id.tv_pm);
        tv_dl = findViewById(R.id.tv_dl);
        TextView content = findViewById(R.id.content);
        content.setText("阈值设置");
        final ImageView change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        switch_text = findViewById(R.id.switch_text);
        switch_info = findViewById(R.id.switch_info);
        switch_info.setChecked(AppClient.getEnable());
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        startService(intent);
    }
}
