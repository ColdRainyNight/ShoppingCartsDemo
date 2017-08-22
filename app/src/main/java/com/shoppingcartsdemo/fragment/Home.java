package com.shoppingcartsdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.activity_yeguangcharen.YueGuang;
import com.shoppingcartsdemo.adapter.MyAdapterlv1;
import com.shoppingcartsdemo.adapter.MyAdapterlv2;
import com.shoppingcartsdemo.base.Database;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：月光奶茶
 * 创建人：xuyaxi
 * 创建时间：2017/8/2 20:12
 */

@ContentView(R.layout.home_main)
public class Home extends Fragment {

    private List<Database.DataBean.CategoriesBean> listlv = new ArrayList<>();
    private ListView lv1;
    private ListView lv2;
    private String urlv = "http://api.eleteam.com/v1/category/list-with-product";

    private MyAdapterlv1 adapterlv1;
    private MyAdapterlv2 adapterlv2;

private List<Database.DataBean.CategoriesBean.ProductsBean> listlv1 = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = x.view().inject(this, inflater, container);
        initView(view);
        loadView();

        return view;
    }

    private void initView(View view) {
        lv1 = (ListView) view.findViewById(R.id.lv1);
        lv2 = (ListView) view.findViewById(R.id.lv2);
        adapterlv1 = new MyAdapterlv1(listlv, getContext());
        lv1.setAdapter(adapterlv1);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                adapterlv1.setSelectItem(position);
                adapterlv2 = new MyAdapterlv2(listlv.get(position).getProducts(), getContext());
                lv2.setAdapter(adapterlv2);
                adapterlv2.notifyDataSetChanged();

            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getContext(), YueGuang.class);
                intent.putExtra("name",listlv.get(i).getProducts().get(0).getName());
                intent.putExtra("price",listlv.get(i).getProducts().get(0).getPrice());
                intent.putExtra("feat_price",listlv.get(i).getProducts().get(0).getFeatured_price());
                intent.putExtra("count",listlv.get(i).getProducts().get(0).getShort_description());
                startActivity(intent);

             //   Toast.makeText(getContext(), "点击" + i + "条", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadView() {
        RequestParams params = new RequestParams(urlv);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Database data = new Gson().fromJson(result, Database.class);
                listlv.addAll(data.getData().getCategories());
                adapterlv1.notifyDataSetChanged();
                adapterlv2.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
