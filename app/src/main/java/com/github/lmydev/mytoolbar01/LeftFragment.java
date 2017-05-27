package com.github.lmydev.mytoolbar01;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LeftFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tv;
    private Button btn_go;
    private TextView tv_fromActivty;
    private TextView tv_9;
    private Button btn_look;
    private static final String TAG = "LeftFragment";
    String   sintent=null;

    boolean tag=true;
    private String ss="保护方式方式几号放假多少烦不烦烦不烦不离开的浪费粮食分数段分布保护方式方式\n" +
            "        几号放假多少烦不烦烦不烦不离开的浪费粮食分数段分布的版本发货吧热播本本分分不大部分六六大\n" +
            "        顺浪费的事房价放假开会的版本发货吧热播本本分分不大部分六六大顺浪费的事房价放假开会";

 public static LeftFragment getInstance(){
     LeftFragment leftFragment=new LeftFragment();
     return leftFragment;
 }

    public LeftFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeftFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeftFragment newInstance(String param1, String param2) {
        LeftFragment fragment = new LeftFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.e(TAG, "onCreate: ");
    }


    /**
     * 此方法用来跳转的activity要传回的数据，以及接受到传回数据的要做的业务
     * 这里因为只有一个activity返回数据，所以这里就只有一个resultCode，就直接接收返回值处理
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "-----------leftfragment------------: requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");
       switch(requestCode){
           case 100:

               Intent intent=getActivity().getIntent();
               String sa=intent.getStringExtra("name");
               Log.e(TAG, " --------碎片------- onActivityResult: "+sa);
               break;

       }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_left, container, false);
        tv=(TextView)view.findViewById(R.id.tv_getnum);
        btn_go=(Button)view.findViewById(R.id.button_go);
        tv_fromActivty=(TextView) view.findViewById(R.id.textView5);
        tv_9=(TextView)view.findViewById(R.id.textView9);
        //跳转到要给他传值的activity
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_go=new Intent(getActivity(),EditActivity.class);
                startActivityForResult(intent_go,100);
            }
        });


        Log.e(TAG, "onCreateView: "+tv_fromActivty.getText().toString());

        btn_look=(Button)view.findViewById(R.id.button_look);
        btn_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tag) {
                    //显示全部
                    tv_9.setMaxLines(5);
                    tag=false;
                    Log.e(TAG, "onClick: "+tag);
                } else if(!tag){
                    //隐藏
                   tv_9.setMaxLines(2);
                    tag=true;
                    Log.e(TAG, "onClick: "+tag);
                }
            }
        });


       /* String  name=((ToolbarFragActivity)getActivity()).getName();

        tv_fromActivty.setText("接收的值:"+name);*/
        return view;
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: ");
    }


    @Override
    public void onResume() {
        super.onResume();
        String sintent = ((ToolbarFragActivity) getActivity()).getName();
        tv_fromActivty.setText("接收的值:" + sintent);
        Log.e(TAG, "onCreateView: "+tv_fromActivty.getText().toString());
    }


}
