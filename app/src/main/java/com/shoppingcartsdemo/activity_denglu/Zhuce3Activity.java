package com.shoppingcartsdemo.activity_denglu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.app.HttpUtil;
import com.shoppingcartsdemo.base.Zhuce3;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类描述：登录/注册
 * 创建人：xuyaxi
 * 创建时间：2017/8/16 17:14
 */
public class Zhuce3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce3);
        final EditText yanzhengma = (EditText) findViewById(R.id.yanzhengma);
        Button wancheng = (Button) findViewById(R.id.xiayibu3);
        Intent intent = getIntent();
        final String shoujihao = intent.getStringExtra("shoujihao");
        final String mima = intent.getStringExtra("mima");
        wancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(yanzhengma.getText().toString()!=null){
                    String url = "http://api.eleteam.com/v1/user/register-step3?mobile="+shoujihao+"&&password="+mima+"&&code="+yanzhengma.getText().toString();
                    HttpUtil.sendOkHttpRequest(url, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new Gson();
                            Zhuce3 zhuce3 = gson.fromJson(response.body().string(), Zhuce3.class);
                            int code = zhuce3.getCode();
                            if(code==1){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(Zhuce3Activity.this,"注册完成",Toast.LENGTH_LONG).show();
                                    }
                                });

                            }
                        }
                    });
                }
            }
        });
    }
}
