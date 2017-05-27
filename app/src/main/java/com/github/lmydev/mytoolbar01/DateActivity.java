package com.github.lmydev.mytoolbar01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateActivity extends AppCompatActivity {

//    git地址：//https://github.com/gzu-liyujiang/AndroidPicker/releases
    private static final String TAG = "DateActivity";
    private TextView tv_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        tv_date=(TextView)findViewById(R.id.textView_date);

        getTime_result();
        Log.d(TAG, " --------ddddddddddddddd -----onCreate: ");
        Log.e(TAG, "--------eeeeeeeeeeeeeee -----onCreate: " );

    }



    public void getTime_result(){
        //比较时间差
        try {
            //获取当前时间
            SimpleDateFormat    formatter    =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss     ");
            Date    curDate    =   new Date(System.currentTimeMillis());//获取当前时间
            String    str    =    formatter.format(curDate);

            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date begin = dfs.parse("2017-05-22 11:30:24");
            java.util.Date end = dfs.parse(str);

            long between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
            long day1 = between / (24 * 3600);
            long hour1 = between % (24 * 3600) / 3600;
            long minute1 = between % 3600 / 60;
            long second1 = between % 60 / 60;
            System.out.println("" + day1 + "天" + hour1 + "小时" + minute1 + "分" + second1 + "秒");
            Log.e(TAG, "onCreate: "+hour1 + "小时" + minute1 + "分" + second1 + "秒");

            tv_date.setText("获取当前时间："+str+"-----"+str.substring(11,17));

        }catch (Exception e){
            Log.e(TAG, "onCreate: "+e.toString());

        }
    }


}
