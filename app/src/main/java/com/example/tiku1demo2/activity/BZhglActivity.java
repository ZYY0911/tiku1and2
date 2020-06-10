package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.Interface.SetData;
import com.example.tiku1demo2.Interface.czData;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.ZhglAdapter;
import com.example.tiku1demo2.bean.ZhglInfor;
import com.example.tiku1demo2.dialog.Zhgldialog;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BZhglActivity extends AppCompatActivity {
    private ListView lv;
    private TextView pl,cz_record;
    private List<ZhglInfor> mlist;
    private ZhglAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_zhgl);
        TextView content=findViewById(R.id.content);
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        content.setText("账户管理");
        initView();
        setVolley();

        setListener();
    }

    private void initData() {
        adapter.setData(new SetData() {
            @Override
            public void setdata(int position, boolean check, int lx) {
                if (lx==1){
                    ZhglInfor infor=mlist.get(position);
                    infor.setIscheck(check);
                }else {
                    Zhgldialog zhgldialog=new Zhgldialog(mlist.get(position).getCarnumber(),BZhglActivity.this);
                    zhgldialog.show(getFragmentManager(),"aaa");
                    zhgldialog.setData(new czData() {
                        @Override
                        public void czData() {
                            setVolley();
                        }
                    });
                }

            }
        });
    }

    private void setVolley() {
        VolleyTo volleyTo=new VolleyTo();
        volleyTo.setUrl("get_vehicle").setJsonObject("UserName","user1").setmDialog(this).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                   mlist=new ArrayList<>();
                    JSONArray jsonArray= jsonObject.getJSONArray("ROWS_DETAIL");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        int id=  jsonObject1.getInt("id");
                        String name=  jsonObject1.getString("owner");
                        String yue=  jsonObject1.getString("balance");
                        String carnumer= jsonObject1.getString("plate");
                        String pinpai=jsonObject1.getString("brand");
                        mlist.add(new ZhglInfor(id,pinpai,carnumer,name,yue,false, AppClient.getYz()));
                    }
                    adapter=new ZhglAdapter(BZhglActivity.this,0,mlist);
                    lv.setAdapter(adapter);
                    initData();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void setListener() {
        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cp="";
                for (int i=0;i<mlist.size();i++){
                    ZhglInfor infor=mlist.get(i);
                    if (infor.isIscheck()){
                        if (cp.equals("")){
                            cp=infor.getCarnumber();
                        }else {
                            cp+="  "+infor.getCarnumber();
                        }
                    }
                }
                if (cp.equals("")){
                    Toast.makeText(BZhglActivity.this, "请选择账户", Toast.LENGTH_SHORT).show();
                    return;
                }
                Zhgldialog zhgldialog=new Zhgldialog(cp,BZhglActivity.this);
                zhgldialog.show(getFragmentManager(),"bbb");
                zhgldialog.setData(new czData() {
                    @Override
                    public void czData() {
                        setVolley();
                        for (int i=0;i<mlist.size();i++){
                            if (mlist.get(i).isIscheck()){
                                mlist.get(i).setIscheck(false);
                            }
                        }
                    }
                });

            }
        });
        cz_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BZhglActivity.this, BZdgl2Activity.class));
            }
        });

        
    }

    private void initView() {
        lv=findViewById(R.id.lv);
        pl=findViewById(R.id.content2);
        cz_record=findViewById(R.id.content3);
        pl.setText("批量充值");
        cz_record.setText("充值记录");

    }
}
