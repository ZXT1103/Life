package com.example.news.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 填爷 on 2018/5/23.
 */

public class County extends DataSupport {
    private int id;
    private String countyName;  //记录县的名字
    private String weatherId;    //记录县对应的天气的id
    private int cityId;         //记录当前县所属市的id值

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCountyName(){
        return countyName;
    }

    public void setCountyName(String countyName){
        this.countyName = countyName;
    }

    public String getWeatherId(){
        return weatherId;
    }

    public void setWeatherId(String weatherId){
        this.weatherId = weatherId;
    }

    public int getCityId(){
        return cityId;
    }

    public void setCityId(int cityId){
        this.cityId = cityId;
    }
}
