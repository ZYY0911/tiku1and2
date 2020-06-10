package com.example.tiku1demo2.activity;

import android.content.Intent;
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

public class JkActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jkzp_layout);
        ImageView imageView=findViewById(R.id.jk1_img1);
        ImageView imageView2=findViewById(R.id.jk1_img2);
        ImageView imageView3=findViewById(R.id.jk1_img3);
        ImageView imageView4=findViewById(R.id.jk1_img4);
        Button fh=findViewById(R.id.jk1_fh);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JkActivity.this,JkzpActivity.class);
                intent.putExtra("index",0);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JkActivity.this,JkzpActivity.class);
                intent.putExtra("index",1);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JkActivity.this,JkzpActivity.class);
                intent.putExtra("index",2);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JkActivity.this,JkzpActivity.class);
                intent.putExtra("index",3);
                startActivity(intent);
            }
        });
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final ImageView fh2=findViewById(R.id.change);
        fh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tv=findViewById(R.id.context);
        tv.setText("监控抓拍");
    }
}
