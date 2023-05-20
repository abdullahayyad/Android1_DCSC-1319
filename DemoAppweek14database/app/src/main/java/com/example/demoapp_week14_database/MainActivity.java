package com.example.demoapp_week14_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDB myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new MyDB(MainActivity.this);


        EditText nameEdit = findViewById(R.id.edit_name);
        EditText editAge = findViewById(R.id.edit_age);
        Button addButton = findViewById(R.id.btn_insert);
        getStudentData();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEdit.getText().toString();
                int age = Integer.parseInt( editAge.getText().toString());
                if(myDB.insertStudent(name,age)){
                    Toast.makeText(MainActivity.this, "Data was added successfully", Toast.LENGTH_SHORT).show();
                }
                getStudentData();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.close();

    }

    void getStudentData(){
        ListView listView = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        SQLiteDatabase sqLiteDatabase = myDB.getReadableDatabase();

        Cursor cursor1 =  sqLiteDatabase.rawQuery("select * from student",null);

//        Cursor cursor2 =  sqLiteDatabase.query("student",null,null,null,null,null,null);

        cursor1.moveToFirst();
        while (!cursor1.isAfterLast()){
            int id = cursor1.getInt(0);
            String name = cursor1.getString(1);
            int age = cursor1.getInt(2);

            adapter.add(name);
            cursor1.moveToNext();
        }

        cursor1.close();
        listView.setAdapter(adapter);


    }
}