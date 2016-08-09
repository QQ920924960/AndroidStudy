package com.zmosa.listview1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = this;
        // 1.找到控件
        ListView listView1 = (ListView)findViewById(R.id.listView1);
        ListView listView2 = (ListView)findViewById(R.id.listView2);
        ListView listView3 = (ListView)findViewById(R.id.listView3);
        // 创建Adapter给ListView
        TestAdapter adapter = new TestAdapter();
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter);
        listView3.setAdapter(adapter);
    }

    class TestAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = null;
            if (convertView != null) {
                textView = (TextView)convertView;
            } else {
                textView = new TextView(myContext);
            }

            Random random = new Random();
            int number = random.nextInt(100);
            if (number < 20) {
                textView.setTextColor(Color.parseColor("#ff00ff"));
                textView.setText("桃");
            } else if (number < 40) {
                textView.setTextColor(Color.YELLOW);
                textView.setText("杏");
            } else if (number < 60) {
                textView.setTextColor(Color.GREEN);
                textView.setText("梨");
            } else if (number < 80) {
                textView.setTextColor(Color.RED);
                textView.setText("枣");
            } else {
                textView.setTextColor(Color.parseColor("#666666"));
                textView.setText("瓜");
            }
            textView.setTextSize(25);
            return textView;
        }
    }
}
