package com.zmosa.accesspermissions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view){
        try {
            FileOutputStream fileOutputStream = openFileOutput("info1.txt", MODE_PRIVATE);
            fileOutputStream.write("私有模式".getBytes());
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void click2(View view){
        try {
            FileOutputStream fileOutputStream = openFileOutput("info2.txt", MODE_APPEND);
            fileOutputStream.write("追加模式".getBytes());
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void click3(View view){
        try {
            FileOutputStream fileOutputStream = openFileOutput("info3.txt", MODE_WORLD_READABLE);
            fileOutputStream.write("全局可读模式".getBytes());
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void click4(View view){
        try {
            FileOutputStream fileOutputStream = openFileOutput("info4.txt", MODE_WORLD_WRITEABLE);
            fileOutputStream.write("全局可写模式".getBytes());
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
