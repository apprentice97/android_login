package com.example.a19093.a002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private TextView tv_forget_password;
    private Button bt_register;
    private Button bt_login;
    private ImageView ig_greater;
    private TextView tv_login_select_text;
    private String text;
    private TextView title_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        bindView();
        title_text = findViewById(R.id.title_text);
        title_text.setText("登录");
    }

    void bindView()
    {
        tv_forget_password = findViewById(R.id.tv_forget_password);
        bt_register = findViewById(R.id.bt_register);
        bt_login = findViewById(R.id.bt_login);
        ig_greater = findViewById(R.id.select_country);
        tv_login_select_text = findViewById(R.id.tv_login_select_text);
        tv_forget_password.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        ig_greater.setOnClickListener(this);
        tv_login_select_text.setText("阿尔巴尼亚+00355");
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId())
        {
            case R.id.tv_forget_password:
                intent=   new Intent(MainActivity.this, Forget_password.class);
                startActivity(intent);
                break;
            case R.id.bt_login:
                Toast.makeText(this, "系统繁忙，请稍后重试......", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_register:
                intent =   new Intent(MainActivity.this, Register.class);
                startActivity(intent);
                break;
            case R.id.select_country:
                intent =   new Intent(MainActivity.this, Select_country.class);
                startActivityForResult(intent,1);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("结果",requestCode+"");
        if(requestCode == 1){
                text = "";
                Log.e("结果",text);
                text += data.getStringExtra("country_name");
                text += data.getStringExtra("country_number");
                tv_login_select_text.setText(text);
                Log.e("结果",text);
        }
    }
}
