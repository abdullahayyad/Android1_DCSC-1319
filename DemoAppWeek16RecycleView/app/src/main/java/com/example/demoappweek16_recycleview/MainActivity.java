package com.example.demoappweek16_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input = findViewById(R.id.input);
        Button add = findViewById(R.id.add);

        RecyclerView recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Avatar> avatars = new ArrayList<>();

        avatars.add(new Avatar("Adnan",R.drawable.adnan));
        avatars.add(new Avatar("Conan",R.drawable.conan));
        avatars.add(new Avatar("Lufi",R.drawable.lufi));
        avatars.add(new Avatar("ben",R.drawable.ben));
        avatars.add(new Avatar("remi",R.drawable.remi));

        CustomAdapter adapter = new CustomAdapter(avatars);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClicked(int position) {
                Toast.makeText(MainActivity.this, "Delete :"+position, Toast.LENGTH_SHORT).show();
                avatars.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });





        avatars.get(1).setName("Mohammed");
        adapter.notifyItemChanged(1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                avatars.add(0,new Avatar(text,R.drawable.gambol));

                adapter.notifyItemInserted(0);
            }
        });




    }
}