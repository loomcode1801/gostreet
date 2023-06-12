package clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project122.R;

import java.util.ArrayList;

public class AdapterBonos extends RecyclerView.Adapter<AdapterBonos.MyViewHolder> {

    Context context;

    ArrayList<Bonos> list;  // simulacion de la clase User en este caso luchador

    public AdapterBonos(Context context, ArrayList<Bonos> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardbono,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Bonos bonos = list.get(position);
        holder.fechaInicio.setText(bonos.getFechaInicio());
        holder.descripcion.setText(bonos.getDescripcion());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fechaInicio, fechaFinal, horaInicio, horaFin, cantidad, descuento, precio, descripcion;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fechaInicio = itemView.findViewById(R.id.tvfechaInicio);
            descripcion = itemView.findViewById(R.id.tvDescripcion);

        }


    }





}
