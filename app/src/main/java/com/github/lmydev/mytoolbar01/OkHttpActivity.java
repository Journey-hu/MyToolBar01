package com.github.lmydev.mytoolbar01;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OkHttpActivity extends AppCompatActivity {


     private String BASE_URL="http://www.xinzhenxin.com/home/";
     public static final String REGISTER = "Register/index";
     public static final String LOGIN = "Login/login";
     private Button btn;
    String url="https://api.douban.com/v2/book/1220562";

    private static final String TAG = "OkHttpActivity";

    static DatePicker datePicker;
    PopupWindow pop_window;

    private RadioGroup radioGroup;
    private TextView tv_showdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        btn=(Button)findViewById(R.id.button_hr);
        tv_showdate=(TextView)findViewById(R.id.textView3);

        btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               show_Report_Popwindow();
           }
       });

    }




    //手续费的选择
    /**
     * 显示手续费popupWindow
     */
    private void show_Report_Popwindow() {
        // 利用layoutInflater获得View
//        LayoutInflater inflater = getActivity.(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutInflater inflater=OkHttpActivity.this.getLayoutInflater();//fragment的用法
        View view = inflater.inflate(R.layout.date_popwindow, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

//        PopupWindow pop_window = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);//弹出框的大小

         pop_window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);//弹出框的大小
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
         pop_window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xb0000000);
        ColorDrawable dw=new ColorDrawable(0x00000000);

        pop_window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        pop_window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        pop_window.showAtLocation(OkHttpActivity.this.findViewById(R.id.button_hr), Gravity.CENTER, 0, 0);

        // 这里检验popWindow里的button是否可以点击

/*        btn_ok=(Button)findViewById(R.id.button2);
        btn_cancle=(Button)findViewById(R.id.button3);*/
        datePicker=(DatePicker)view.findViewById(R.id.datePicker_change);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OkHttpActivity.this,"datepicker",Toast.LENGTH_LONG).show();
                Log.e(TAG, "onCheckedChanged: "+datePicker.getYear()+"-"+datePicker.getMonth()+"-"+datePicker.getDayOfMonth());
            }
        });


        /*radioGroup = (RadioGroup)view.findViewById(R.id.group_date);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.radioButton2_ok:
                        //ok
                        Log.e(TAG, "onCheckedChanged:   ------------取消------------ ");
                        pop_window.dismiss();
                        break;

                    case R.id.radioButton_cancal:
                        //cancle
                        String date=datePicker.getYear()+"-"+datePicker.getMonth()+"-"+datePicker.getDayOfMonth();
                        Log.e(TAG, "onCheckedChanged: "+datePicker.getYear()+"-"+datePicker.getMonth()+"-"+datePicker.getDayOfMonth());

                        pop_window.dismiss();
                        tv_showdate.setText("你选的日期："+date);

                        break;
                }
            }
        });
*/

}



    public static void startNextActivity(Context context){
        Intent intent=new Intent(context,OkHttpActivity.class);
        context.startActivity(intent);
    }



}
