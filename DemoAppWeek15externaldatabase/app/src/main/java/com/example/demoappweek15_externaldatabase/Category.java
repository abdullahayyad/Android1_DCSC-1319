package com.example.demoappweek15_externaldatabase;

import androidx.annotation.NonNull;

public class Category {
    int id;
    String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
