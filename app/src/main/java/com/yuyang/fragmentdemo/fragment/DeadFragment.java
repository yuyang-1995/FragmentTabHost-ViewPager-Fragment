package com.yuyang.fragmentdemo.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.yuyang.fragmentdemo.R;

public class DeadFragment extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dead_fragment,container, false);
    }


}
