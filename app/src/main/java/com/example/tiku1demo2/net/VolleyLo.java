package com.example.tiku1demo2.net;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public interface VolleyLo {
    void onResponse(JSONObject jsonObject);
    void onErrorResponse(VolleyError volleyError);
}
