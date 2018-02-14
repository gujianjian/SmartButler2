package com.example.joy.smartbutler;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.joy.smartbutler.fragment.ButlerFragment;
import com.example.joy.smartbutler.fragment.GirlFragment;
import com.example.joy.smartbutler.fragment.UserFragment;
import com.example.joy.smartbutler.fragment.WechatFragment;
import com.example.joy.smartbutler.ui.SettingActivity;
import com.example.joy.smartbutler.utils.L;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FloatingActionButton fab_setting;

    private List<String> mListTitle;
    private List<Fragment> mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 去掉actionbar阴影
        if(Build.VERSION.SDK_INT>=21){
            getSupportActionBar().setElevation(0);
        }
        initData();
        initView();

        L.d("text");

    }

    private void initData() {
        mListTitle = new ArrayList<>();
        mListTitle.add(getResources().getString(R.string.butler));//服务管家
        mListTitle.add(getResources().getString(R.string.wechat));//微信精选
        mListTitle.add(getResources().getString(R.string.girl));//美女社区
        mListTitle.add(getResources().getString(R.string.user));//个人中心

        mListFragment = new ArrayList<>();
        mListFragment.add(new ButlerFragment());
        mListFragment.add(new WechatFragment());
        mListFragment.add(new GirlFragment());
        mListFragment.add(new UserFragment());
    }

    private void initView() {
        mViewPager = findViewById(R.id.mViewPager);
        mTabLayout = findViewById(R.id.mTabLayout);
        fab_setting=findViewById(R.id.fab_setting);

        fab_setting.setOnClickListener(this);
        fab_setting.setVisibility(View.GONE);

        mViewPager.setOffscreenPageLimit(mListTitle.size());

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //隐藏选中第一个标签时，隐藏悬浮框
                if(position==0){
                    fab_setting.setVisibility(View.GONE);
                }else{
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mListFragment.get(position);
            }

            @Override
            public int getCount() {
                return mListFragment.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mListTitle.get(position);
            }




        });

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_setting:
                startActivity(new Intent(this,SettingActivity.class));
                break;
        }
    }
}
