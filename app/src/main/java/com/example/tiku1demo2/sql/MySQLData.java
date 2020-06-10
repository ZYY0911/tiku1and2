package com.example.tiku1demo2.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class MySQLData extends SQLiteOpenHelper {

    public static final String DATA_SQL="create table bc("
            +"id integer primary key autoincrement,"
            +"lx text,"
            +"xm text,"
            +"sj text,"
            +"rq text,"
            +"sc text)";

    public MySQLData(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATA_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
