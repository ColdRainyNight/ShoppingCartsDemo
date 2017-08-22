package com.shoppingcartsdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.adapter.CartAdapter;
import com.shoppingcartsdemo.base.Product;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * 类的描述： 购物车
 * 时间：  2017/8/11.15:29
 * 姓名：
 */

public class TheHeadlines extends Fragment {
    ListView lv;
    CartAdapter adapter;

    TextView to_order;
    TextView total_price;
    List<Product.DataBean.CategoriesBean.ProductsBean> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_gou_fragment, container, false);
        lint(view);
        loadView();
        return view;
    }

    private void loadView() {
        String url = "http://api.eleteam.com/v1/category/list-with-product";
        final RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Product cat = new Gson().fromJson(result,Product.class);
                list.addAll(cat.getData().getCategories().get(0).getProducts());
                adapter.notifyDataSetChanged();

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

    private void lint(View view) {
        total_price= (TextView) view.findViewById(R.id.total_price);
        to_order= (TextView) view.findViewById(R.id.to_order);
        lv = (ListView) view.findViewById(R.id.listView);
        adapter = new CartAdapter(getContext(),list,total_price,to_order);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.clear();
            }
        });
    }
}
