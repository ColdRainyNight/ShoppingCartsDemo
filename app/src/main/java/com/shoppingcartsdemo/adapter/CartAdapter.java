package com.shoppingcartsdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.base.Product;

import java.util.List;




/**
 * 类的描述：购物车
 * 时间：  2017/8/17.10:15
 * 姓名：
 */
public class CartAdapter extends BaseAdapter{
    Context context;
    List<Product.DataBean.CategoriesBean.ProductsBean> list;
    TextView totalPrice;
    TextView order;

    public CartAdapter(Context context, List<Product.DataBean.CategoriesBean.ProductsBean> list, TextView total_price,TextView order) {
        this.context = context;
        this.list = list;
        this.totalPrice=total_price;
        this.order = order;
    }

    @Override
        public int getCount() {
           return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null){
                convertView=View.inflate(context, R.layout.item_cart,null);
                holder=new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.p_title);
                holder.image = (ImageView) convertView.findViewById(R.id.p_image);
                holder.p_featured_price = (TextView) convertView.findViewById(R.id.p_featured_price);

                holder.p_price = (TextView) convertView.findViewById(R.id.p_price);

                holder.selected = (ImageView) convertView.findViewById(R.id.p_selected);
                holder.remove = (ImageView) convertView.findViewById(R.id.remove);
                holder.minus = (ImageView) convertView.findViewById(R.id.minus);
                holder.plus = (ImageView) convertView.findViewById(R.id.plus);
                holder.count = (TextView) convertView.findViewById(R.id.p_count);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder)convertView.getTag();
            }

            holder.title.setText(list.get(position).getName());
            Glide.with(context).load(list.get(position).getImage_small()).into(holder.image);
            holder.p_price.setText(list.get(position).getPrice());
            holder.p_featured_price.setText(list.get(position).getFeatured_price());

            final Product.DataBean.CategoriesBean.ProductsBean item = (Product.DataBean.CategoriesBean.ProductsBean) getItem(position);

            if(item.is_selected==1){
                holder.selected.setImageResource(R.drawable.operator_selected);

            }else {
                holder.selected.setImageResource(R.drawable.operator_unselected);

            }

            holder.selected.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ImageView imageView = (ImageView) view.findViewById(R.id.p_selected);
                    selectedItem(item,imageView);
                }
            });

            final View finalConvertView = convertView;
            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO  增加
                    if (item.count < 5) {
                        item.count++;
                        TextView textView = (TextView) finalConvertView.findViewById(R.id.p_count);
                        textView.setText(item.count + "");
                        totalPrice();
                    }
                }
            });

            final View finalConvertView1 = convertView;
            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO 减少
                    if (item.count > 1) {
                        item.count--;
                        notifyDataSetChanged();
                        TextView textView = (TextView) finalConvertView1.findViewById(R.id.p_count);
                        textView.setText(item.count + "");
                        totalPrice();
                    }
                }
            });
            return convertView;
        }

    public void totalPrice() {
        float price = 0;
        int count=0;
        for (Product.DataBean.CategoriesBean.ProductsBean item : list) {
            if (item.is_selected == 1) {
                price += Float.parseFloat(item.getFeatured_price())*item.count;
                count+=item.count;
            }
        }

        totalPrice.setText("总价"+price);
        order.setText("去结算("+count+")");

    }
    public void selectedItem(Product.DataBean.CategoriesBean.ProductsBean item, ImageView imageView) {
        if (item.is_selected== 0) {
            imageView.setImageResource(R.drawable.operator_selected);
            item.is_selected = 1;
        } else {
            item.is_selected = 0;
            imageView.setImageResource(R.drawable.operator_unselected);
        }
    }


        class ViewHolder{
            TextView  title;
            ImageView image;
            TextView p_featured_price;
            TextView  p_price;
            ImageView selected;
            TextView count;
            ImageView remove;
            ImageView minus, plus;
         }
}
