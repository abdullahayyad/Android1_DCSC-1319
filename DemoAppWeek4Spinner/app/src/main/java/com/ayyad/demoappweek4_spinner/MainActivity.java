package com.ayyad.demoappweek4_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner_language);
        TextView textView = findViewById(R.id.txt_result);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int index, long id) {

                textView.setText(spinner.getItemAtPosition(index).toString());
                Toast.makeText(MainActivity.this, "" +  spinner.getItemAtPosition(index), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        Spinner spinnerCode = findViewById(R.id.spinner_language_code);


        ArrayList<String> languages = new ArrayList<>();
        languages.add("C#");
        languages.add("PHP");

        //ArrayAdapter

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,languages);

        spinnerCode.setAdapter(adapter);







    }
}