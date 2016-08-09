package com.zmosa.db.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zmosa.db.PersonDBOpenHelper;

import junit.framework.TestCase;

/**
 * Created by xmc06 on 16/7/29.
 */
public class TestPersonDB extends TestCase {

    PersonDBOpenHelper personDBOpenHelper;
    private Context context;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        personDBOpenHelper = new PersonDBOpenHelper(getContext());
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreateDB() throws Exception {
        personDBOpenHelper.getWritableDatabase();
    }

    public void addData() throws Exception {
        SQLiteDatabase database = personDBOpenHelper.getWritableDatabase();
        for (int i = 0; i < 100; i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", "张三" + i);
            database.insert("info", null, contentValues);
        }
        database.close();
    }
}
