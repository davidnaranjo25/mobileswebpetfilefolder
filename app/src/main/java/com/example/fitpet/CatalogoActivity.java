package com.example.fitpet;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatalogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        RecyclerView recyclerView = findViewById(R.id.recyclerRutinas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lista de rutinas de ejemplo (imágenes locales en drawable)
        List<Rutina> rutinas = new ArrayList<>();
        rutinas.add(new Rutina("Rutina de paseo", "Lleva a tu mascota a caminar por el parque durante 20 minutos.", R.drawable.paseomascota));
        rutinas.add(new Rutina("Rutina activa", "Juega a la pelota durante 10 minutos con tu mascota.", R.drawable.casa));
        rutinas.add(new Rutina("Ejercicio en casa", "Rutina de movilidad dentro del hogar.", R.drawable.casa));

        RutinaAdapter adapter = new RutinaAdapter(this, rutinas);
        recyclerView.setAdapter(adapter);
    }
}