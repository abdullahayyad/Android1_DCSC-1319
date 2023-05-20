package com.ayyad.demoappweek1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edit33);
        TextView textView = findViewById(R.id.txtView1);
        Button buttonChange = findViewById(R.id.btn_change);



        textView.setText("مرحبا بك");
        textView.setTextColor(Color.RED);
        textView.setTextSize(32f);


        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = editText.getText().toString();

                textView.setTextColor(Color.YELLOW);

                textView.setText(result);
            }
        });


    }
}