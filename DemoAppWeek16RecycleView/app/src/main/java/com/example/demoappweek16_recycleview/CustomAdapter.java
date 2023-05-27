package com.example.demoappweek16_recycleview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

interface OnItemClickListener{
    void onItemClick(int position);
    void onDeleteClicked(int position);
}

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {



    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    ArrayList<Avatar> avatars;
    CustomAdapter(ArrayList<Avatar> avatars ){
        this.avatars = avatars;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Avatar avatar = avatars.get(position);
        holder.imageView.setImageResource(avatar.getImage());
        holder.textView.setText(avatar.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });


        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onDeleteClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return avatars.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        ImageView deleteImageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.txt_name);
            deleteImageView = itemView.findViewById(R.id.delete_img);

        }
    }
}




