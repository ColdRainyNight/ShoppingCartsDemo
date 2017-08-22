package com.shoppingcartsdemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.activity_denglu.MainActivityLogin;

/**
 * 类描述：我的
 * 创建人：xuyaxi
 * 创建时间：2017/8/2 20:12
 */
public class NotLoggedIn extends Fragment{

     ImageView image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.notloggedin_main, null);
        image = (ImageView) view.findViewById(R.id.image_qq);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MainActivityLogin.class);
                startActivity(it);
            }
        });
        return view;
    }
}
