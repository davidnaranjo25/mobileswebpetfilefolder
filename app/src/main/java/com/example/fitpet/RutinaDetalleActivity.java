package com.example.fitpet;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RutinaDetalleActivity extends AppCompatActivity {
    private TextView txtTitulo;
    private TextView txtDescripcion;
    private ImageView imgTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_detalle);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        imgTitulo = findViewById(R.id.imgTitulo);

        String rutinaId = getIntent().getStringExtra("archivoRutina");
        Rutina rutina = RutinaData.rutinas.get(rutinaId);

        if (rutina != null) {
            txtTitulo.setText(rutina.nombre);
            txtDescripcion.setText(rutina.descripcion);
            imgTitulo.setImageResource(rutina.imagenResId);
        } else {
            txtTitulo.setText("Rutina no encontrada");
        }
    }
}