package com.itheima.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);
	}

	/**
	 * ��ѯȫ����¼��ʾ��listview
	 * 
	 * @param view
	 */
	public void query(View view) {
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.itheima.db/info");
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		Cursor cursor = resolver.query(uri, new String[] { "_id", "name" },
				null, null, null);
		while (cursor.moveToNext()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("_id", cursor.getString(0));
			map.put("name", cursor.getString(1));
			data.add(map);
		}
		cursor.close();
		lv.setAdapter(new SimpleAdapter(this, data, R.layout.item,
				new String[] { "_id", "name" }, new int[] { R.id.tv_id,
						R.id.tv_name }));
	}

	/**
	 * ���һ����¼
	 * 
	 * @param view
	 */
	public void add(View view) {
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.itheima.db/info");
		ContentValues values = new ContentValues();
		Random random = new Random();
		values.put("name", "����" + random.nextFloat());
		Uri newuri = resolver.insert(uri, values);
		System.out.println(newuri.toString());
	}

	public void delete(View view) {
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.itheima.db/info");
		int count = resolver.delete(uri, "name=?", new String[] { "����98" });
		Toast.makeText(this, "�ɹ�ɾ����" + count + "��", 0).show();
	}

	public void update(View view) {
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.itheima.db/info");
		ContentValues values = new ContentValues();
		values.put("name", "����");
		int count = resolver.update(uri, values, "name=?",
				new String[] { "����97" });
		Toast.makeText(this, "�ɹ�������" + count + "��", 0).show();
	}
}
