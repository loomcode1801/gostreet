package com.example.pruebas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;

    ArrayList<Luchador> list;  // simulacion de la clase User en este caso luchador


    public MyAdapter(Context context, ArrayList<Luchador> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent, false);   // se modifica este
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Luchador luchador = list.get(position);

        holder.id.setText(String.valueOf(luchador.getId() + "prueba"));
        holder.nombre.setText(luchador.getNombre());


    }

    @Override
    public int getItemCount() {
        return list.size();   // se modifica este
    }

    public  static  class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView id, nombre;    // se modifica este

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.tvfirstName);       //se modifica estos dos
            nombre = itemView.findViewById(R.id.tvlastName);
        }
    }

}
