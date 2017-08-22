package com.shoppingcartsdemo.activity_denglu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shoppingcartsdemo.R;
import com.shoppingcartsdemo.app.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类描述：登录/注册
 * 创建人：xuyaxi
 * 创建时间：2017/8/16 14:25
 */
public class MainActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2main);

        final EditText phone = (EditText) findViewById(R.id.phone);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.login);
        Button zhuce = (Button) findViewById(R.id.zhuce);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityLogin.this,ZhuceActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phone.getText().toString()!=null&&password.getText().toString()!=null){
                    String url = "http://api.eleteam.com/v1/user/login?mobile="+phone.getText().toString()+"&&password="+password.getText().toString();
                    HttpUtil.sendOkHttpRequest(url, new Callback() {

                        private String string;

                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            string = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivityLogin.this, string, Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }
            }
        });


    }
}
