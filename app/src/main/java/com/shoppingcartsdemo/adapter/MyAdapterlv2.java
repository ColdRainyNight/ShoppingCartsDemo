package com.shoppingcartsdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.base.Database;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 类描述：月光奶茶/右边数据
 * 创建人：xuyaxi
 * 创建时间：2017/8/2 20:46
 */
public class MyAdapterlv2 extends BaseAdapter {

    private List<Database.DataBean.CategoriesBean.ProductsBean> list;
    private Context context;
    ImageOptions optopns;

    public MyAdapterlv2(List<Database.DataBean.CategoriesBean.ProductsBean> list, Context context) {
        this.list = list;
        this.context = context;
        optopns = new ImageOptions.Builder()
                .setSize(200, 200)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
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
            view = View.inflate(context, R.layout.right_homeitem, null);
            holder = new ViewHolder();

            x.view().inject(holder, view);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        Database.DataBean.CategoriesBean.ProductsBean bean = list.get(i);
        holder.txt2.setText(bean.getName());
        holder.txt3.setText("￥" + bean.getPrice() + "");
        x.image().bind(holder.image1, bean.getImage_small(),optopns);



        return view;
    }

    class ViewHolder {
        @ViewInject(R.id.image_1)
        ImageView image1;
        @ViewInject(R.id.txt_2)
        TextView txt2;
        @ViewInject(R.id.txt_3)
        TextView txt3;
    }
}
