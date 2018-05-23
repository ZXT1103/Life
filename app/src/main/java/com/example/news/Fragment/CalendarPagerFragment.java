package com.example.news.Fragment;

import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.news.R;

/**
 * Created by 填爷 on 2018/5/22.
 */

public class CalendarPagerFragment extends Fragment {

    private int monthIndex;
    private int year;
    private int month;
    private Calendar date;
    private int offset;

    public CalendarPagerFragment(int monthIndex){
        this.monthIndex = monthIndex;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TableRow tableRow;
        View cellView;
        TableLayout tableView = (TableLayout)inflater.inflate(R.layout.view_pager_fragment,
                container,false);
        for (int row = 0;row<6;row++){
            //新建一个tableRow相当于在布局上画出一行
            tableRow = new TableRow(tableView.getContext());
            for (int colum=0;colum<7;colum++){
                //读取每天的布局，并且添加到tableRow中，这里相当于在那一行添加了7列dayCell
                cellView = getView(row*7+colum,inflater,tableRow);
                //焦点改变监听事件
                cellView.setOnFocusChangeListener((View.OnFocusChangeListener)
                        container.getContext());
                tableRow.addView(cellView);
            }

            //每一行tableRow都加入tableView
            tableView.addView(tableRow);
        }
        return tableView;
    }

    //获取每个dayCell的布局
    private View getView(int position,LayoutInflater inflater,
                         ViewGroup container){
        //由当前显示的mouth页的位置，计算现在是哪年，哪月
        year = 2000+(monthIndex/12);
        month = monthIndex%12;
        //设定日期到当前x年x月1号的日期
        date = new GregorianCalendar(year,month,1);
        //计算x年x月1号是周几
        offset = 1 - date.get(Calendar.DAY_OF_WEEK);
        //data.add()通过position和偏离，算出循环到的日期
        date.add(Calendar.DAY_OF_MONTH,(offset+position));
        ViewGroup rootView;
        rootView = (ViewGroup)inflater.inflate(R.layout.day_cell,
                container,false);
        TextView txtDayCell = (TextView)rootView.findViewById(R.id.dayCell);
        txtDayCell.setText(String.valueOf(date.get(Calendar.DAY_OF_MONTH)));

        //如果是今天，就给改天设置背景shape_calendar_cell_today
        if (isToday(date)){
            rootView.setBackgroundResource(R.drawable.shape_calendar_cell_today);
        }
        //将这个dayCell的日期信息保存起来，以便点击事件时利用
        rootView.setTag(date);
        return rootView;
    }

    //用于判断当前日期是不是今天
    private Boolean isToday(Calendar date){
        Calendar today = Calendar.getInstance();
        if ((date.get(Calendar.YEAR) == today.get(Calendar.YEAR))
                &&(date.get(Calendar.MONTH) == today.get(Calendar.MONTH))
                &&(date.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH))){
            return true;
        }
        return false;
    }
}
