package com.example.demoappweek15_externaldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MessageDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_details);
        String catName =  getIntent().getStringExtra("name");
        int catId = getIntent().getIntExtra("id",0);
        getSupportActionBar().setTitle(catName);
        ListView listView = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);


        MyDB myDB = new MyDB(this);
        SQLiteDatabase db = myDB.getReadableDatabase();
        Cursor cursor = db.query("msgs",null,"cat = ?",new String[]{catId+""},null,null,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            @SuppressLint("Range") String message = cursor.getString(cursor.getColumnIndex("msg"));

            adapter.add(message);
            Log.e("message",message);
            cursor.moveToNext();
        }

        cursor.close();
        myDB.close();

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
               String value = adapterView.getItemAtPosition(index).toString();


            }
        });
    }
}