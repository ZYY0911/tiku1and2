package com.example.tiku1demo2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by 张瀛煜 on 2019-07-10
 */
public class SimpDate {
    public static String setData(Date date, String type){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        return simpleDateFormat.format(date);
    }

    public static int getYear(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        return Integer.parseInt(simpleDateFormat.format(new Date()));
    }

    public static int getMonth(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
        return Integer.parseInt(simpleDateFormat.format(new Date()));
    }

    public static int getDay(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        return Integer.parseInt(simpleDateFormat.format(new Date()));
    }
}
