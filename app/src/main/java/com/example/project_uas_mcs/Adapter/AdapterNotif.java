package com.example.project_uas_mcs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_uas_mcs.Database.Database;
import com.example.project_uas_mcs.Model.Notif;
import com.example.project_uas_mcs.R;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Vector;

public class AdapterNotif extends RecyclerView.Adapter<AdapterNotif.viewHolder>  {
    private Context context;
    LayoutInflater inflater;
    private ArrayList title, msg;
    Vector<Notif> notifs;

    public AdapterNotif(Context context, ArrayList title, ArrayList msg) {
        this.context = context;
        this.title = title;
        this.msg = msg;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_listnotif,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.title.setText(String.valueOf(title.get(position)));
        holder.msg.setText(String.valueOf(msg.get(position)));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title, msg;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.TitleNotif);
            msg = itemView.findViewById(R.id.MsgNotif);
        }
    }

    public void update(){
        Database database = Database.getInstance(context);
        Vector<Notif> notifs = database.getAllNotif();
        this.notifs = notifs;
        notifyDataSetChanged();
    }
}
