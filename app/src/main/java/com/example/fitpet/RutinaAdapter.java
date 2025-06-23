package com.example.fitpet;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitpet.R;

import java.util.List;

public class RutinaAdapter extends RecyclerView.Adapter<RutinaAdapter.ViewHolder> {

    private final List<Rutina> lista;
    private final Context context;

    public RutinaAdapter(Context context, List<Rutina> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public RutinaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rutina, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RutinaAdapter.ViewHolder holder, int position) {
        Rutina rutina = lista.get(position);
        holder.txtNombre.setText(rutina.nombre);
        holder.imgRutina.setImageResource(rutina.imagenResId);

        holder.btnVerDetalles.setOnClickListener(view -> {
            // Muestra un AlertDialog simple con la descripción (detalle) de la rutina
            new AlertDialog.Builder(context)
                    .setTitle(rutina.nombre)
                    .setMessage(rutina.descripcion)
                    .setPositiveButton("Cerrar", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRutina;
        TextView txtNombre;
        Button btnVerDetalles;

        ViewHolder(View itemView) {
            super(itemView);
            imgRutina = itemView.findViewById(R.id.imgRutina);
            txtNombre = itemView.findViewById(R.id.txtNombreRutina);
            btnVerDetalles = itemView.findViewById(R.id.btnVerDetalles);
        }
    }
}