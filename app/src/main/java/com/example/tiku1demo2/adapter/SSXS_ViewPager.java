package com.example.tiku1demo2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Create by 张瀛煜 on 2019-09-18
 */
public class SSXS_ViewPager extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public SSXS_ViewPager(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
