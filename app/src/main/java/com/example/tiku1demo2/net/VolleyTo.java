package com.example.tiku1demo2.net;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tiku1demo2.AppClient;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/9/15 0015.
 */

public class VolleyTo extends Thread  {
    private String Url="http://10.172.176.73:8080/traffic/";
    private JSONObject jsonObject=new JSONObject();
    private int Time;
    private boolean isLoop;
    private ProgressDialog mDialog;
    private VolleyLo volleyLo;

    public VolleyTo setUrl(String url) {
        Url += url;
        return this;
    }

    public VolleyTo setJsonObject(String k, Object v) {
        try {
            jsonObject.put(k,v);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public VolleyTo setTime(int time) {
        Time = time;
        return this;
    }

    public VolleyTo setLoop(boolean loop) {
        isLoop = loop;
        return this;
    }

    public VolleyTo setmDialog(Context context) {
        mDialog=new ProgressDialog(context);
        mDialog.setTitle("提示");
        mDialog.setMessage("网络请求中。。。。");
        return this;
    }

    public VolleyTo setVolleyLo(VolleyLo volleyLo) {
        this.volleyLo = volleyLo;
        return this;
    }

    @Override
    public void run() {
        super.run();
        do {
            JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Url, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject jsonObject) {
                    volleyLo.onResponse(jsonObject);
                    if (mDialog!=null&&mDialog.isShowing()){
                        mDialog.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    volleyLo.onErrorResponse(volleyError);
                    if (mDialog!=null&&mDialog.isShowing()){
                        mDialog.dismiss();
                    }
                }
            });
            AppClient.setRequestQueue(jsonObjectRequest);
            try {
                Thread.sleep(Time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (isLoop);
    }
}
