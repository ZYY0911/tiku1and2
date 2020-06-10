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
import com.example.tiku1demo2.activity.S_IMAGEActivity;

/**
 * Created by dell on 2019/9/18.
 */

public class S_Fragment_image extends Fragment {
    private ImageView im11,im12,im13,im14,im21,im22,im23,im24,im31,im32,im33,im34,im41,im42,im43,im44;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.s_fragment_image,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inview();
        setdianjI();

    }

    private void setdianjI() {
        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("1");
            }
        });
        im12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("2");
            }
        });
        im13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("3");
            }
        });
        im14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("4");
            }
        });
        im21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("5");
            }
        });
        im22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("6");
            }
        });
        im23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("7");
            }
        });
        im24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("8");
            }
        });

        im31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("9");
            }
        });
        im32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("10");
            }
        });
        im33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("11");
            }
        });
        im34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("12");
            }
        });
        im41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("13");
            }
        });
        im42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("14");
            }
        });
        im43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("15");
            }
        });
        im44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuan("16");
            }
        });
    }

    private void zhuan(String i) {
        Intent intent  =new Intent(getActivity(), S_IMAGEActivity.class);
        intent.putExtra("index",i);
        startActivity(intent);
    }

    private void inview() {
        im11 = getActivity().findViewById(R.id.im11);
        im12 = getActivity().findViewById(R.id.im12);
        im13 = getActivity().findViewById(R.id.im13);
        im14 = getActivity().findViewById(R.id.im14);

        im21 = getActivity().findViewById(R.id.im21);
        im22 = getActivity().findViewById(R.id.im22);
        im23 = getActivity().findViewById(R.id.im23);
        im24 = getActivity().findViewById(R.id.im24);

        im31 = getActivity().findViewById(R.id.im31);
        im32 = getActivity().findViewById(R.id.im32);
        im33 = getActivity().findViewById(R.id.im33);
        im34 = getActivity().findViewById(R.id.im34);

        im41 = getActivity().findViewById(R.id.im41);
        im42 = getActivity().findViewById(R.id.im42);
        im43 = getActivity().findViewById(R.id.im43);
        im44 = getActivity().findViewById(R.id.im44);

    }
}
