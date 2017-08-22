package com.shoppingcartsdemo.activity_denglu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.app.HttpUtil;
import com.shoppingcartsdemo.base.Zhuce1;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类描述：登录/注册
 * 创建人：xuyaxi
 * 创建时间：2017/8/16 17:14
 */
public class ZhuceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        final EditText shoujihao   = (EditText) findViewById(R.id.shoujihao);
        Button xiayibu   = (Button) findViewById(R.id.xiayibu);
        xiayibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shoujihao.getText().toString()!=null){
                    String url = " http://api.eleteam.com/v1/user/register-step1?mobile="+shoujihao.getText().toString();
                    HttpUtil.sendOkHttpRequest(url, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new Gson();
                            Zhuce1 zhuce1 = gson.fromJson(response.body().string(), Zhuce1.class);
                            int code = zhuce1.getCode();
                            if(code==1){
                                Intent intent = new Intent(ZhuceActivity.this,Zhuce2Activity.class);
                                intent.putExtra("shoujihao",shoujihao.getText().toString());
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
    }
}
