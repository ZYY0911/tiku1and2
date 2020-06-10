package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class AYdActivity extends AppCompatActivity {

    private AppClient mApp;

    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            startActivity(new Intent(AYdActivity.this,AYhdlActivity.class));
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_yd_layout);
        mApp= (AppClient) getApplication();
        if (mApp.getYd()){
            startActivity(new Intent(AYdActivity.this,AYhdlActivity.class));
        }else {
            mApp.setYd(true);
            handler.sendEmptyMessageDelayed(0x001,3000);
        }
    }
}
