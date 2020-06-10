package com.example.tiku1demo2.activity;

import android.app.DatePickerDialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.util.SimpDate;

import java.util.Calendar;

/**
 * Create by 张瀛煜 on 2019-09-18
 */
public class Z_CXGLActivity extends AppCompatActivity {
    private TextView auto_text1,auto_text2,auto_text3,car_infos,day_time;
    private Switch car_switch1,car_switch2,car_switch3;
    private ImageView gif_light;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cxgl_layout);
        initView();
        setGif();
        setData();
        setOnClick();
    }

    private void setOnClick() {
        day_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Z_CXGLActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        day_time.setText(year+"年"+(month+1)+"月"+dayOfMonth);
                        if (dayOfMonth%2==0){
                            setAutoText(false);
                        }else {
                            setAutoText(true);
                        }
                    }
                },year,month,day);
                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.show();
            }
        });
    }

    private void setData() {
        day_time.setText(SimpDate.getYear()+"年"+SimpDate.getMonth()+"月"+SimpDate.getDay()+"日");
        if (SimpDate.getDay()%2==0){
            setAutoText(false);
        }else {
            setAutoText(true);
        }
    }

    private void setAutoText(boolean is){
        if (is){
            car_infos.setText("单号出行车辆：1、3");
            auto_text1.setText("开");
            auto_text2.setText("停");
            auto_text3.setText("开");
        }else {
            car_infos.setText("双号出行车辆：2");
            auto_text1.setText("停");
            auto_text2.setText("开");
            auto_text3.setText("停");
        }
        car_switch1.setChecked(is);
        car_switch2.setChecked(!is);
        car_switch3.setChecked(is);
        car_switch1.setEnabled(is);
        car_switch2.setEnabled(!is);
        car_switch3.setEnabled(is);
    }



    private void setGif() {
        gif_light.setBackgroundResource(R.drawable.gif);
        AnimationDrawable drawable = (AnimationDrawable) gif_light.getBackground();
        drawable.start();

    }

    private void initView() {
        auto_text1 =findViewById(R.id.auto_text1);
        auto_text2 = findViewById(R.id.auto_text2);
        auto_text3 = findViewById(R.id.auto_text3);
        car_infos = findViewById(R.id.car_infos);
        day_time =findViewById(R.id.day_time);
        car_switch1 =findViewById(R.id.car_switch1);
        car_switch2 =findViewById(R.id.car_switch2);
        car_switch3 =findViewById(R.id.car_switch3);
        TextView content = findViewById(R.id.content);
        content.setText("出行管理");
        ImageView change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gif_light = findViewById(R.id.gif_light);

    }
}
