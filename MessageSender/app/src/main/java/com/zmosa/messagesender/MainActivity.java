package com.zmosa.messagesender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "LOGCAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 详细的[verbose]
        Log.v(TAG, "好好干，Frank");
        // 信息级别的【info】
        Log.i(TAG, "好好干，Frank");
        // 调试级别[debug]
        Log.d(TAG, "好好干，Frank");
        // 警告级别【warning】
        Log.w(TAG, "好好干，Frank");
        // 错误级别【error】
        Log.e(TAG, "好好干，Frank");
    }

    public void send(View v){
        EditText phoneEditText = (EditText)findViewById(R.id.editTextPhone);
        EditText contentEditText = (EditText)findViewById(R.id.editTextContent);
        String phone = phoneEditText.getText().toString();
        String content = contentEditText.getText().toString();

        SmsManager smsMgr = SmsManager.getDefault();
        smsMgr.sendTextMessage(phone, null, content, null, null);
    }
}
