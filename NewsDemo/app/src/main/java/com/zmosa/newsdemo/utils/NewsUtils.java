package com.zmosa.newsdemo.utils;

import android.content.Context;

import com.zmosa.newsdemo.R;
import com.zmosa.newsdemo.bean.NewsBean;

import java.util.ArrayList;

/**
 * Created by xmc06 on 16/8/6.
 */
public class NewsUtils {

    public static ArrayList<NewsBean> getAllNews(Context context) {
        ArrayList<NewsBean> arrayList = new ArrayList<NewsBean>();

        for (int index = 0; index < 100; index++) {
            NewsBean newsBean0 = new NewsBean();
            newsBean0.title = "这是一个标题0";
            newsBean0.desc = "这是一条内容0";
            newsBean0.icon = context.getResources().getDrawable(R.drawable.wechat);
            newsBean0.news_url = "http://www.baidu.com";
            arrayList.add(newsBean0);

            NewsBean newsBean1 = new NewsBean();
            newsBean1.title = "这是一个标题1";
            newsBean1.desc = "这是一条内容1";
            newsBean1.icon = context.getResources().getDrawable(R.drawable.wechat);
            newsBean1.news_url = "http://www.163.com";
            arrayList.add(newsBean1);

            NewsBean newsBean2 = new NewsBean();
            newsBean2.title = "这是一个标题2";
            newsBean2.desc = "这是一条内容2";
            newsBean2.icon = context.getResources().getDrawable(R.drawable.wechat);
            newsBean2.news_url = "http://www.tencent.com";
            arrayList.add(newsBean2);

            NewsBean newsBean3 = new NewsBean();
            newsBean3.title = "这是一个标题3";
            newsBean3.desc = "这是一条内容3";
            newsBean3.icon = context.getResources().getDrawable(R.drawable.wechat);
            newsBean3.news_url = "http://www.zmosa.com";
            arrayList.add(newsBean3);
        }

        return arrayList;
    }


}
