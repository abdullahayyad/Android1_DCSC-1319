package com.ayyad.demoappweek4_customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner listView = findViewById(R.id.listview);
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Palestine");
//        arrayList.add("Egypt");
//        arrayList.add("Turkish");
//        arrayList.add("Saudi Arabia");



//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_item,arrayList);

        CustomAdapter adapter = new CustomAdapter(this);


        listView.setAdapter(adapter);

//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
//                Toast.makeText(MainActivity.this, ""+index, Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}