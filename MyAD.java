package com.example.registrationpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAD extends RecyclerView.Adapter<MyAD.MyViewholder> {
    private Context context ;
    private ArrayList name_id,dob_id,email_id ;

    public MyAD(Context context, ArrayList name_id, ArrayList dob_id, ArrayList email_id) {
        this.context = context;
        this.name_id = name_id;
        this.dob_id = dob_id;
        this.email_id = email_id;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false) ;
        return new MyViewholder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.dob_id.setText(String.valueOf(dob_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView name_id, dob_id, email_id ;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.textname);
            dob_id = itemView.findViewById(R.id.textDOB);
            email_id = itemView.findViewById(R.id.textEmail);
        }
    }
}
