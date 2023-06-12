package com.example.pruebas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;

    ArrayList<Luchador> list;  // simulacion de la clase User


    public MyAdapter(Context context, ArrayList<Luchador> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static  class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView id, nombre; 

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
