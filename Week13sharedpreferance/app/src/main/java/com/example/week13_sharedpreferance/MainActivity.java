package com.example.week13_sharedpreferance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);



        SharedPreferences preferences = getSharedPreferences("my_prefrence",MODE_PRIVATE);
        EditText editNote = findViewById(R.id.ed_note);
        Button btnSave = findViewById(R.id.btn_save);
        Button btnLoad = findViewById(R.id.btn_load);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SharedPreferences.Editor editor =  preferences.edit();
                editor.putString("note",editNote.getText().toString());
                editor.commit();
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = preferences.getString("note","");
                editNote.setText(note);
            }
        });
    }

   void setLocal(){
        Locale locale = new Locale("ar");
       Resources resources = getResources();
       Configuration configuration = resources.getConfiguration();
       configuration.setLocale(locale);
       resources.updateConfiguration(configuration,resources.getDisplayMetrics());
    }
}