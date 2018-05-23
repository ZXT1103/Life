package com.example.news;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.news.adapter.CalendarPagerAdapter;

/**
 * Created by 填爷 on 2018/5/23.
 */

public class CalendarActivity extends FragmentActivity implements View.OnFocusChangeListener{
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    //定义一个Calendar类型的变量，为今天
    private Calendar today;

    //显示日期的抬头
    private TextView titleDate;
    private TextView titleWeek;

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            return;
        Calendar cal = (Calendar)v.getTag();
        int offset = (cal.get(Calendar.YEAR)-2000)*12+
                cal.get(Calendar.MONTH);
        changeTitle(offset,cal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取两个TextView控件
        titleDate = (TextView)findViewById(R.id.titleDate);
        //获取ViewPager布局
        mPager = (ViewPager)findViewById(R.id.pager);
        //加载viewPager界面，显示日历
        mPagerAdapter = new CalendarPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        //设置滑动页面监听
        mPager.setOnPageChangeListener(new CalendarActivity.simplePagerChangeListener());
        //将显示页面直接定位到今天
        mPager.setCurrentItem(getTodayMonthIndex());

        Button position = (Button)findViewById(R.id.position);
        position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this,CityActivity.class);
                startActivity(intent);
            }
        });
    }

    //页面滑动时执行的方法
    private class simplePagerChangeListener extends ViewPager.SimpleOnPageChangeListener{
        @Override
        public void onPageSelected(int monthIndex) {
            changeTitle(monthIndex,today);
        }
    }

    //返回今天所在月份的页面编号
    private int getTodayMonthIndex(){
        today = Calendar.getInstance();
        int offset = (today.get(Calendar.YEAR)-2000)*12+
                today.get(Calendar.MONTH);
        return offset;
    }

    //点击图片回到今天
    public void onBackToday(View v){
        switch (v.getId()){
            case R.id.backToday :
                mPager.setCurrentItem(getTodayMonthIndex());
        }
    }

    //改变data和week抬头
    private void changeTitle(int position,Calendar date){
        StringBuilder title = new StringBuilder();
        int year = 2000+(position/12);
        title.append(year);
        title.append("-");
        int month = (position%12)+1;
        title.append(month);
        title.append("-");
        int day_num = date.get(Calendar.DAY_OF_MONTH);
        title.append(day_num);
        titleDate.setText(title);


    }
}
