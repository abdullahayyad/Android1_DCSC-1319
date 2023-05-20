package com.ayyad.demoappweek5_customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {

    ArrayList<Country> countries;
    Context context;
    public CustomAdapter(Context context, ArrayList<Country> countries) {
        this.context = context;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.country_item,null,false);

        TextView textName = v.findViewById(R.id.txt_name);
        TextView textCapital = v.findViewById(R.id.txt_capital);
        ImageView imageFlag = v.findViewById(R.id.img_flag);

        String name = countries.get(i).name;
        int flag = countries.get(i).flagImage;
        String capital = countries.get(i).capital;

        textName.setText(name);
        textCapital.setText(capital);
        imageFlag.setImageResource(flag);

        return v;
    }










    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
}
