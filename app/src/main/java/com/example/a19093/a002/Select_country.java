package com.example.a19093.a002;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Select_country extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemClickListener{
    private List<Country> countryList = new ArrayList<Country>();
    String[] string_country_name;
    String[] string_country_number;
    String order_country_name = "";
    String order_country_number = "";
    TextView title_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_country);
        initCountry();
        CountryAdapter adapter = new CountryAdapter(Select_country.this, R.layout.item_country,countryList);
        ListView listView = findViewById(R.id.list_view);
        ImageView re_back = findViewById(R.id.title_back);
        re_back.setOnClickListener(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        title_text = findViewById(R.id.title_text);
        title_text.setText("选择国家和地区");

    }

    private void initCountry(){
        Resources resources= this.getResources();
        string_country_name = resources.getStringArray(R.array.string_country_name);
        string_country_number = resources.getStringArray(R.array.string_country_number);
        int count = string_country_name.length;
        for(int i = 0; i < count; i ++){
            String s1 = string_country_name[i];
            String s2 = string_country_number[i];
            Country country = new Country(s1,s2);
            countryList.add(country);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                Intent intent = new Intent(Select_country.this, MainActivity.class);
                intent.putExtra("country_name", order_country_name);
                intent.putExtra("country_number", order_country_number);
                Log.e("发送", order_country_name);
                Log.e("发送", order_country_number);
                setResult(1,intent);
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //大多数情况下，position和id相同，并且都从0开始
        String showText = "选择了" + string_country_name[position] + " " + string_country_number[position];
        order_country_name = string_country_name[position];
        order_country_number = string_country_number[position];
        Toast.makeText(this, showText, Toast.LENGTH_LONG).show();
    }

}