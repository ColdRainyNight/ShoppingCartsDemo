package com.shoppingcartsdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.base.Database;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 类描述：月光奶茶/左边数据
 * 创建人：xuyaxi
 * 创建时间：2017/8/2 20:30
 */
public class MyAdapterlv1 extends BaseAdapter {

    private List<Database.DataBean.CategoriesBean> list;
    private Context context;
    private int selectItem = 0;

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
        notifyDataSetChanged();
    }

    public MyAdapterlv1(List<Database.DataBean.CategoriesBean> list, Context context) {
        this.list = list;
        this.context = context;
        notifyDataSetChanged();
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
            view = View.inflate(context, R.layout.left_homeitem, null);
            holder = new ViewHolder();


            x.view().inject(holder, view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Database.DataBean.CategoriesBean bean = list.get(i);
        holder.txt1.setText(bean.getName());

        if (selectItem == i) {
            holder.txt1.setTextColor(Color.BLUE);
        } else {
            holder.txt1.setTextColor(Color.BLACK);
        }

        return view;
    }


    class ViewHolder {
        @ViewInject(R.id.txt_1)
        TextView txt1;
    }
}
