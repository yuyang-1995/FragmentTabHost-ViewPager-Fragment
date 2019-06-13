package com.yuyang.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.yuyang.fragmentdemo.Adapter.MyFragmentAdapter;
import com.yuyang.fragmentdemo.fragment.Fragment1;
import com.yuyang.fragmentdemo.fragment.Fragment2;


import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {


    private FragmentTabHost mFragmentTabHost;
    private LayoutInflater mLayoutInflater;
    private Class fragmentArray[] = {Fragment1.class, Fragment2.class};
    private int[] imageViewArray = {R.drawable.tab_home_btn, R.drawable.tab_view_btn};
    private String[] textViewarray = {"首页","分类"};

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();  //初始化控件
        initPage();   //初始化页面
    }

    private void initPage() {
        Fragment fragment1 = Fragment1.newInstance("测试哈哈哈哈。。。。");
        Fragment fragment2 = new Fragment2();

        fragments.add(fragment1);
        fragments.add(fragment2);

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
        mFragmentTabHost.getTabWidget().setDividerDrawable(null);

    }

    private void initView() {
        viewPager = findViewById(R.id.pager);

        viewPager.setOnPageChangeListener(this);//设置页面切换时的监听器
        mLayoutInflater = LayoutInflater.from(this);

        /*实例化FragmentTabHost对象并对ViewPager进行绑定*/
        mFragmentTabHost = findViewById(R.id.tabhost); //绑定tabhost
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.pager); ////绑定viewpager

        /*实现setOnTabChangedListener接口,目的是为监听界面切换），然后实现TabHost里面图片文字的选中状态切换*/
        /*简单来说,是为了当点击下面菜单时,上面的ViewPager能滑动到对应的Fragment*/
        mFragmentTabHost.setOnTabChangedListener(this);

        int count = textViewarray.length;

        /*新建Tabspec选项卡并设置Tab菜单栏的内容和绑定对应的Fragment*/
        for (int i=0; i < count; i++){
            //给每个Tab设置标签、图标及文字
            TabHost.TabSpec tabSpec = mFragmentTabHost.newTabSpec(textViewarray[i])
                    .setIndicator(getTabItemView(i));
            //将Tab 按钮添加进Tab 选项卡中， 并绑定Fragment
            mFragmentTabHost.addTab(tabSpec, fragmentArray[i], null);
            mFragmentTabHost.setTag(i);
            mFragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
    }

     private View getTabItemView(int i){
        //将xml 布局转化为View对象
        View view = mLayoutInflater.inflate(R.layout.tab_content, null);
        //
        ImageView mImageView = view.findViewById(R.id.tab_imageview);
        TextView mTextView = view.findViewById(R.id.tab_textview);

        mImageView.setBackgroundResource(imageViewArray[i]);
        mTextView.setText(textViewarray[i]);
        return view;
    }


    @Override
    public void onTabChanged(String s) { //Tab 改变时用
        int position = mFragmentTabHost.getCurrentTab();
        viewPager.setCurrentItem(position); //把选中的Tab 的位置赋给视频日期，让他控制页面切换
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {

        TabWidget widget = mFragmentTabHost.getTabWidget();
        int oldFoucability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        mFragmentTabHost.setCurrentTab(position);
        widget.setDescendantFocusability(oldFoucability); //设置取消分割线

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
