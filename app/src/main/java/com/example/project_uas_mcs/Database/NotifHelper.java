package com.example.project_uas_mcs.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.project_uas_mcs.Model.Notif;

import java.util.Vector;

public class NotifHelper {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final String TABLE_NAME = "notifikasi";

    public NotifHelper(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public Vector<Notif> getAllNotif(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM notifikasi", null);
        Vector<Notif> notifs = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Notif notif = new Notif();
            notif.setId(cursor.getInt(0));
            notif.setTitle(cursor.getString(1));
            notif.setBody(cursor.getString(1));
            notifs.add(notif);
            cursor.moveToNext();
        }
        db.close();
        return notifs;


    }
    public void insertNotifs(String title, String msg){
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("body", msg);

        db.insert(TABLE_NAME, null, values);
        db.close();

    }
    public Cursor getdata(){
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from notifikasi", null);
        return cursor;

    }
}
