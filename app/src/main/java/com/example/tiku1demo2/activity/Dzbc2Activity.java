package com.example.tiku1demo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiku1demo2.R;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class Dzbc2Activity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dzbc2_layout);
        ImageView dt=findViewById(R.id.dz2_dt);
        final TextView xl=findViewById(R.id.dz2_lx);
        TextView lc=findViewById(R.id.dz2_lc);
        TextView pj=findViewById(R.id.dz2_pj);
        Button ok=findViewById(R.id.dz2_ok);
        Intent intent=getIntent();
        if (intent.getIntExtra("index",0)==0){
            dt.setImageResource(R.drawable.ditu);
        }else {
            dt.setImageResource(R.drawable.ditu2);
        }
        xl.setText(intent.getStringExtra("xl"));
        lc.setText("里程："+intent.getStringExtra("lc")+".0km");
        pj.setText("票价：Y"+intent.getStringExtra("pj")+".0");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Dzbc2Activity.this,Dzbc3Activity.class);
                intent1.putExtra("lx",xl.getText().toString().trim());
                startActivity(intent1);
            }
        });
        addActivity(this);
        ImageView change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
