package com.example.demoappweek7_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isClausius = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void updateScreen() {
        TextView textView = findViewById(R.id.txt);
        if(isClausius){
            textView.setText("F to C");
        }else{
            textView.setText("C to F");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.tempreture_convert){
            if(isClausius){
                item.setTitle("F to C");
                isClausius = false;
            }else{
                item.setTitle("C to F");
                isClausius = true;
            }
        }

        updateScreen();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


}