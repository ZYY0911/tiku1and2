package com.example.tiku1demo2.dialog;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.Interface.czData;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.ZdglInfor;
import com.example.tiku1demo2.net.VolleyLo;
import com.example.tiku1demo2.net.VolleyTo;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by 张家宝 on 2019/7/14.
 */
@SuppressLint("ValidFragment")
public class Zhgldialog extends DialogFragment {
    private TextView mCp;
    private EditText mJe;
    private Button mCz;
    private Button mclose;
    private String Cp;
    private Context context;
    private VolleyTo volleyTo;
    private String jine;
    private String chepaihao;
    private czData data;
    private ContentValues values;
    private String time;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.b_zhczdialog,container);
    }
    public Zhgldialog(String cp, Context context) {
        this. Cp = cp;
        setChepaihao(Cp);

        this.context=context;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
       initData();
        initListener();
    }
    private void initData() {
        mCp.setText(Cp);
    }
    private void initListener() {

        mJe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String jine=mJe.getText().toString();
                if (jine.startsWith("0")){
                    mJe.setText("");
                    Toast.makeText(context, "请输入1-999之间的数字", Toast.LENGTH_SHORT).show();
                }
                if (jine.length()>3){
                    Log.d("vvvvvvvvvvv", "afterTextChanged: ");
                    mJe.setText(jine.substring(0,3));
                    mJe.setSelection(3);
                    Toast.makeText(context, "输入的金额不能大于三位数字", Toast.LENGTH_SHORT).show();
                }
            }
        });




        mCz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] bodys=chepaihao.split("  ");
                final String je=mJe.getText().toString();
                Log.d("bbbbbb", bodys[0]);
                for(int i=0;i<bodys.length;i++){
                    volleyTo=new VolleyTo();
                    final int finalI=i;
                    final int finalI2 = i;
                    Log.d("gggggggg", chepaihao.length()+"");
                    final int finalI3 = i;
                    volleyTo.setUrl("set_balance").setJsonObject("UserName","user1").setJsonObject("plate",bodys[i]).setJsonObject("balance",je).setVolleyLo(new VolleyLo() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            Log.d("tttt","车号"+bodys[finalI2]+"金额"+je);
                            if (jsonObject.has("RESULT")){
                                try {

                                    String result=jsonObject.getString("RESULT");
                                    if (result.equals("S")){
                                        data.czData();
                                        setJine(je);
                                        Date date=new Date();
                                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                        time=sdf.format(date);
                                        String carnumber=bodys[finalI3].substring(6);
                                        AppClient.getList().add(new ZdglInfor(carnumber,je,"admin",time));
                                    }else {
                                        Toast.makeText(context, "充值失败", Toast.LENGTH_SHORT).show();
                                        dismiss();
                                        return;
                                    }
                                } catch (JSONException e) {

                                    e.printStackTrace();
                                }
                            }

                            if(finalI==bodys.length-1){
                               dismiss();

                            }
                        }

                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Log.d("haha", volleyError.toString());
                        }
                    }).start();
                    volleyTo=null;
                }
                Toast.makeText(context,"充值成功", Toast.LENGTH_SHORT).show();
            }
        });
        mclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
    }

    private void initview() {
        mCp=getView().findViewById(R.id.chepaihao);
        mCz=getView().findViewById(R.id.bt_chongzhi);
        mclose=getView().findViewById(R.id.bt_quxiao);
        mJe=getView().findViewById(R.id.jine);

    }
    public String getJine() {
        return jine;
    }

    public void setJine(String jine) {
        this.jine = jine;
    }

    public String getChepaihao() {
        return chepaihao;
    }

    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao;
    }

    public void setData(czData data){

        this.data=data;
    }
}
