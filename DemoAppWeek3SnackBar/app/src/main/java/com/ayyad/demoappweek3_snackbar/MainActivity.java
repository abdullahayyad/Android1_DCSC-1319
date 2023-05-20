package com.ayyad.demoappweek3_snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "Hello", Snackbar.LENGTH_LONG);
                snackbar.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println("Clicked");
                    }
                });


                snackbar.getView().setBackgroundColor(Color.RED);

                snackbar.setActionTextColor(Color.YELLOW);
//                snackbar.getView().findViewById(android.support.design.R.id.snackbar_text)
                snackbar.show();
            }
        });
    }


    void sum() {
    }

    void sum(int x) {

    }
}