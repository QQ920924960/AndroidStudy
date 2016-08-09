package com.zmosa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xmc06 on 16/8/4.
 */
public class MySqliteOpenHepler extends SQLiteOpenHelper {

    public MySqliteOpenHepler(Context context) {
        // context:上下文； name：数据库文件的名称； factory：用来创建cursor对象，默认为空；version：数据库的版本号，从1开始，如果发生改变，onUpgrade方法将会调用
        super(context, "info.db", null, 1);
    }

    // 数据库第一次创建的时候会调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("执行了创建数据库的操作!");
        db.execSQL("create table info(_id integer primary key autoincrement, name varchar(20), phone varchar(11))");
    }

    // 数据库版本号发生改变才会执行
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println(oldVersion + "升级了" + newVersion);
    }
}
