package com.example.demoapp_week14_database;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDB myDB;
    ImageView imgProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new MyDB(MainActivity.this);


        EditText nameEdit = findViewById(R.id.edit_name);
        EditText editAge = findViewById(R.id.edit_age);
        Button addButton = findViewById(R.id.btn_insert);

         imgProfile = findViewById(R.id.img_profile);


        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");

                startActivityForResult(intent,111);
            }
        });
//
//        MyDB myDB1 = new MyDB(this);
//        SQLiteDatabase db = myDB1.getWritableDatabase();
//
//        db.execSQL("insert into student values('Salim',22);");
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name","salim");
//        contentValues.put("age",22);
//
//        db.insert("student",null,contentValues);
//
//


        getStudentData();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEdit.getText().toString();
                int age = Integer.parseInt( editAge.getText().toString());

                Bitmap bitmap = ((BitmapDrawable) imgProfile.getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,30,byteArrayOutputStream);



                if(myDB.insertStudent(name,age,byteArrayOutputStream.toByteArray())){
                    Toast.makeText(MainActivity.this, "Data was added successfully", Toast.LENGTH_SHORT).show();
                }
                getStudentData();
                nameEdit.setText("");
                editAge.setText("");
                imgProfile.setImageBitmap(null);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.close();

    }

    void getStudentData(){
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Avatar> avatars = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDB.getReadableDatabase();

        Cursor cursor1 =  sqLiteDatabase.rawQuery("select * from student",null);

//        Cursor cursor2 =  sqLiteDatabase.query("student",null,null,null,null,null,null);

        cursor1.moveToFirst();
        while (!cursor1.isAfterLast()){
            int id = cursor1.getInt(0);
            String name = cursor1.getString(1);
            int age = cursor1.getInt(2);
            byte[] image = cursor1.getBlob(3);



            avatars.add(new Avatar(name,image));
            cursor1.moveToNext();
        }

        cursor1.close();

        CustomAdapter adapter = new CustomAdapter(avatars);

        recyclerView.setAdapter(adapter);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data.getData() !=null) {
            imgProfile.setImageURI(data.getData());
        }
    }
}