package com.ayyad.demoappweek3_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radio_group_gender);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if(id == R.id.radio_male){
                    Toast.makeText(MainActivity.this, "Male Selected", Toast.LENGTH_SHORT).show();
                }else if (id == R.id.radio_female){
                    Toast.makeText(MainActivity.this, "Female Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });


        CheckBox checkJava = findViewById(R.id.check_java);
        CheckBox checkPHP = findViewById(R.id.check_php);
        CheckBox checkKotlin = findViewById(R.id.check_kotlin);

        checkJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean result) {
                Toast.makeText(MainActivity.this, "JAVA :"+result, Toast.LENGTH_SHORT).show();
            }
        });


        checkPHP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean result) {
                Toast.makeText(MainActivity.this, "PHP :"+result, Toast.LENGTH_SHORT).show();
            }
        });



    }
}