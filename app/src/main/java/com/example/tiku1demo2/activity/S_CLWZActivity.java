package com.example.tiku1demo2.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.fragment.S_Fragment_image;
import com.example.tiku1demo2.fragment.S_Fragment_video;

/**
 * Created by dell on 2019/9/18.
 */

public class S_CLWZActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView video,image;
    private LinearLayout linearLayout;
    private FragmentTransaction ft;
    private FragmentManager fm;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_clwzactivity);
        inview();
        fm  =getFragmentManager();
        ft  =fm.beginTransaction();
        ft.replace(R.id.line,new S_Fragment_video());
        ft.commit();
        video.setOnClickListener(this);
        image.setOnClickListener(this);
    }

    private void inview() {
        video  =findViewById(R.id.video);
        image  =findViewById(R.id.image);
        linearLayout  =findViewById(R.id.line);
        ImageView  im = findViewById(R.id.change);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView tv = findViewById(R.id.content);
        tv.setText("车辆违章");
    }

    @Override
    public void onClick(View v) {
        ft  =fm.beginTransaction();
        switch (v.getId())
        {
            case R.id.video:
                ft.replace(R.id.line,new S_Fragment_video());
                video.setBackgroundResource(R.drawable.biankuang);
                image.setBackgroundResource(R.drawable.biankuang1);
                break;
            case R.id.image:
                ft.replace(R.id.line,new S_Fragment_image());
                image.setBackgroundResource(R.drawable.biankuang);
                video.setBackgroundResource(R.drawable.biankuang1);
                break;

        }
        ft.commit();
    }
}
