package com.example.demoappweek8_activitylifecyclesaveinstance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    int x = 0;
    TextView textCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        Log.e("Life Cycle","onCreate");
        textCount = findViewById(R.id.txt_count);


        Button button = findViewById(R.id.btn_count);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x += 1;
                textCount.setText(x+"");
            }
        });
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null) {
            x = savedInstanceState.getInt("count");
            textCount.setText(x + "");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count",x);
    }
}