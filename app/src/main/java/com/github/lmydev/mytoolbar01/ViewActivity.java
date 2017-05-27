package com.github.lmydev.mytoolbar01;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private Button btn_pop;
    Toast toast;
    private TextView mTextView;
    static LoopView loopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        btn_pop=(Button)findViewById(R.id.btn_pop);
        mTextView=(TextView)findViewById(R.id.textView2);
        btn_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* Intent intent_okhttp=new Intent(ViewActivity.this,OkHttpActivity.class);
                startActivity(intent_okhttp);*/
                OkHttpActivity.startNextActivity(ViewActivity.this);
            }
        });


        mTextView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            show_Report_Popwindow();
        }
        });

    }



    /**
     * 显示举报popupWindow
     */
    private void show_Report_Popwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.layout_popwindow, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

//        PopupWindow pop_window = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);//弹出框的大小

        PopupWindow pop_window = new PopupWindow(view, 650, 400);//弹出框的大小
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        pop_window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xb0000000);
          ColorDrawable dw=new ColorDrawable(0x00000000);

        pop_window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        pop_window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        pop_window.showAtLocation(ViewActivity.this.findViewById(R.id.btn_pop), Gravity.CENTER, 0, 0);

        // 这里检验popWindow里的button是否可以点击
         loopView = (LoopView) view.findViewById(R.id.loopView);

        final ArrayList<String> list = new ArrayList<>();

        int a=4;
        for (float i = 0; i < 16; i++) {
            a+=1;
            list.add("0."+a+"%");
        }
        //设置是否循环播放
//        loopView.setNotLoop();
        //滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (toast == null) {
                    toast = Toast.makeText(ViewActivity.this, "item " + +index, Toast.LENGTH_SHORT);
                }
                toast.setText("item " + index);
                mTextView.setText("结果:"+list.get(index));
                toast.show();
            }
        });
        //设置原始数据
        loopView.setItems(list);
        loopView.setDividerColor(Color.RED);
        loopView.setCenterTextColor(Color.RED);
    }

}
