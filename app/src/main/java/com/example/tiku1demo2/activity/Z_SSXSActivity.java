package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.SSXS_ViewPager;
import com.example.tiku1demo2.fragment.SSXS_Fragment1;
import com.example.tiku1demo2.fragment.SSXS_Fragment2;
import com.example.tiku1demo2.fragment.SSXS_Fragment3;
import com.example.tiku1demo2.fragment.SSXS_Fragment4;
import com.example.tiku1demo2.fragment.SSXS_Fragment5;
import com.example.tiku1demo2.fragment.SSXS_Fragment6;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by 张瀛煜 on 2019-09-18
 */
public class Z_SSXSActivity extends AppCompatActivity {
    private ViewPager viewpager;
    private LinearLayout linear;
    private List<Fragment> fragments;
    private int select = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ssxs_layout);
        initView();
        select = getIntent().getIntExtra("index", 0);
        setViewPager();
    }


    private void setViewPager() {
        fragments = new ArrayList<>();
        fragments.add(new SSXS_Fragment1());
        fragments.add(new SSXS_Fragment2());
        fragments.add(new SSXS_Fragment3());
        fragments.add(new SSXS_Fragment4());
        fragments.add(new SSXS_Fragment5());
        fragments.add(new SSXS_Fragment6());
        viewpager.setAdapter(new SSXS_ViewPager(getSupportFragmentManager(), fragments));
        viewpager.setCurrentItem(select);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                setlect(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setShow();
    }

    private void setShow() {
        linear.removeAllViews();
        for (int i=0;i<fragments.size();i++){
            ImageView imageView = new ImageView(this);
            if (i==select){
                imageView.setImageResource(R.drawable.page_indicator_focused);
            }else {
                imageView.setImageResource(R.drawable.page_indicator_unfocused);
            }
            imageView.setLayoutParams(new ViewGroup.LayoutParams(50,60));
            linear.addView(imageView);
        }
    }

    private void setlect(int position) {
        for (int i=0;i<linear.getChildCount();i++){
            ImageView imageView = (ImageView) linear.getChildAt(i);
            if (i==position){
                imageView.setImageResource(R.drawable.page_indicator_focused);
            }else {
                imageView.setImageResource(R.drawable.page_indicator_unfocused);
            }
        }
    }

    private void initView() {
        TextView content = findViewById(R.id.content);
        content.setText("实时显示");
        ImageView change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewpager = findViewById(R.id.viewpager);
        linear = findViewById(R.id.linear);
    }
}
