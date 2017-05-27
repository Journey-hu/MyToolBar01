package com.github.lmydev.mytoolbar01;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends FragmentActivity {

    private EditText mEditText;
    private int toal_num = 100;
    private int number=0;


    private TextView tv_count;
    private TextView tv_show;

    private Button btn_frag;
    private Button btn_for;

    private static final String TAG = "EditActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mEditText=(EditText)findViewById(R.id.edit_count);
        tv_count=(TextView)findViewById(R.id.tv_count);
        tv_count.setText("" + number+"/"+toal_num);
        btn_frag=(Button)findViewById(R.id.button_back);

        btn_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //传值到Activity的碎片

                /* Intent mIntent = new Intent(EditActivity.this,ToolbarFragActivity.class);
                 mIntent.putExtra("name","传给借贷区");
                  //这里要直接干掉
                 startActivity(mIntent);*/

                  startMainActivity(ToolbarFragActivity.ACTION_SHOW_LEND);

//                  EditActivity.this.finish();


            }
        });


        btn_for=(Button)findViewById(R.id.button_forresult);
        btn_for.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 /* Intent intent_forresult = new Intent(EditActivity.this,ToolbarFragActivity.class);
                  intent_forresult.putExtra("name","传给任务区");
                  startActivityForResult(intent_forresult,10);*/

                 startMainActivity(ToolbarFragActivity.ACTION_SHOW_LEASE);

//                EditActivity.this.finish();
            }
        });



        mEditText.addTextChangedListener(new TextWatcher() {
            private CharSequence wordNum;//记录输入的字数
            private int selectionStart;
            private int selectionEnd;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                wordNum= s;
            }

            @Override
            public void afterTextChanged(Editable s){
                number = toal_num - s.length();
                //TextView显示剩余字数
                tv_count.setText("" + number+"/"+toal_num);
                selectionStart=mEditText.getSelectionStart();
                selectionEnd = mEditText.getSelectionEnd();
                if (wordNum.length() > toal_num) {
                    //删除多余输入的字（不会显示出来）
                    s.delete(selectionStart - 1, selectionEnd);
                    int tempSelection = selectionEnd;
                    mEditText.setText(s);
                    mEditText.setSelection(tempSelection);//设置光标在最后
                   }
               }


          });


        tv_show=(TextView)findViewById(R.id.textView7);
        Intent intent_fm=getIntent();
        String stit=intent_fm.getStringExtra("title");
        String snam=intent_fm.getStringExtra("name");
        String sare=intent_fm.getStringExtra("area");
        String sti=intent_fm.getStringExtra("time");


        tv_show.setText("碎片传来的值:"+"\n title:"+stit+"\n name:"+snam+"\n area:"+sare+"\n time:"+sti);




    }

     private void startMainActivity(String action) {

            Intent intent = new Intent(this, ToolbarFragActivity.class);
            intent.setAction(action);
            startActivity(intent);

    }

    //如果跳转到Activity，当这个Activity结束时会调用这个方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


}

