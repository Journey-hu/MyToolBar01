package com.github.lmydev.mytoolbar01;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class RightFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btn_Activity;
    private TextView textView;
    private String str_to;

    public static RightFragment getInstance(){
        RightFragment rightFragment=new RightFragment();
        return rightFragment;
    }

    public RightFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RightFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RightFragment newInstance(String param1, String param2) {
        RightFragment fragment = new RightFragment();
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
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_right, container, false);
        textView=(TextView)view.findViewById(R.id.textView8);
        btn_Activity=(Button)view.findViewById(R.id.button_activity);
        btn_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_activity=new Intent(getActivity(),EditActivity.class);
                intent_activity.putExtra("title","我来自碎片");
                intent_activity.putExtra("name","xiaohu");
                intent_activity.putExtra("area","杭州江干区");
                intent_activity.putExtra("time","2017年五月");
                startActivity(intent_activity);
            }
        });

        String  name=((ToolbarFragActivity)getActivity()).getName();
        textView.setText("接收的值:"+name);
        return view;
    }

}
