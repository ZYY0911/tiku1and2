package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tiku1demo2.R;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class Dzbc4Activity extends BaseActivity {

    private EditText mXm;
    private EditText mSj;
    private Spinner mSp;
    private Button mOk;
    private String Rq;
    private TextView mLx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dzbc4_layout);
        Rq=getIntent().getStringExtra("rq");
        initView();
        initLister();
        addActivity(this);
    }

    private void initLister() {
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dzbc4Activity.this,Dzbc5Activity.class);
                intent.putExtra("rq",Rq);
                intent.putExtra("xm",mXm.getText().toString().trim());
                intent.putExtra("sj",mSj.getText().toString().trim());
                intent.putExtra("dd",mSp.getSelectedItem().toString().trim());
                intent.putExtra("lx",mLx.getText().toString().trim());
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mXm=findViewById(R.id.dz4_xm);
        mSj=findViewById(R.id.dz4_sj);
        mSp=findViewById(R.id.dz4_sp);
        mOk=findViewById(R.id.dz4_ok);
        mLx=findViewById(R.id.dz4_lx);
        mLx.setText(getIntent().getStringExtra("lx"));
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
