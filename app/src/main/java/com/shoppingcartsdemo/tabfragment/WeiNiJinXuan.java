package com.shoppingcartsdemo.tabfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shoppingcartsdemo.R;

/**
 * 类描述：优惠/为你
 * 创建人：xuyaxi
 * 创建时间：2017/8/7 21:25
 */
public class WeiNiJinXuan  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.timg1);

        return imageView;
    }
}
