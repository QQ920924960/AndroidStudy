package com.zmosa.newsdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zmosa.newsdemo.R;
import com.zmosa.newsdemo.bean.NewsBean;

import java.util.ArrayList;

/**
 * Created by xmc06 on 16/8/6.
 */
public class NewsAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<NewsBean> list;

    public NewsAdapter(Context context, ArrayList<NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView != null) {
            view = convertView;
        } else {
            // 将一个布局文件转换成一个view对象
            // context:上下文；resource：要转换成view对象的layout的id；root：将layout用root（ViewGroup）包一层作为getView的返回值，一般传null
            view = view.inflate(context, R.layout.item_news, null);
        }
        // 获取view上面的子控件对象
        ImageView item_img_icon = (ImageView)view.findViewById(R.id.item_img_icon);
        TextView item_textview_title = (TextView)view.findViewById(R.id.item_textview_title);
        TextView item_textview_desc = (TextView)view.findViewById(R.id.item_textview_desc);
        // 获取position条目对应的list集合中的新闻数据【Bean对象】
        NewsBean newsBean = list.get(position);
        // 给子控件设置数据
        item_img_icon.setImageDrawable(newsBean.icon);
        item_textview_title.setText(newsBean.title);
        item_textview_desc.setText(newsBean.desc);

        return view;
    }


}
