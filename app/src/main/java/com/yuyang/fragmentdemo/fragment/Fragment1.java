package com.yuyang.fragmentdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yuyang.fragmentdemo.R;

public class Fragment1 extends Fragment {


    private String mArgument;
    public static  final String ARGUMENT = "argument";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null)
            mArgument = bundle.getString(ARGUMENT);
        Log.e(ARGUMENT, mArgument + " ");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item1, container, false);
    }


    public static Fragment1 newInstance(String mArgument){

        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT, mArgument);
        Fragment1 fragment1 = new Fragment1();
        fragment1.setArguments(bundle);   //设置参数
        return fragment1;
    }


}
