package com.example.project_uas_mcs;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project_uas_mcs.Database.DatabaseHelper;
import com.example.project_uas_mcs.Database.NotifHelper;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<String> title, msg;
    NotifHelper db;
    AdapterNotif adapterNotif;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_notification, container, false);

        db = new NotifHelper(this.getActivity());
        title = new ArrayList<>();
        msg = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycleNotif);
        adapterNotif = new AdapterNotif(this.getActivity(), title, msg);
        recyclerView.setAdapter(adapterNotif);
        adapterNotif.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        displaydata();
        return view;
    }
    private void displaydata() {
        Cursor cursor = db.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(this.getActivity(), "No Data", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                title.add(cursor.getString(1));
                msg.add(cursor.getString(2));
            }
        }
    }
}