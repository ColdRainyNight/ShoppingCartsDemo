package com.shoppingcartsdemo.base;

/**
 * Created by liqy on 2017/8/8.
 */

public class CartItem {

    public int id;
    public int cart_id;
    public int created_at;
    public String created_by;
    public int status;
    public int updated_at;
    public String updated_by;
    public int count;
    public int product_id;
    public String sku_id;
    public int is_ordered;
    public int is_selected;
    public int user_id;
    public String cookie_id;
    public String app_cart_cookie_id;
    public Product product;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", cart_id=" + cart_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", status=" + status +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                ", count=" + count +
                ", product_id=" + product_id +
                ", sku_id='" + sku_id + '\'' +
                ", is_ordered=" + is_ordered +
                ", is_selected=" + is_selected +
                ", user_id=" + user_id +
                ", cookie_id='" + cookie_id + '\'' +
                ", app_cart_cookie_id='" + app_cart_cookie_id + '\'' +
                ", product=" + product +
                '}';
    }
}
