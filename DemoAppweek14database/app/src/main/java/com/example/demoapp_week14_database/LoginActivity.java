package com.example.demoapp_week14_database;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    MyDB myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myDB = new MyDB(this);



//        SQLiteDatabase db = myDB.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name","Ahmed");
//        contentValues.put("age",22);
//        contentValues.put("username","120220001");
//        contentValues.put("password","123456");
//
//        db.insert("student",null,contentValues);


        EditText editUsername = findViewById(R.id.username);
        EditText editPassword = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                SQLiteDatabase db = myDB.getReadableDatabase();

                Cursor cursor = db.query("student",null,"username like ? and password like ?", new String[]{username,password},null,null,null,"1");

                if(cursor.getCount() > 0){
                    cursor.moveToFirst();
                    String name = cursor.getString(cursor.getColumnIndex("name"));

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
