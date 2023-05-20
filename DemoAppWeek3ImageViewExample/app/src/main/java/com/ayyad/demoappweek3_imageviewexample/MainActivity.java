package com.ayyad.demoappweek3_imageviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgBackground = findViewById(R.id.img_background);

        imgBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBackground.setImageResource(R.drawable.back1);
            }
        });


    }
}