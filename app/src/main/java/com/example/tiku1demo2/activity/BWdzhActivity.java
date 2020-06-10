package com.example.tiku1demo2.activity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.WdzhInfor;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BWdzhActivity extends AppCompatActivity {
private EditText et_jine;
private TextView yue;
private Spinner spinner;
private Button chaxun,chongzhi;
private String carnumber="1";
private String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_wdzh);
        TextView content=findViewById(R.id.content);
        content.setText("我的账户");
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initView();
        setListener();
        setVolley();

    }

    private void setListener() {

        chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BWdzhActivity.this, BZdglActivity.class));
            }
        });
        chongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd hh:mm");
                Date date=new Date(System.currentTimeMillis());
                time=format.format(date);
                if (et_jine.getText().toString().startsWith("0")){
                    Toast.makeText(BWdzhActivity.this, "请输入1-999之间的金额", Toast.LENGTH_SHORT).show();
                    return;
                }
                final AlertDialog.Builder builder=new AlertDialog.Builder(BWdzhActivity.this);
                builder.setMessage("您确定要在"+time+"给"+carnumber+"号小车充值"+et_jine.getText().toString()+"元?");
                builder.setTitle("提示");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setVolley2();

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences sharedPreferences=getSharedPreferences("tanchu",0);
                        boolean tanchu=sharedPreferences.getBoolean("tanchu",true);
                        if (tanchu){
                            AlertDialog.Builder builder1=new AlertDialog.Builder(BWdzhActivity.this);
                            View view= LayoutInflater.from(BWdzhActivity.this).inflate(R.layout.dialog_chongzhi2,null,false);
                            builder1.setView(view);
                            final CheckBox tanchu1=view.findViewById(R.id.check);
                            Button queding=view.findViewById(R.id.queren);
                            Button quxiao=view.findViewById(R.id.quxiao);
                            final Dialog dialog=builder1.create();
                            dialog.show();
                            queding.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (tanchu1.isChecked()){
                                        SharedPreferences.Editor editor=getSharedPreferences("tanchu",0).edit();
                                        editor.putBoolean("tanchu",false);
                                        editor.apply();
                                    }
                                    dialog.dismiss();
                                }
                            });
                            quxiao.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });

                        }
                    }
                });
                builder.show();
            }
        });
    }

    private void setVolley2() {
        VolleyTo volleyTo=new VolleyTo();
        volleyTo.setUrl("set_balance").setJsonObject("UserName","user1").setJsonObject("plate","鲁A1000"+carnumber).setJsonObject("balance",et_jine.getText().toString()).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    if (  jsonObject.getString("RESULT").equals("S")){
                        Toast.makeText(BWdzhActivity.this, "充值成功", Toast.LENGTH_SHORT).show();
                        setVolley();
                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd  hh:mm");
                        Date date=new Date(System.currentTimeMillis());
                        AppClient.getMlist().add(new WdzhInfor(carnumber,et_jine.getText().toString(),"admin",dateFormat.format(date)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void initView() {
        et_jine = findViewById(R.id.jine);
        yue = findViewById(R.id.yue);
        spinner = findViewById(R.id.spinner);
        chaxun = findViewById(R.id.chaxun);
        chongzhi = findViewById(R.id.chonzghi);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                carnumber= adapterView.getItemAtPosition(i).toString();
                switch (adapterView.getId()){
                    case R.id.spinner:
                        setVolley();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        et_jine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String jine=et_jine.getText().toString();
                if (jine.startsWith("0")){
                    et_jine.setText("");
                    Toast.makeText(BWdzhActivity.this, "请输入1-999之间的整数", Toast.LENGTH_SHORT).show();
                }
                if (jine.length()>3){
                    et_jine.setText(jine.substring(0,3));
                    et_jine.setSelection(3);
                    Toast.makeText(BWdzhActivity.this, "金额不能超过999元", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setVolley() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_balance_b").setJsonObject("UserName", "user1").setJsonObject("number", carnumber).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    yue.setText(jsonObject.getString("balance") + "元");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();


    }
}
