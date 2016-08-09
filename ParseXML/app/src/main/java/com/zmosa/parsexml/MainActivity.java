package com.zmosa.parsexml;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<City> citys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        parseXML();
    }

    public void parseXML(){
        // 获取xml解析器
        XmlResourceParser xmlResourceParser = this.getResources().getXml(R.xml.weather);
        try {
            // 获取当前节点的事件类型
            int type = xmlResourceParser.getEventType();
            City city = null;
            while (type != XmlPullParser.END_DOCUMENT) {
                switch (type) {
                    case XmlPullParser.START_TAG:
                        if ("weacher".equals(xmlResourceParser.getName())){
                            citys = new ArrayList<City>();
                        }
                        if ("city".equals(xmlResourceParser.getName())) {
                            city = new City();
                        } else if ("name".equals(xmlResourceParser.getName())) {
                            // 获取下一个节点的文本
                            String name = xmlResourceParser.nextText();
                            // 将文本保存至对象
                            city.setName(name);
                        } else if ("temp".equals(xmlResourceParser.getName())) {
                            String temp = xmlResourceParser.nextText();
                            city.setTemp(temp);
                        } else if ("pm".equals(xmlResourceParser.getName())) {
                            String pm = xmlResourceParser.nextText();
                            city.setPm(pm);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("city".equals(xmlResourceParser.getName())){
                            citys.add(city);
                        }
                        break;
                }
                type = xmlResourceParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (City city : citys) {
            System.out.println(city.toString());
        }
    }
}
