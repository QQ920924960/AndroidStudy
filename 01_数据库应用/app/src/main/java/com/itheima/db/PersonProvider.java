package com.itheima.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonProvider extends ContentProvider {
	private static final int SUCCESS = 1;
	private PersonDBOpenHelper helper;
	private static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	static {
		mUriMatcher.addURI("com.itheima.db", "info", SUCCESS);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int code = mUriMatcher.match(uri);
		if (code == SUCCESS) {
			SQLiteDatabase db = helper.getWritableDatabase();
			int result = db.delete("info", selection, selectionArgs);
			db.close();
			if(result>0){
			//大吼一声，讲数据库的内容变化了。
			getContext().getContentResolver().notifyChange(uri, null);
			}
			return result;
		}else{
			throw new IllegalArgumentException("uri 不匹配");
		}
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		int code = mUriMatcher.match(uri);
		if (code == SUCCESS) {
			SQLiteDatabase db = helper.getWritableDatabase();
			long id = db.insert("info", null, values);
			db.close();
			//content://com.itheima.db/info/5
			//大吼一声，讲数据库的内容变化了。
			getContext().getContentResolver().notifyChange(uri, null);
			return Uri.parse("content://com.itheima.db/info/"+id);
		}else{
			throw new IllegalArgumentException("uri 不匹配");
		}
	}

	@Override
	public boolean onCreate() {
		helper = new PersonDBOpenHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		int code = mUriMatcher.match(uri);
		if (code == SUCCESS) {
			SQLiteDatabase db = helper.getReadableDatabase();
			Cursor cursor = db.query("info", projection, selection,
					selectionArgs, null, null, sortOrder);
			return cursor;
		}else{
			throw new IllegalArgumentException("uri 不匹配");
		}
	}
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int code = mUriMatcher.match(uri);
		if (code == SUCCESS) {
			SQLiteDatabase db = helper.getWritableDatabase();
			int id = db.update("info", values, selection, selectionArgs);
			db.close();
			if(id>0){
			//大吼一声，讲数据库的内容变化了。
			getContext().getContentResolver().notifyChange(uri, null);
			}
			return id;
		}else{
			throw new IllegalArgumentException("uri 不匹配");
		}
	}
}
