package com.example.tiku1demo2;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tiku1demo2.bean.Cxjg1;
import com.example.tiku1demo2.bean.Cxjg2;
import com.example.tiku1demo2.bean.HJZB;
import com.example.tiku1demo2.bean.WdzhInfor;
import com.example.tiku1demo2.bean.ZdglInfor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class AppClient extends Application {

    private static RequestQueue requestQueue;
    private static SharedPreferences preferences;
    private static List<HJZB> hjzbs;

    public static List<HJZB> getHjzbs() {
        return hjzbs;
    }

    public static void setHjzbs(List<HJZB> hjzbs) {
        AppClient.hjzbs = hjzbs;
    }

    private List<Cxjg1> CxList=new ArrayList<>();
    private List<Cxjg2> CxList2=new ArrayList<>();

    public List<Cxjg1> getCxList() {
        return CxList;
    }
    public List<Cxjg2> getCxList2() {
        return CxList2;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue= Volley.newRequestQueue(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }
    public static void setEnable(boolean is){
        preferences.edit().putBoolean("isEnable",is).apply();
    }

    public static boolean getEnable(){
        return preferences.getBoolean("isEnable",true);

    }
    private static List<WdzhInfor> mlist=new ArrayList<>();
    private static  int yz=0;
    private static  List<ZdglInfor> list=new ArrayList<>();

    public static List<ZdglInfor> getList() {
        return list;
    }

    public static int getYz() {
        return yz;
    }

    public static List<WdzhInfor> getMlist() {
        return mlist;
    }


    public static void setRequestQueue(JsonObjectRequest jsonObjectRequest){
        requestQueue.add(jsonObjectRequest);
    }

    public void setYd(boolean yd){
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("yd",yd);
        editor.commit();
    }

    public boolean getYd(){
        return preferences.getBoolean("yd",false);
    }
}
