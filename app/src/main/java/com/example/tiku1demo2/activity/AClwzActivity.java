package com.example.tiku1demo2.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.Clwz;
import com.example.tiku1demo2.bean.Cxjg1;
import com.example.tiku1demo2.bean.Cxjg2;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class AClwzActivity extends AppCompatActivity {

    private EditText mCp;
    private Button mCx;
    private VolleyTo volleyTo;
    private VolleyTo volleyTo2;
    private AppClient mApp;
    private List<Clwz> mList;
    private List<Cxjg1> CxList;
    private List<Cxjg2> CxList2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_clwz_layout);
        initView();
        initData();
        initLister();
        setVolley();
    }

    private void setVolley() {
        volleyTo2=new VolleyTo();
        volleyTo2.setUrl("get_all_car_peccancy").setJsonObject("UserName","user1").setmDialog(this).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                if (jsonObject.has("RESULT")){
                    try {
                        String result=jsonObject.getString("RESULT");
                        if (result.equals("S")){
                            mList=new ArrayList<>();
                            String body=jsonObject.getString("ROWS_DETAIL");
                            JSONArray jsonArray=new JSONArray(body);
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                mList.add(new Clwz(jsonObject1.getInt("id"),jsonObject1.getString("time"),jsonObject1.getString("road"),jsonObject1.getString("message"),jsonObject1.getString("deduct"),jsonObject1.getString("fine")));
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

    private void initLister() {
        mCx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Cp="鲁"+mCp.getText().toString().trim().toUpperCase();
                for (int i=0;i<CxList.size();i++){
                    Cxjg1 cxjg1=CxList.get(i);
                    if (cxjg1.getCp().equals(Cp)){
                        CxList.remove(i);
                        CxList.add(0,cxjg1);
                        startActivity(new Intent(AClwzActivity.this,CxjgActivity.class));
                        finish();
                        return;
                    }
                }
                volleyTo=new VolleyTo();
                volleyTo.setUrl("get_peccancy_plate").setJsonObject("UserName","user1").setJsonObject("plate",Cp).setmDialog(AClwzActivity.this).setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (jsonObject.has("RESULT")){
                            try {
                                String result=jsonObject.getString("RESULT");
                                if (result.equals("S")){
                                    String body=jsonObject.getString("id");
                                    JSONArray jsonArray=new JSONArray(body);
                                    List<Integer> ids=new ArrayList<>();
                                    int wz=0,kf=0,fk=0;
                                    for (int i=0;i<jsonArray.length();i++){
                                        int id=jsonArray.getInt(i);
                                        ids.add(id);
                                        wz++;
                                        for (int j=0;j<mList.size();j++){
                                            Clwz clwz=mList.get(j);
                                            if (clwz.getId()==id){
                                                kf+=Integer.parseInt(clwz.getKf());
                                                fk+=Integer.parseInt(clwz.getFk());
                                                CxList2.add(new Cxjg2(Cp,clwz.getTime(),clwz.getRoad(),clwz.getMessage(),clwz.getKf(),clwz.getFk()));
                                            }
                                        }
                                    }
                                    CxList.add(0,new Cxjg1(Cp,wz+"",kf+"",fk+""));
                                    startActivity(new Intent(AClwzActivity.this,CxjgActivity.class));
                                    finish();
                                }else {
                                    showAlertDialog("提示","没有查询到"+Cp+"车的违章数据！");
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
        });
    }

    private void showAlertDialog(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("确定",null);
        builder.show();
    }

    private void initData() {
        mApp= (AppClient) getApplication();
        CxList=mApp.getCxList();
        CxList2=mApp.getCxList2();
    }

    private void initView() {
        mCp=findViewById(R.id.clwz_cp);
        mCx=findViewById(R.id.clwz_cx);
        final ImageView fh=findViewById(R.id.change);
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
