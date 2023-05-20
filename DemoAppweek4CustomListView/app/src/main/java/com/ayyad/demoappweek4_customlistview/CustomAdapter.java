package com.ayyad.demoappweek4_customlistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {

    ArrayList<String> arrayList = new ArrayList();

    Context context;
    CustomAdapter(Context context){
        this.context = context;

        arrayList.add("Palestine");
        arrayList.add("Egypt");
        arrayList.add("Trkish");
        arrayList.add("Saudi Arabia");
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

       View v =  LayoutInflater.from(context).inflate(R.layout.custom_item,null,false);

       if(i == 0) {
           v.setBackgroundColor(Color.RED);
       }else  if(i == 1){
           v.setBackgroundColor(Color.GREEN);

       }else  if(i == 2){
           v.setBackgroundColor(Color.BLUE);

       }else  if(i == 3){
           v.setBackgroundColor(Color.YELLOW);

       }


        TextView textView = v.findViewById(R.id.text);
        textView.setText(arrayList.get(i));
        textView.setTextSize(30);
        return v;
    }




















    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
