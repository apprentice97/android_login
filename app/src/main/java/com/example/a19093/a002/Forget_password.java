package com.example.a19093.a002;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Forget_password extends AppCompatActivity  implements View.OnClickListener{
    private TextView tv_login_select_text;
    private ImageView ig_greater;
    private TextView et_text;
    private TextView tv_forget_password;
    private TextView title_text;
    private Button bt_complete;
    private EditText password1;
    private EditText password2;
    private EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ImageView re_back = findViewById(R.id.title_back);
        re_back.setOnClickListener(this);
        ig_greater = findViewById(R.id.select_country);

        tv_login_select_text = findViewById(R.id.tv_login_select_text);
        tv_forget_password = findViewById(R.id.tv_forget_password);
        et_text = findViewById(R.id.et_text);

        title_text = findViewById(R.id.title_text);
        title_text.setText("忘记密码");

        bt_complete = findViewById(R.id.bt_complete);
        bt_complete.setOnClickListener(this);

        tv_login_select_text.setText("阿尔巴尼亚+00355");
        ig_greater.setOnClickListener(this);
        tv_forget_password.setOnClickListener(this);

        password1 = findViewById(R.id.password1);
        password2 = findViewById(R.id.password2);
        number = findViewById(R.id.number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                Intent intent = new Intent(Forget_password.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.select_country:
                intent =   new Intent(Forget_password.this, Select_country.class);
                startActivityForResult(intent,1);
                break;
            case R.id.tv_forget_password:
                int x = 9;
                String text = "";
                Random random = new Random();
                for(int i = 0; i < 6; i ++){
                    text += ""+random.nextInt(x);
                }
                Log.e("tv_forget_password", "text");
                et_text.setText(text);
                break;
            case R.id.bt_complete:
                String s1;
                String s2;
                String s3;
                s1 = password1.getText().toString();
                s2 = password2.getText().toString();
                s3 = number.getText().toString();
                Log.e("TAG", s1 + s2);
                if(s1.equals(s2) && s1.length() <= 20 && s1.length() >= 6 && !s3.equals("")){
                    Toast.makeText(this, "重设密码成功！", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this, "重设密码失败！", Toast.LENGTH_LONG).show();
                }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("结果",requestCode+"");
        String text;
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