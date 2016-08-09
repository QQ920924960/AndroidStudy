package com.zmosa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zmosa.database.bean.InfoBean;
import com.zmosa.database.dao.InfoDao;

public class MainActivity extends AppCompatActivity {

    private Context myContext;
    private InfoDao infoDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = this;
        infoDao = new InfoDao(myContext);
    }

    public void addBtnClicked(View view){
        System.out.println("添加");

        InfoBean infoBean0 = new InfoBean();
        infoBean0.name = "张三";
        infoBean0.phone = "13237020249";
        infoDao.add(infoBean0);

        InfoBean infoBean1 = new InfoBean();
        infoBean1.name = "李四";
        infoBean1.phone = "18589097281";
        infoDao.add(infoBean1);

        InfoBean infoBean2 = new InfoBean();
        infoBean2.name = "frank";
        infoBean2.phone = "13237020258";
        infoDao.add(infoBean2);
    }

    public void delBtnClicked(View view){
        System.out.println("删除");

        infoDao.del("李四");
    }

    public void updateBtnClicked(View view){
        System.out.println("更新");

        InfoBean infoBean = new InfoBean();
        infoBean.name = "frank";
        infoBean.phone = "110";
        infoDao.add(infoBean);
        infoDao.update(infoBean);
    }

    public void queryBtnClicked(View view){
        System.out.println("查询");

        infoDao.query("frank");
    }
}
