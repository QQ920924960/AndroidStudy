package com.zmosa.otheradapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public String[] category = {"Android", "ios", "javaEE", "c#", "php"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 找到view
        ListView listview_arrayAdapter = (ListView) findViewById(R.id.listView_arrayAdapter);
        ListView listView_simpleAdapter = (ListView) findViewById(R.id.listView_simpleAdapter);

        // 创建一个ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_listview_layout, R.id.item_textview_category, category);
        listview_arrayAdapter.setAdapter(arrayAdapter);



        // 创建一个SimpleAdapter
        ArrayList<Map<String, String>> arrayList = new ArrayList<Map<String, String>>();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("category", "Android");
        arrayList.add(hashMap);

        HashMap<String, String> hashMap1 = new HashMap<String, String>();
        hashMap1.put("category", "ios");
        arrayList.add(hashMap1);

        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        hashMap2.put("category", "javaEE");
        arrayList.add(hashMap2);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.item_listview_layout, new String[]{"category"}, new int[]{R.id.item_textview_category});
        listView_simpleAdapter.setAdapter(simpleAdapter);
    }
}
