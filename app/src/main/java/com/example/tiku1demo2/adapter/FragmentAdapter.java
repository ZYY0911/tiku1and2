package com.example.tiku1demo2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dell on 2019/7/19.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments)
    {
        super(fm);
        this.fragments=fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
