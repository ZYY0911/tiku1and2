package com.example.tiku1demo2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.tiku1demo2.ImageListener;
import com.example.tiku1demo2.R;

/**
 * Created by dell on 2019/9/18.
 */

public class S_IMAGEActivity extends AppCompatActivity
{
    private ImageView im;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_imageactivty);
        inview();
        jiesho();
    }

    private void jiesho() {
        switch (getIntent().getStringExtra("index"))
        {
            case "1":
           huoqu1();
                break;
            case "2":
              huoqu2();
                break;
            case "3":
                huoqu3();
                break;
            case "4":
                huoqu4();
                break;
            case "5":
                huoqu11();
                break;
            case "6":
                huoqu21();
                break;
            case "7":
                huoqu31();
                break;
            case "8":
                huoqu41();
                break;

            case "9":
                huoqu1();
                break;
            case "10":
                huoqu2();
                break;
            case "11":
                huoqu3();
                break;
            case "12":
                huoqu4();
                break;
            case "13":
                huoqu11();
                break;
            case "14":
                huoqu21();
                break;
            case "15":
                huoqu31();
                break;
            case "16":
                huoqu41();
                break;
        }
    }

    private void huoqu1() {
        im.setImageResource(R.drawable.weizhang01);
        im.setOnTouchListener(new ImageListener(im));
    }
    private void huoqu2() {
        im.setImageResource(R.drawable.weizhang02);
        im.setOnTouchListener(new ImageListener(im));
    }
    private void huoqu3() {
        im.setImageResource(R.drawable.weizhang03);
        im.setOnTouchListener(new ImageListener(im));
    }
    private void huoqu4() {
        im.setImageResource(R.drawable.weizhang04);
        im.setOnTouchListener(new ImageListener(im));
    }
    private void huoqu11() {
        im.setImageResource(R.drawable.weizhang1);
        im.setOnTouchListener(new ImageListener(im));
    }
    private void huoqu21() {
        im.setImageResource(R.drawable.weizhang2);
        im.setOnTouchListener(new ImageListener(im));
    }
    private void huoqu31() {
        im.setImageResource(R.drawable.weizhang3);
        im.setOnTouchListener(new ImageListener(im));
    }
    private void huoqu41() {
        im.setImageResource(R.drawable.weizhang4);
        im.setOnTouchListener(new ImageListener(im));
    }

    private void inview() {
        im = findViewById(R.id.im);
    }
}
