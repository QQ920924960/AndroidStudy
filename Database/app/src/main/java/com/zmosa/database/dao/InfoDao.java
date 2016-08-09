package com.zmosa.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zmosa.database.MySqliteOpenHepler;
import com.zmosa.database.bean.InfoBean;

/**
 * Created by xmc06 on 16/8/5.
 */
public class InfoDao {

    private MySqliteOpenHepler mySqliteOpenHepler;
    // 重写构造方法
    public InfoDao(Context context) {
        // 创建一个帮助类对象
        mySqliteOpenHepler = new MySqliteOpenHepler(context);
    }

    public boolean add(InfoBean infoBean){
        // 初始化数据库的创建【这句话不能提取出去】
        SQLiteDatabase database = mySqliteOpenHepler.getReadableDatabase();
        // 用map封装的对象来存放值
        ContentValues values = new ContentValues();
        values.put("name", infoBean.name);
        values.put("phone", infoBean.phone);
        // table：表名；nullColumnHack：可以为空，表示添加一个空行；values：数据一行的值
        long result = database.insert("info", null, values);
        // 关闭数据库对象
        database.close();

        if (result != -1) {
            return true;
        } else {
            return false;
        }
    }

    public void del(String name){
        // 初始化数据库的创建【这句话不能提取出去】
        SQLiteDatabase database = mySqliteOpenHepler.getReadableDatabase();
        // 执行删除操作
        int result = database.delete("info", "name=?", new String[]{name});
        // 关闭数据库对象
        database.close();
    }

    public void update(InfoBean infoBean){
        // 初始化数据库的创建【这句话不能提取出去】
        SQLiteDatabase database = mySqliteOpenHepler.getReadableDatabase();
        // 执行更新操作
        ContentValues values = new ContentValues();
        values.put("phone", infoBean.phone);
        int result = database.update("info", values, "name=?", new String[]{infoBean.name});
        // 关闭数据库对象
        database.close();
    }

    public void query(String name){
        // 初始化数据库的创建【这句话不能提取出去】
        SQLiteDatabase database = mySqliteOpenHepler.getReadableDatabase();
        // 执行查询操作
        Cursor cursor = database.query("info", new String[]{"_id, name, phone"}, "name=?", new String[]{name}, null, null, "_id desc");
        if (cursor != null && cursor.getCount() > 0) { // 判断cursor中是否存在数据
            while (cursor.moveToNext()) { // 游标能否定位到下一行
                // 获取数据
                int id = cursor.getInt(0);
                String nameStr = cursor.getString(1);
                String phoneStr = cursor.getString(2);
                System.out.println("id:" + id + ", name:" + name + ", phone:" + phoneStr);
            }
            cursor.close();
        }
        // 关闭数据库对象
        database.close();
    }
}
