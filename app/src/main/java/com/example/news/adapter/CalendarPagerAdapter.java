package com.example.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.news.Fragment.CalendarPagerFragment;

/**
 * Created by 填爷 on 2018/5/22.
 */

public class CalendarPagerAdapter extends FragmentStatePagerAdapter {

    public CalendarPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int monthIndex) {
        //返回一个fragement
        return new CalendarPagerFragment(monthIndex);
    }

    @Override
    public int getCount() {
        //返回viewpager的总页数，这里设定从2000-2100年
        return (2100-2000)*12;
    }
}
