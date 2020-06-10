package com.example.tiku1demo2.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.tiku1demo2.R;
import com.example.tiku1demo2.adapter.DzbcddAdapter;
import com.example.tiku1demo2.bean.Dzbcdd;
import com.example.tiku1demo2.sql.MySQLData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/15 0015.
 */

public class DzbcddActivity extends AppCompatActivity {

    private ListView mListView;
    private List<Dzbcdd> mList;
    private DzbcddAdapter mAdapter;
    private MySQLData mySQLData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dzbcdd_layout);
        initView();
        initData();
    }

    private void initData() {
        mList=new ArrayList<>();
        mySQLData=new MySQLData(this,"dingzhi.db",null,1);
        SQLiteDatabase db=mySQLData.getWritableDatabase();
        Cursor cursor=db.query("bc",null,null,null,null,null,null );
        if (cursor.moveToFirst()){
            Log.i("ccccccccccccccc","aaaa");
            do {
                String lx=cursor.getString(cursor.getColumnIndex("lx"));
                String xm=cursor.getString(cursor.getColumnIndex("xm"));
                String sj=cursor.getString(cursor.getColumnIndex("sj"));
                String rq=cursor.getString(cursor.getColumnIndex("rq"));
                String sc=cursor.getString(cursor.getColumnIndex("sc"));
                mList.add(new Dzbcdd(lx,xm,sj,sc,rq));
            }while (cursor.moveToNext());
        }

        mAdapter=new DzbcddAdapter(this,R.layout.dd_item,mList);
        mListView.setAdapter(mAdapter);
    }

    private void initView() {
        mListView=findViewById(R.id.dzdd_list);
        ImageView fh=findViewById(R.id.change);
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
