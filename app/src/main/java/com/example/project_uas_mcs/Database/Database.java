package com.example.project_uas_mcs.Database;

import android.content.Context;

import com.example.project_uas_mcs.Data;
import com.example.project_uas_mcs.Model.Notif;

import java.util.Vector;

public class Database {

    public static Database instance;
    private NotifHelper notifHelper;

    private Database(Context context){
        notifHelper = new NotifHelper(context);
    }

    public static Database getInstance(Context context){
        if (instance == null) {

            synchronized (Database.class){
                if(instance==null){
                    instance = new Database(context);
                }
            }
        }
        return instance;
    }
    public Vector<Notif> getAllNotif(){
        return  notifHelper.getAllNotif();
    }

    public void insertNotif(String title, String msg){
        notifHelper.insertNotifs(title, msg);
    }
}
