package com.example.project_uas_mcs.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String CREATE_TABLE = "CREATE TABLE notifikasi (id integer PRIMARY KEY AUTOINCREMENT," +
            "title TEXT NOT NULL," + "body TEXT NOT NULL);";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "UASMCS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notifikasi");
    }
}
