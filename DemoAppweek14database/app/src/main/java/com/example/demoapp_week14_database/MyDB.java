package com.example.demoapp_week14_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDB extends SQLiteOpenHelper {

    public MyDB(Context context) {
        super(context, "school", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table student(id INTEGER primary key autoincrement," +
                " name TEXT not null,age INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("Alter table student add column(status INTEGER);");
    }



    boolean insertStudent(String name,int age){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        sqLiteDatabase.execSQL("Insert Into student(age,name) values ("+age+",'"+name+"');");
        ContentValues contentValues =new ContentValues();
        contentValues.put("age",age);
        contentValues.put("name",name);
        long result = sqLiteDatabase.insert("student",null,contentValues);

        sqLiteDatabase.close();

        return result > 0;
    }
}
