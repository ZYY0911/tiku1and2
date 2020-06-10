package com.example.tiku1demo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiku1demo2.R;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class JkzpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jkzpim_layout);
        int index=getIntent().getIntExtra("index",0);
        ImageView imageView=findViewById(R.id.jk_img);
        if (index==0){
            imageView.setImageResource(R.drawable.weizhang01);
        }else if (index==1){
            imageView.setImageResource(R.drawable.weizhang02);
        }else if (index==2){
            imageView.setImageResource(R.drawable.weizhang03);
        }else if (index==3){
            imageView.setImageResource(R.drawable.weizhang04);
        }
        Button fh=findViewById(R.id.jk_fh);
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tv=findViewById(R.id.context);
        tv.setText("监控抓拍");
        final ImageView fh2=findViewById(R.id.change);
        fh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
