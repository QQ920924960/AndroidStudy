package com.itheima.db.test;

import com.itheima.db.PersonDBOpenHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

public class TestPersonDB extends AndroidTestCase {
	PersonDBOpenHelper helper;

	@Override
	protected void setUp() throws Exception {
		// 初始化操作
		helper = new PersonDBOpenHelper(getContext());
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// 清理操作
		super.tearDown();
	}

	public void testCreateDB() throws Exception {
		helper.getWritableDatabase();
	}

	public void testAddData() throws Exception {
		SQLiteDatabase db = helper.getWritableDatabase();
		for (int i = 0; i < 100; i++) {
			ContentValues values = new ContentValues();
			values.put("name", "张三"+i);
			db.insert("info", null, values);
		}
		db.close();
	}
}
