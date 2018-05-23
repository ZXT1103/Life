package com.example.news.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 填爷 on 2018/5/23.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
