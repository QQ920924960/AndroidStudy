package com.zmosa.newsdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zmosa.newsdemo.adapter.NewsAdapter;
import com.zmosa.newsdemo.bean.NewsBean;
import com.zmosa.newsdemo.utils.NewsUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = this;
        // 找到控件
        ListView listView = (ListView)findViewById(R.id.listview1);
        // 获取新闻数据用list封装
        ArrayList<NewsBean> news = NewsUtils.getAllNews(myContext);
        // 创建一个Adapter设置给ListView
        NewsAdapter newsAdapter = new NewsAdapter(myContext, news);
        listView.setAdapter(newsAdapter);
        // 设置ListView条目的点击事件
        listView.setOnItemClickListener(this);
    }

    // ListView的条目点击时会调用该方法
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsBean bean = (NewsBean)parent.getItemAtPosition(position);
        String url = bean.news_url;
        // 根据获取的url进行界面跳转
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
