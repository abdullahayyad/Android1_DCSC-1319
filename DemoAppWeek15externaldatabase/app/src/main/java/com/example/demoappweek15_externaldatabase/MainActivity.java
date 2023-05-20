package com.example.demoappweek15_externaldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<Category> adapter = new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1);


        MyDB myDB = new MyDB(this);
        SQLiteDatabase  sqLiteDatabase = myDB.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query("category",null,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
           int id = cursor.getInt(cursor.getColumnIndex("cat_id"));
           String catName = cursor.getString(cursor.getColumnIndex("cat_name"));

           Category category = new Category(id,catName);

            adapter.add(category);
            cursor.moveToNext();
        }
        cursor.close();
        myDB.close();

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Category category = (Category) adapterView.getItemAtPosition(index);

                Toast.makeText(MainActivity.this, category.name, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this,MessageDetailsActivity.class);
                i.putExtra("name",category.name);
                i.putExtra("id",category.id);
                startActivity(i);
            }
        });
    }
}