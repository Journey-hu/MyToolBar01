package com.github.lmydev.mytoolbar01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForResultActivity extends AppCompatActivity {
    private TextView tv_getresult;
    private Button btn_back;
    private static final String TAG = "ForResultActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);
        tv_getresult=(TextView)findViewById(R.id.textView5);

        btn_back=(Button)findViewById(R.id.button_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.putExtra("change01", "我是ForResultActivity传来的值");
                mIntent.putExtra("change02", "2000");
                // 设置结果，并进行传送
                ForResultActivity.this.setResult(0, mIntent);
                ForResultActivity.this.finish();

            }
        });
    }



}
