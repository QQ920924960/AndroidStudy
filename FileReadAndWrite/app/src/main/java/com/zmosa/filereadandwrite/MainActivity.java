package com.zmosa.filereadandwrite;

import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.zmosa.filereadandwrite.domain.Sms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Sms> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMessages();
    }

//    private String getSDCardSize(){
//        File path = Environment.getExternalStorageDirectory();
//        StatFs stat = new StatFs(path.getPath());
//        @SuppressWarnings("deprecation")
//        long blockSize = stat.getBlockSize();
//        long totalBlocks = stat.getBlockCount();
//        long availableBlocks = stat.getAvailableBlocks();
//
//        return formatSize(availableBlocks * blockSize);
//    }
//
//    private String formatSize(long size){
//        return Formatter.formatFileSize(this,size);
//    }

    // 点击登录按钮
    public void login(View view){

        click(view);
//        // 获取用户输入的账号和密码
//        EditText name_et = (EditText)findViewById(R.id.et_name);
//        EditText pass_et = (EditText)findViewById(R.id.et_pass);
//
//        String name = name_et.getText().toString();
//        String pass = pass_et.getText().toString();
//
//        // 获取选框组件
//        CheckBox checkBox = (CheckBox)findViewById(R.id.cb);
//        if (checkBox.isChecked()){
////            saveAccount(name, pass);
//            loadAccount();
//        }
//
//
//        // 弹出土司提示框
//        Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();
    }

    public void saveAccount(String name, String pass){
//        File file = new File("data/data/com.zmosa.filereadandwrite/info.txt");
//        File file = new File(getCacheDir(), "info.txt");
        // 获得sd卡的真实路径
        File file = new File(Environment.getExternalStorageDirectory(), "info.txt");
//        File file = new File("sdcard/info.txt");
        // 获得扩展存储设备的状态
        System.out.println("---"+Environment.getExternalStorageState()+"----");
        System.out.println("-------"+file+"------");
        try{
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write((name + "##" + pass).getBytes());
            outputStream.close();
            System.out.println("存储成功!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadAccount(){
//        File file = new File(getFilesDir(), "/info.txt");
        // 获得sd卡的真实路径
        File file = new File(Environment.getExternalStorageDirectory(), "info.txt");
        if (file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                // 把字节流转换成字符流
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String accountStr = bufferedReader.readLine();
                String[] info = accountStr.split("##");
                fileInputStream.close();

                EditText name_et = (EditText)findViewById(R.id.et_name);
                EditText pass_et = (EditText)findViewById(R.id.et_pass);
                name_et.setText(info[0]);
                pass_et.setText(info[1]);

                System.out.println("读取成功,数组的长度为：" + info.length);
                System.out.println("---" + info[0] + ":" + info[1] + "----");

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }




    //------------------------------
    public void createMessages(){
        // 创建10条虚拟的短信
        messages = new ArrayList<Sms>();
        for (int i = 0; i < 10; i++){
            Sms sms = new Sms("第" + i + "条短信", System.currentTimeMillis() + "", "1", i+i+i+"");
            messages.add(sms);
        }
    }

    public void click(View view){
        File file = new File(Environment.getExternalStorageDirectory(), "backup.xml");
        System.out.println("----"+file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>");
            stringBuffer.append("<message>");
            for (Sms sms : messages) {
                stringBuffer.append("<sms>");
                stringBuffer.append("<body>");
                stringBuffer.append(sms.getBody());
                stringBuffer.append("</body>");
                stringBuffer.append("<date>");
                stringBuffer.append(sms.getDate());
                stringBuffer.append("</date>");
                stringBuffer.append("<address>");
                stringBuffer.append(sms.getAddress());
                stringBuffer.append("</address>");
                stringBuffer.append("<type>");
                stringBuffer.append(sms.getType());
                stringBuffer.append("</type>");
                stringBuffer.append("</sms>");
            }
            stringBuffer.append("</message>");
            fileOutputStream.write(stringBuffer.toString().getBytes());
            fileOutputStream.close();
            System.out.println("短信备份成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
