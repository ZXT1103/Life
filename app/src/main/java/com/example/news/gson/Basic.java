package com.example.news.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 填爷 on 2018/5/23.
 */

public class Basic {
    @SerializedName("city")    //让JSON字段和Java字段之间建立映射关系
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
