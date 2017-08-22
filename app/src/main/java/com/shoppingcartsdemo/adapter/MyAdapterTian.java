package com.shoppingcartsdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.base.TianTianBean;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 类描述：优惠/天天
 * 创建人：xuyaxi
 * 创建时间：2017/8/8 20:08
 */
public class MyAdapterTian extends BaseAdapter {

    private List<TianTianBean.DataBean.ProductsBean> list;
    private Context mContext;
    ImageOptions optopns;
    public MyAdapterTian(List<TianTianBean.DataBean.ProductsBean> list, Context context) {
        this.list = list;
        mContext = context;
        optopns  = new ImageOptions.Builder()
                         .setSize(200, 200)
                         .setLoadingDrawableId(R.mipmap.ic_launcher)
                         .setFailureDrawableId(R.mipmap.ic_launcher)
                         .build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.tiantianitem, null);
            holder = new ViewHolder();

            x.view().inject(holder, view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        TianTianBean.DataBean.ProductsBean bean = list.get(i);
        holder.tian1.setText(bean.getName());
        holder.tian2.setText(bean.getMeta_description());
        holder.tian3.setText("￥"+bean.getPrice()+"");
        x.image().bind(holder.tianimage,bean.getApp_long_image1(),optopns);

        return view;
    }

    class ViewHolder {

        @ViewInject(R.id.tianimage)
        ImageView tianimage;
        @ViewInject(R.id.tian1)
        TextView tian1;
        @ViewInject(R.id.tian2)
        TextView tian2;
        @ViewInject(R.id.tian3)
        TextView tian3;
    }
}
