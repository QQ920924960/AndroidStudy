package com.zmosa.createxml;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;

import com.zmosa.createxml.domain.Sms;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Sms> messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        createMessages();
    }

    public void createMessages(){
        // 创建10条虚拟的短信
        messages = new ArrayList<Sms>();
        for (int i = 0; i < 10; i++){
            Sms sms = new Sms("第" + i + "条短信", System.currentTimeMillis() + "", "1", ""+i+i+i);
            messages.add(sms);
        }
    }

    public void click(View view){
        File file = new File(Environment.getExternalStorageDirectory(), "backup.xml");
        System.out.println("----"+file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 获取xml序列化器
            XmlSerializer xmlSerializer = Xml.newSerializer();
            xmlSerializer.setOutput(fileOutputStream, "utf-8");
            // 生成xml头
            xmlSerializer.startDocument("utf-8", true);
            // 生成xml根节点
            xmlSerializer.startTag(null, "messages");
            for (Sms sms : messages) {
                xmlSerializer.startTag(null, "sms");
                xmlSerializer.startTag(null, "body");
                xmlSerializer.text(sms.getBody());
                xmlSerializer.endTag(null, "body");
                xmlSerializer.startTag(null, "date");
                xmlSerializer.text(sms.getDate());
                xmlSerializer.endTag(null, "date");
                xmlSerializer.startTag(null, "address");
                xmlSerializer.text(sms.getAddress());
                xmlSerializer.endTag(null, "address");
                xmlSerializer.startTag(null, "type");
                xmlSerializer.text(sms.getType());
                xmlSerializer.endTag(null, "type");
                xmlSerializer.endTag(null, "sms");
            }
            xmlSerializer.endTag(null, "messages");
            // 生成xml尾
            xmlSerializer.endDocument();

            fileOutputStream.close();
            System.out.println("短信备份成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
