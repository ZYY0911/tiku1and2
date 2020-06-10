package com.example.tiku1demo2.util;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Create by 张瀛煜 on 2019-07-19
 */
public class ShowDialog {
    public static void show(Context context, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("确定",null);
        builder.setTitle("提示");
        builder.setMessage(message);
        builder.show();
    }

}
