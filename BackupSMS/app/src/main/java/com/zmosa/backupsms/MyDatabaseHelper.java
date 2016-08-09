package com.zmosa.backupsms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by xmc06 on 16/7/29.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "MyDatabaseHelper";
    public static final String NAME = "test.db";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDatabaseHelper(Context context, int version) {
        super(context, NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 引导db
        bootstrapDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "Upgrading DB from version: " + oldVersion + " to " + newVersion);
        if (oldVersion < 8) {
            // 如果版本太小，就直接删除，然后创建
            dropTables(db);
            onCreate(db);
            return;
        }

        if (oldVersion == 8) {
            upgradeToVersion9(db);
            oldVersion += 1;
        }

        if (oldVersion == 9) {
            upgradeToVersion10(db);
            oldVersion += 1;
        }

        // 这是一种逐级更新的方式
        Log.v("do upgrade", "我更新了....");
    }

    private void bootstrapDB(SQLiteDatabase db){
        Log.i(TAG, "Bootstrapping database");
        db.execSQL("CREATE TABLE person (personId, integer primary key autoincrement, " +
                "name varchar(20), age integer)");
    }

    private void dropTables(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS person;");
    }

    static void upgradeToVersion9(SQLiteDatabase db) {
        db.execSQL("CREATE INDEX idx_person_name_gender ON person (name, gender);");
    }

    static void upgradeToVersion10(SQLiteDatabase db) {
        db.execSQL("ALTER TABLE person ADD COLUMN gender INTEGER NOT NULL DEFAULT 1;");
    }
}
