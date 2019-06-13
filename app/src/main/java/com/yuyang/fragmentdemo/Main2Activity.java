package com.yuyang.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import com.yuyang.fragmentdemo.fragment.Fragment1;
import com.yuyang.fragmentdemo.fragment.Fragment2;

public class Main2Activity extends AppCompatActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {


    private FragmentTabHost mFragmentTabHost;
    private LayoutInflater mLayoutInflater;
    private Class fragmentArray[] = {Fragment1.class, Fragment2.class};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onTabChanged(String s) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
