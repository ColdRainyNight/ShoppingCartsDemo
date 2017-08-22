package com.shoppingcartsdemo.activity_yeguangcharen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shoppingcartsdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：Banner轮播图,月光奶茶
 * 创建人：xuyaxi
 * 创建时间：2017/8/19 11:46
 */
public class YueGuang extends AppCompatActivity {

    private int[] imgs = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d
            , R.drawable.e};
    private List<View> viewList;
    BannerView bannerView;

    TextView title,priceds,fpriceds,conteds;
    Button gous,jies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yueguang);
        bannerView = (BannerView) findViewById(R.id.banner);
        initBannerView();
        loadView();
    }

    private void initBannerView() {
        viewList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView image = new ImageView(this);
            image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置显示格式
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setImageResource(imgs[i]);
            viewList.add(image);
        }
        bannerView = (BannerView) findViewById(R.id.banner);
        bannerView.setViewList(viewList);
        bannerView.startLoop(true);
    }
    private void loadView() {
        title = (TextView) findViewById(R.id.title);
        priceds = (TextView) findViewById(R.id.prices);
        fpriceds = (TextView) findViewById(R.id.f_prices);
        conteds = (TextView) findViewById(R.id.counts);
        gous = (Button) findViewById(R.id.gou);
        jies = (Button) findViewById(R.id.jie);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String feat_price = intent.getStringExtra("feat_price");
        String count = intent.getStringExtra("count");
        title.setText(name);
        priceds.setText("￥"+price);
        fpriceds.setText("￥"+feat_price);
        conteds.setText(count);
        gous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(YueGuang.this,"成功加入购物车",Toast.LENGTH_SHORT).show();
            }
        });
        jies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(YueGuang.this,"成功结算",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
