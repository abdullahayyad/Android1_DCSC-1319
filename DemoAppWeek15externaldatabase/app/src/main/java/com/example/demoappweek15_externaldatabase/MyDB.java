package com.example.demoappweek15_externaldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDB extends SQLiteAssetHelper {
    public MyDB(Context context) {
        super(context, "msgdb", null  , 1);
    }
}
