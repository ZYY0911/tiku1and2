package com.example.tiku1demo2.activity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiku1demo2.R;
import com.example.tiku1demo2.sql.MySQLData;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class Dzbc5Activity extends BaseActivity {

    private TextView mXm;
    private TextView mSj;
    private TextView mDd;
    private TextView mRq;
    private TextView mLx;
    private Button mOk;
    private MySQLData mySQLData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dzbc5_layout);
        mySQLData=new MySQLData(this,"dingzhi.db",null,1);
        initView();
        initData();
        initLister();
        addActivity(this);
    }

    private void initLister() {
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=mySQLData.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("lx",getIntent().getStringExtra("lx"));
                values.put("xm",getIntent().getStringExtra("xm"));
                values.put("sj",getIntent().getStringExtra("sj"));
                values.put("rq",getIntent().getStringExtra("rq"));
                values.put("sc",getIntent().getStringExtra("dd"));
                db.insert("bc",null,values);
                showAlertDialog("提示","提交成功");
            }
        });
    }

    private void showAlertDialog(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(Dzbc5Activity.this,ADzbcActivity.class);
                startActivity(intent);
                finishAll();
            }
        });
        builder.show();
    }

    private void initData() {
        mXm.setText(getIntent().getStringExtra("xm"));
        mSj.setText(getIntent().getStringExtra("sj"));
        mDd.setText(getIntent().getStringExtra("dd"));
        mRq.setText(getIntent().getStringExtra("rq"));
        mLx.setText(getIntent().getStringExtra("lx"));
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        mXm=findViewById(R.id.dz5_xm);
        mSj=findViewById(R.id.dz5_sj);
        mDd=findViewById(R.id.dz5_dd);
        mRq=findViewById(R.id.dz5_rq);
        mLx=findViewById(R.id.dz5_lx);
        mOk=findViewById(R.id.dz5_ok);
    }
}
