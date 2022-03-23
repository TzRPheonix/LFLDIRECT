package com.example.myapplication.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

// ....

    public MyDatabaseHelper(Context context) {
        super(context, "DATABASE_NAME", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // Script to create table.
        String script = "CREATE TABLE " + "Utilisateurs" + "("
                + "COLUMN_NOTE_ID" + " INTEGER PRIMARY KEY," + "COLUMN_NOTE_TITLE" + " TEXT,"
                + "COLUMN_NOTE_CONTENT" + " TEXT" + ")";
        // Execute script.
        db.execSQL(script);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop table
        db.execSQL("DROP TABLE IF EXISTS " + "Utilisateurs");


        // Recreate
        onCreate(db);
    }
}
// .