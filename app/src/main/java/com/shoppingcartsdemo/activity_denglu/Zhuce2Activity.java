package com.shoppingcartsdemo.activity_denglu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.app.HttpUtil;
import com.shoppingcartsdemo.base.Zhuce2;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类描述：登录/注册
 * 创建人：xuyaxi
 * 创建时间：2017/8/16 17:14
 */
public class Zhuce2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce2);
        Intent intent = getIntent();
        final String shoujihao = intent.getStringExtra("shoujihao");
        final EditText password = (EditText) findViewById(R.id.mima);
        Button button = (Button) findViewById(R.id.xiayibu2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString()!=null){
                    String url = "http://api.eleteam.com/v1/user/register-step2?mobile="+shoujihao+"&&password="+password.getText().toString();
                    HttpUtil.sendOkHttpRequest(url, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new Gson();
                            Zhuce2 zhuce2 = gson.fromJson(response.body().string(), Zhuce2.class);
                            int code = zhuce2.getCode();
                            if(code==1){
                                Intent intent1 = new Intent(Zhuce2Activity.this, Zhuce3Activity.class);
                                intent1.putExtra("shoujihao",shoujihao);
                                intent1.putExtra("mima",password.getText().toString());
                                startActivity(intent1);
                            }
                        }
                    });
                }
            }
        });
    }
}
