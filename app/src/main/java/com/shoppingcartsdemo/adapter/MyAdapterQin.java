package com.shoppingcartsdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.base.QinDaBean;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 类描述：优惠/亲的
 * 创建人：xuyaxi
 * 创建时间：2017/8/8 20:41
 */
public class MyAdapterQin extends BaseAdapter {

    private List<QinDaBean.DataBean.ProductsBean> list;
    private Context mContext;
    ImageOptions optopns;

    public MyAdapterQin(List<QinDaBean.DataBean.ProductsBean> list, Context context) {
        this.list = list;
        mContext = context;
        optopns = new ImageOptions.Builder()
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
            view = View.inflate(mContext, R.layout.qindeitem, null);
            holder = new ViewHolder();

            x.view().inject(holder, view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        QinDaBean.DataBean.ProductsBean bean = list.get(i);
        holder.qin1.setText(bean.getName());
        holder.qin2.setText(bean.getShort_description());
        holder.qin3.setText("￥"+bean.getFeatured_price()+"");
        x.image().bind(holder.qinimage,bean.getImage_small(),optopns);

        return view;
    }

    class ViewHolder {

        @ViewInject(R.id.qinimage)
        ImageView qinimage;
        @ViewInject(R.id.qin1)
        TextView qin1;
        @ViewInject(R.id.qin2)
        TextView qin2;
        @ViewInject(R.id.qin3)
        TextView qin3;

    }
}
