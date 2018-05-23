package com.example.news.gson;

/**
 * Created by 填爷 on 2018/5/23.
 */

public class AQI {
    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
