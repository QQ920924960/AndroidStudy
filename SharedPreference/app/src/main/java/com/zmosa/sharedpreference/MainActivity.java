package com.zmosa.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        saveInfo();
        readSharedPreference();
    }

    public void saveInfo(){
        EditText editText_name = (EditText)findViewById(R.id.et_name);
        EditText editText_pass = (EditText)findViewById(R.id.et_pass);

        String name = editText_name.getText().toString();
        String pass = editText_pass.getText().toString();

        // 获取SharedPreference对象
        SharedPreferences sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
        // 得到编辑器
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("pass", pass);
        editor.commit();
    }

    public void readSharedPreference(){
        // 获取SharedPreference对象
        SharedPreferences sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
        // 得到sharedPreferences的内容
        String name = sharedPreferences.getString("name", "");
        String pass = sharedPreferences.getString("pass", "");
        System.out.println("用户名：" + name + ",密码：" + pass);
    }
}
