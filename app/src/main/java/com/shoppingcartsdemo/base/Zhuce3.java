package com.shoppingcartsdemo.base;

/**
 * 类描述：注册/登录
 * 创建人：xuyaxi
 * 创建时间：2017/8/16 17:21
 */
public class Zhuce3 {

    /**
     * status : true
     * code : 1
     * message : 调用成功
     * data : {"user":{"mobile":"15311485759","password_plain":"a123456","password_hash":"$2y$13$mWhUwBXD4tPXToebh7lUneisREi9BnptuhwcEzlBJDa.I/c.MZ6za","access_token":"A2oTT7leEiD8bLFuado41Iv55LRXOonR","avatar":"http://data.eleteam.com/uploads/public/user/default.jpg","status":1,"created_at":1502197584,"updated_at":1502197584,"created_by":null,"updated_by":null,"id":169},"app_cart_cookie_id":"6cc42f288a8ed5ccb4ea3f9976cf34ad"}
     * share : {}
     */

    private boolean status;
    private int code;
    private String message;
    private DataBean data;
    private ShareBean share;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }

    public static class DataBean {
        /**
         * user : {"mobile":"15311485759","password_plain":"a123456","password_hash":"$2y$13$mWhUwBXD4tPXToebh7lUneisREi9BnptuhwcEzlBJDa.I/c.MZ6za","access_token":"A2oTT7leEiD8bLFuado41Iv55LRXOonR","avatar":"http://data.eleteam.com/uploads/public/user/default.jpg","status":1,"created_at":1502197584,"updated_at":1502197584,"created_by":null,"updated_by":null,"id":169}
         * app_cart_cookie_id : 6cc42f288a8ed5ccb4ea3f9976cf34ad
         */

        private UserBean user;
        private String app_cart_cookie_id;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getApp_cart_cookie_id() {
            return app_cart_cookie_id;
        }

        public void setApp_cart_cookie_id(String app_cart_cookie_id) {
            this.app_cart_cookie_id = app_cart_cookie_id;
        }

        public static class UserBean {
            /**
             * mobile : 15311485759
             * password_plain : a123456
             * password_hash : $2y$13$mWhUwBXD4tPXToebh7lUneisREi9BnptuhwcEzlBJDa.I/c.MZ6za
             * access_token : A2oTT7leEiD8bLFuado41Iv55LRXOonR
             * avatar : http://data.eleteam.com/uploads/public/user/default.jpg
             * status : 1
             * created_at : 1502197584
             * updated_at : 1502197584
             * created_by : null
             * updated_by : null
             * id : 169
             */

            private String mobile;
            private String password_plain;
            private String password_hash;
            private String access_token;
            private String avatar;
            private int status;
            private int created_at;
            private int updated_at;
            private Object created_by;
            private Object updated_by;
            private int id;

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPassword_plain() {
                return password_plain;
            }

            public void setPassword_plain(String password_plain) {
                this.password_plain = password_plain;
            }

            public String getPassword_hash() {
                return password_hash;
            }

            public void setPassword_hash(String password_hash) {
                this.password_hash = password_hash;
            }

            public String getAccess_token() {
                return access_token;
            }

            public void setAccess_token(String access_token) {
                this.access_token = access_token;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public Object getCreated_by() {
                return created_by;
            }

            public void setCreated_by(Object created_by) {
                this.created_by = created_by;
            }

            public Object getUpdated_by() {
                return updated_by;
            }

            public void setUpdated_by(Object updated_by) {
                this.updated_by = updated_by;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }

    public static class ShareBean {
    }
}
