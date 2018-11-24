package com.example.a19093.a002;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lw on 2017/4/14.
 */

public class CountryAdapter extends ArrayAdapter{
    private final int resourceId;

    public CountryAdapter(Context context, int textViewResourceId, List<Country> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Country country = (Country) getItem(position); // 获取当前项的Fruit实例
         View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        TextView countryName =  view.findViewById(R.id.tv_country_name);//获取该布局内的图片视图
        TextView countryNumber =  view.findViewById(R.id.tv_country_number);//获取该布局内的文本视图
        countryName.setText(country.getCountry_name());//为文本视图设置文本内容
        countryNumber.setText(country.getCountry_number());//为文本视图设置文本内容
        return view;
    }
}

