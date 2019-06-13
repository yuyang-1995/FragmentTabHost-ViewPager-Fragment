package com.yuyang.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.yuyang.fragmentdemo.fragment.ActivityFragment1;
import com.yuyang.fragmentdemo.fragment.ActivityFragment2;

public class MainActivity extends AppCompatActivity {


    private Button btn_1, btn_2;
    private  int temp = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActivityFragment1 activityFragment1 = new ActivityFragment1();

        final ActivityFragment2 activityFragment2 = new ActivityFragment2();

        replaceFragment(5);


        btn_1 = findViewById(R.id.btn_change);
        btn_2 = findViewById(R.id.btn_comein);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              replaceFragment(temp++);

            }
        });


        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    private void replaceFragment(int temp) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (temp%2==0){

            Fragment fragment2 = new ActivityFragment2();
            fragmentTransaction.replace(R.id.creativeFragment, fragment2);
            fragmentTransaction.commit();
            Log.e("temp=", temp +" ");
        }else {

            Fragment fragment1 = new ActivityFragment1();
            fragmentTransaction.replace(R.id.creativeFragment, fragment1);
            fragmentTransaction.commit();
            Log.e("temp=", temp +" ");
         }
     }
}
