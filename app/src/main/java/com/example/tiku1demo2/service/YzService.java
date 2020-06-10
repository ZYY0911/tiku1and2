package com.example.tiku1demo2.service;


import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Create by 张瀛煜 on 2019-09-18
 */
public class YzService extends Service {
    private int wd,sd,gz,co,pm,dl;
    private VolleyTo volleyTo2;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        setVolley();
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * "temperature": 23,
     *             "humidity": 15,
     *             "illumination": 100,
     *             "co2": 2000,
     *             "pm25": 100,
     *             "path": 7
     */
    private void setVolley() {
       volleyTo2 = new VolleyTo();
        volleyTo2.setUrl("get_threshold")
                .setJsonObject("UserName","user1")
                .setTime(10000)
                .setLoop(true)
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (jsonObject.has("RESULT")){
                            try {
                                if (jsonObject.getString("RESULT").equals("S")){
                                    JSONArray jsonArray = new JSONArray(jsonObject.getString("ROWS_DETAIL"));
                                    JSONObject jsonObject1  = jsonArray.getJSONObject(0);
                                    wd = jsonObject1.getInt("temperature");
                                    sd = jsonObject1.getInt("humidity");
                                    gz = jsonObject1.getInt("illumination");
                                    co = jsonObject1.getInt("co2");
                                    pm = jsonObject1.getInt("pm25");
                                    dl = jsonObject1.getInt("path");
                                }
                                setVolley_2();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }).start();
    }

    /**
     *  "temperature": 19,
     *     "humidity": 6,
     *     "illumination": 1786,
     *     "co2": 4116,
     *     "pm25": 15
     */

    private void setVolley_2() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_all_sense")
                .setJsonObject("UserName","user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (jsonObject.has("RESULT")){
                            try {
                                if (jsonObject.getString("RESULT").equals("S")){
                                    if (jsonObject.getInt("temperature")>wd){
                                        send("温度报警，阈值"+wd+"，当前值"+jsonObject.getInt("temperature"),1);
                                    }
                                    if (jsonObject.getInt("humidity")>gz){
                                        send("光照报警，阈值"+gz+"，当前值"+jsonObject.getInt("LightIntensity"),2);
                                    }
                                    if (jsonObject.getInt("illumination")>sd) {
                                        send("湿度报警，阈值" + sd + "，当前值" + jsonObject.getInt("humidity"), 3);
                                    }
                                    if (jsonObject.getInt("pm25")>pm){
                                        send("PM2.5报警，阈值"+pm+"，当前值"+jsonObject.getInt("pm2.5"),4);
                                    }
                                    if (jsonObject.getInt("co2")>co){
                                        send("CO2报警，阈值"+co+"，当前值"+jsonObject.getInt("co2"),5);
                                    }
                                    Random random = new Random();
                                    int a = random.nextInt(5);
                                    if (a>dl){
                                        send("道路状态报警，阈值"+a+"，当前值"+dl,6);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }).start();
    }

    private void send(String message,int id){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("空气指标")
                .setAutoCancel(true)
                .setContentText(message)
                .setWhen(System.currentTimeMillis());
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id,builder.build());


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        volleyTo2.setLoop(false);
        volleyTo2 = null;
    }
}
