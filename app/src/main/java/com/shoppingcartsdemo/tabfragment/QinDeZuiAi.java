package com.shoppingcartsdemo.tabfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.adapter.MyAdapterQin;
import com.shoppingcartsdemo.base.QinDaBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：xuyaxi
 * 创建时间：2017/8/7 21:26
 */
public class QinDeZuiAi extends Fragment {

    private List<QinDaBean.DataBean.ProductsBean> list = new ArrayList<>();
    private String url = "http://api.eleteam.com/v1/product/list-featured-topic";
    private ListView lv;
    private MyAdapterQin adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.qinde_main, null);
        lv = (ListView) view.findViewById(R.id.lvqin);
        initView();
        adapter = new MyAdapterQin(list, getActivity());
        lv.setAdapter(adapter);

        return view;
    }

    private void initView() {
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                QinDaBean bean = new Gson().fromJson(result, QinDaBean.class);
                list.addAll(bean.getData().getProducts());
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
}
