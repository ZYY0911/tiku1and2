package com.example.tiku1demo2.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.FragmentAdapter;
import com.example.tiku1demo2.bean.s_no;
import com.example.tiku1demo2.bean.s_sjfx;
import com.example.tiku1demo2.bean.s_yes;
import com.example.tiku1demo2.fragment.S_Fragment_wzcf;
import com.example.tiku1demo2.fragment.S_Fragment_wzcs;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2019/9/18.
 */

public class S_SJFXActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private List<s_sjfx> msjfx;
    private List<s_yes> myes;
    private List<s_no> mon;
    private Map<String,Float> map;
    private int a,b,c;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_sjfxactiivty);
        inview();
        huoqu();






    }

    private void select(int position) {
        for (int i=0;i<linearLayout.getChildCount();i++)
        {
            ImageView im = (ImageView) linearLayout.getChildAt(i);
            if (i==position)
            {
                im.setBackgroundResource(R.drawable.shi);
            }
            else {
                im.setBackgroundResource(R.drawable.kong);
            }
        }
    }

    private void settu() {
        linearLayout.removeAllViews();
        for (int i=0;i<fragments.size();i++)
        {
            ImageView im = new ImageView(this);
            if (i==0)
            {
                im.setBackgroundResource(R.drawable.shi);
            }
            else {
                im.setBackgroundResource(R.drawable.kong);
            }
            im.setLayoutParams(new LinearLayout.LayoutParams(20,20, Gravity.CENTER));//设置宽高
            FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(50,50));
            params.rightMargin=50;//设置左右距离
            params.leftMargin=50;//设置左右距离
            linearLayout.addView(im,params);//设置完成后，设置到界面上
        }
    }

    private void wzcs() {
        for (Float conut :map.values() )
        {
           if (conut<=2) a++;
           else  if (conut<=5) b++;
           else  if (conut>2) c++;
        }
    }

    private void ywcf() {
        for (int i=0;i<myes.size();i++)
        {
            String id = myes.get(i).getChepaihao();
            Float count = map.get(id);
            map.put(id,(count==null)?1:count+1);
        }
    }

    private void addfrageg() {
        fragments.add(new S_Fragment_wzcf(map,myes));
        fragments.add(new S_Fragment_wzcs(a,b,c));
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments));
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(fragments.size());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                select(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        settu();
    }

    private void ywwz() {
        for (int i=0;i<msjfx.size();i++)
        {
            s_sjfx s = msjfx.get(i);
            if (s.getYuanyin().equals(""))
            {
                mon.add(new s_no(s.getChepaihao(),s.getYuanyin()));
            }
            else {
                myes.add(new s_yes(s.getChepaihao(),s.getYuanyin()));
            }
        }
        ywcf();
        wzcs();

        addfrageg();
    }

    private void huoqu() {
        VolleyTo volleyTo  =new VolleyTo();
        volleyTo.setUrl("get_peccancy").setJsonObject("UserName","user1").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
              try {
                  String arr = jsonObject.getString("ROWS_DETAIL");
                  JSONArray jsonArray  =new JSONArray(arr);
                  for (int i=0;i<jsonArray.length();i++)
                  {
                      JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                      msjfx.add(new s_sjfx(jsonObject1.getString("carnumber"),jsonObject1.getString("paddr")));

                  }
                  System.out.println("----"+msjfx);
                  ywwz();

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
        linearLayout  =findViewById(R.id.lin);
        viewPager  =findViewById(R.id.viewpager);
        fragments  =new ArrayList<>();
        msjfx  =new ArrayList<>();
        mon  =new ArrayList<>();
        myes = new ArrayList<>();
        map  =new HashMap<>();
        ImageView im = findViewById(R.id.change);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView tv  =findViewById(R.id.content);
        tv.setText("数据分析");
    }

}
