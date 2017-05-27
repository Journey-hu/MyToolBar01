package com.github.lmydev.mytoolbar01;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;
import java.util.List;

public class WheelActivity extends AppCompatActivity {

    private static final String TAG = "WheelActivity";
    private WheelView mWheelView;
    private TextView mTextView;
    List<String>  list=null;

    private Toast toast;

    private LoopView mLoopView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);
        mTextView=(TextView)findViewById(R.id.textView) ;
        mWheelView=(WheelView)findViewById(R.id.main_wv);
        mWheelView.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        mWheelView.setSkin(WheelView.Skin.Common); // common皮肤
        init();
        mWheelView.setWheelData(list);  // 数据集合
//      mWheelView.setLoop(true);//循环
//链接：https://github.com/venshine/WheelView
        mWheelView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, "onItemClick: "+position);
            }
        });

      /*  mTextView.setText("当前的位置:"+mWheelView.getSelectionItem()+"\n"
                +"获取滚轮位置:"+list.get(mWheelView.getSelection())+"\n"
                +"当前滚轮位置:"+mWheelView.getCurrentPosition()+"\n"
                +"获取当前总数:"+mWheelView.getWheelCount());*/
        mTextView.setTextColor(Color.BLUE);


        //-----------------------------------------------------------------------------------------

        final LoopView loopView = (LoopView) findViewById(R.id.loopView);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            list.add("五月"+i+"号");
        }
        //设置是否循环播放
        // loopView.setNotLoop();
        //滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (toast == null) {
                    toast = Toast.makeText(WheelActivity.this, "item " + index, Toast.LENGTH_SHORT);
                }
                toast.setText("item " + index);
                mTextView.setText(index+"%");
                toast.show();
            }
        });
        //设置原始数据
        loopView.setItems(list);




    }


    public void init(){
        list=new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(i,"I am Superman"+i);
        }
    }




















}
