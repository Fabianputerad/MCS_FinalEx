package com.example.project_uas_mcs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_uas_mcs.Model.Data;
import com.example.project_uas_mcs.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Data> datas;

    public Adapter(Context ctx, List<Data> datas) {
        this.inflater = LayoutInflater.from(ctx);
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_listlayout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(datas.get(position).getTitle());
        holder.body.setText(datas.get(position).getBody());
        holder.userID.setText(datas.get(position).getUserId());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, body, userID;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.Title);
            body = itemView.findViewById(R.id.body);
            userID = itemView.findViewById((R.id.userId));
        }
    }

}
