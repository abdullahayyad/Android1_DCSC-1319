package com.ayyad.demoappweek5_customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;





public class MainActivity extends AppCompatActivity {
    ArrayList<Country> countries = new ArrayList<>();
//    ArrayList<String> countryName = new ArrayList<>();
//    ArrayList<Integer> countryImage = new ArrayList<>();
//    ArrayList<String> countryCapitalName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        countryName.add("Palestine");
//        countryName.add("Egypt");
//        countryName.add("Turkish");
//        countryName.add("Saudi Arabia");
//
//        countryImage.add(R.drawable.img_flag_palstine);
//        countryImage.add(R.drawable.img_flag_egypt);
//        countryImage.add(R.drawable.img_flag_turkish);
//        countryImage.add(R.drawable.img_flag_saudi_arabia);
//
//        countryCapitalName.add("Alquds");
//        countryCapitalName.add("Istunbule");
//        countryCapitalName.add("Ryaad");
//        countryCapitalName.add("Cairo");
        countries.add(new Country("Palestine","Alquds",R.drawable.img_flag_palstine));
        countries.add(new Country("Egypt","Cairo",R.drawable.img_flag_egypt));
        countries.add(new Country("Turkish","Istunbule",R.drawable.img_flag_turkish));
        countries.add(new Country("Saudi Arabia","Ryaad",R.drawable.img_flag_saudi_arabia));

        ListView listView = findViewById(R.id.list_countries);
        CustomAdapter adapter = new CustomAdapter(this,countries);
        listView.setAdapter(adapter);
    }
}