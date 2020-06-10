package com.example.tiku1demo2.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tiku1demo2.R;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class AYhdlActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_yhdl_layout);
        final EditText yhm=findViewById(R.id.yh_yh);
        final EditText mima=findViewById(R.id.yh_mima);
        Button mOK=findViewById(R.id.yh_dl);
        mOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yh=yhm.getText().toString().trim();
                String mi=mima.getText().toString().trim();
                if (yh.equals("admin")&&mi.equals("admin")){
                    Toast.makeText(AYhdlActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(AYhdlActivity.this,ADzbcActivity.class));
                }else {
                    showAlertDialog("提示","请输入正确的用户名和密码");
                }
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
}
