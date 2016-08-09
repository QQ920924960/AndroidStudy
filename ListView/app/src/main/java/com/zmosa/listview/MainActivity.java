package com.zmosa.listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Context myContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContent = this;

        // 找到listView
        ListView listView = (ListView)findViewById(R.id.listView1);
        // 创建一个Adapter对象
        MyListAdapter listAdapter = new MyListAdapter();
        // 将Adapter设置给ListView
        listView.setAdapter(listAdapter);
    }

    class MyListAdapter extends BaseAdapter {

        private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 一共要显示多少个条目
        @Override
        public int getCount() {
            return 20;
        }

        // 根据position获取listView条目上对应的数据，该方法不影响数据的展示，可以先不实现
        @Override
        public Object getItem(int position) {
            return null;
        }

        // 用于获取第position行的id
        @Override
        public long getItemId(int position) {
            return 0;
        }

        // 返回一个view对象作为条目上的内容展示,该方法必须实现【屏幕上每显示一个条目，这个方法就会被调用一次】
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = null;
            if (convertView != null) {
                textView = (TextView)convertView;
            } else {
                textView = new TextView(myContent);
            }
            textView.setText("position:" + position);
            textView.setTextSize(40);
            map.put(textView.hashCode(), 1);
            System.out.println("当前一共有" + map.size() + "个ListView对象");
            return textView;
        }
    }
}
