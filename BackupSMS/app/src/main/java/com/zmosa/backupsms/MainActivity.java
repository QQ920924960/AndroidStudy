package com.zmosa.backupsms;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void smsBackup(View view) {
        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://sms/");
        Cursor cursor = resolver.query(uri, new String[]{"address", "body", "type", "date"}, null, null, null);
        while (cursor.moveToNext()) {
            String address = cursor.getString(0);
            String body= cursor.getString(1);
            String type = cursor.getString(2);
            String date = cursor.getString(3);
            System.out.println("address:" + address);
            System.out.println("body:" + body);
            System.out.println("type:" + type); // 1接收的短信，2发送的短信
            System.out.println("date:" + date);
        }
    }
}
