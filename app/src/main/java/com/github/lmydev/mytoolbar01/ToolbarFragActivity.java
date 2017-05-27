package com.github.lmydev.mytoolbar01;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class ToolbarFragActivity extends AppCompatActivity implements OnTabSelectListener {
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private String[] mTitles = {"借贷", "任务"};
    private static final String TAG = "ToolbarFragActivity";
    SlidingTabLayout tabLayout_2;

    public static final String ACTION_SHOW_LEND = "action_show_community_lend";
    public static final String ACTION_SHOW_LEASE = "action_show_community_lease";

    private MyPagerAdapter mAdapter;

    private String name;

    private String describe;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    private LeftFragment mComunity_lend_fragment;
    private RightFragment mCounity_lease_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_frag);

        mFragments.add(LeftFragment.getInstance());
        mFragments.add(RightFragment.getInstance());

        View decorView = getWindow().getDecorView();
        ViewPager vp = ViewFindUtils.find(decorView, R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);

        tabLayout_2= ViewFindUtils.find(decorView, R.id.tl_2);
        tabLayout_2.setViewPager(vp);
        tabLayout_2.setOnTabSelectListener(this);

        Intent intent_activity=getIntent();
        name=intent_activity.getStringExtra("name");

        Log.e(TAG, "onCreate:  获取editActivity传值: "+name);

        vp.setCurrentItem(0);

    }

    //向这个activity中的碎片传值 要复写这个方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "-------------ToolbarFragActivity------------- requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");

        switch (requestCode){
            case 10:
                Log.e(TAG, "onActivityResult: "+data.getStringExtra("name"));
                break;

        }

    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (ACTION_SHOW_LEND.equals(intent.getAction())) {
            tabLayout_2.setCurrentTab(0);
            show_Lend_fragment();
        } else if (ACTION_SHOW_LEASE.equals(intent.getAction())) {
            tabLayout_2.setCurrentTab(1);
            show_Lease_fragment();
        }
    }



    public void show_Lend_fragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(mComunity_lend_fragment)
                .show(mCounity_lease_fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    public void show_Lease_fragment() {
        FragmentTransaction fragmentTransaction_lease = getSupportFragmentManager().beginTransaction();
        fragmentTransaction_lease.hide(mCounity_lease_fragment)
                .show(mComunity_lend_fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent=getIntent();
        String get_String=intent.getStringExtra("name");
        Log.e(TAG, "onRestart: "+get_String);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent=getIntent();
        String get_String=intent.getStringExtra("name");
        Log.e(TAG, " onResume: "+get_String);
    }

    @Override
    public void onTabSelect(int position) {
        Toast.makeText(ToolbarFragActivity.this, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(ToolbarFragActivity.this, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }




    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

}
