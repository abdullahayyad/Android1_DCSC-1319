package com.example.demoappweek8_activitylifecyclesaveinstance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String TAG = "LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go = findViewById(R.id.btn_go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        Log.e(TAG,"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");

    }
}