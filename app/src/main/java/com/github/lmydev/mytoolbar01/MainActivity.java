package com.github.lmydev.mytoolbar01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    int mYear, mMonth, mDay;
    final int DATE_DIALOG = 1;

    private ListView  mListView;
    List<String> list=new ArrayList<>();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,initData()));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, "onItemClick: "+position);
                Intent intent_main=null;
                switch(position){
                    case 0:
                        intent_main=new Intent(MainActivity.this,WheelActivity.class);
                        break;
                    case 1:
                        intent_main=new Intent(MainActivity.this,ToolbarFragActivity.class);
                        break;
                    case 2:
                        intent_main=new Intent(MainActivity.this,ViewActivity.class);
                        break;
                    case 3:
                        intent_main=new Intent(MainActivity.this, DateActivity.class);
                        break;
                    case 4:
                        intent_main=new Intent(MainActivity.this, EditActivity.class);
                        break;
                    case 5:
                        intent_main=new Intent(MainActivity.this, OkHttpActivity.class);
                        break;
                    case 6:
                        intent_main=new Intent(MainActivity.this, Wheel02Activity.class);
                        break;
                      }
                     startActivity(intent_main);

                 }
           });
    }



    public List<String> initData(){
        list.add("简单月份选择");
        list.add("向Fragment传值");
        list.add("百分比选择");
        list.add("计算年月日时间差");
        list.add("监听文字输入");
        list.add("原生日期选择");
        list.add("   ......");
        return list;
    }

    public void initView(){
        mListView=(ListView)findViewById(R.id.listview);
    }


    /**
     * 根据图片的url路径获得Bitmap对象
     * @param url
     * @return
     */
    private Bitmap decodeUriAsBitmapFromNet(String url) {
        URL fileUrl = null;
        Bitmap bitmap = null;

        try {
            fileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            HttpURLConnection conn = (HttpURLConnection) fileUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;

    }



}
