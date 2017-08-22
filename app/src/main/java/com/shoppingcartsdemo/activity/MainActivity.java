package com.shoppingcartsdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.fragment.Home;
import com.shoppingcartsdemo.fragment.NotLoggedIn;
import com.shoppingcartsdemo.fragment.TheHeadlines;
import com.shoppingcartsdemo.fragment.Videos;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;
    private RadioGroup rg;
    private List<Fragment> list;

    private Home h;
    private Videos vd;
    private TheHeadlines th;
    private NotLoggedIn nli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rg);
        addFragment();
        changeFragment();
        zhuangtailan();

    }

    private void zhuangtailan() {
        getSupportActionBar().hide();
        //去状态栏 加沉浸式
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void changeFragment() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                int tag = Integer.parseInt(rb.getTag().toString());
                FragmentTransaction transaction2 = fm.beginTransaction();
                for (int i = 0; i < list.size(); i++) {
                    if (tag == i) {
                        transaction2.show(list.get(i));
                    } else {
                        transaction2.hide(list.get(i));
                    }
                }
                transaction2.commit();
            }
        });
    }

    private void addFragment() {
        list = new ArrayList<>();
        fm = getSupportFragmentManager();
        h = new Home();
        vd = new Videos();
        th = new TheHeadlines();
        nli = new NotLoggedIn();
        list.add(h);
        list.add(vd);
        list.add(th);
        list.add(nli);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.frameLayout, list.get(0));
        transaction.add(R.id.frameLayout, list.get(1));
        transaction.add(R.id.frameLayout, list.get(2));
        transaction.add(R.id.frameLayout, list.get(3));
        transaction.show(list.get(0)).hide(list.get(1)).hide(list.get(2)).hide(list.get(3));
        transaction.commit();
    }
}