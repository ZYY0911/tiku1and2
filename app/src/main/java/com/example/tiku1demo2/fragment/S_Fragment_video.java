package com.example.tiku1demo2.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.activity.S_VIDEOActivity;

/**
 * Created by dell on 2019/9/18.
 */

public class S_Fragment_video extends Fragment {
    private ImageView im1,im2,im3,im4,im5;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.s_fragment_video,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inview();
        dianji();
    }

    private void zhuan(String i) {
        Intent intent  =new Intent(getActivity(), S_VIDEOActivity.class);
        intent.putExtra("index",i);
        startActivity(intent);
    }

    private void dianji() {
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("1");
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("2");
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("3");
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("4");
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("5");
            }
        });
    }

    private void inview() {
        im1 =getActivity().findViewById(R.id.im1);
        im2 =getActivity().findViewById(R.id.im2);
        im3 =getActivity().findViewById(R.id.im3);
        im4 =getActivity().findViewById(R.id.im4);
        im5 =getActivity().findViewById(R.id.im5);
    }
}
