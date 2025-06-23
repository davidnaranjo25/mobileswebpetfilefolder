package com.example.fitpet;

import java.util.HashMap;
import java.util.Map;

public class RutinaData {
    // Mapa de rutinas por nombre/ID
    public static Map<String, Rutina> rutinas = new HashMap<>();

    static {
        rutinas.put("rutina1", new Rutina(
                "Cardio fácil",
                "Ideal para mascotas enérgicas.",
                R.drawable.casa // Asume que tienes esta imagen en res/drawable
        ));
        rutinas.put("rutina2", new Rutina(
                "Yoga canino",
                "Ejercicios suaves para relajación.",
                R.drawable.casa // Asume que tienes esta imagen en res/drawable
        ));
        rutinas.put("rutina3", new Rutina(
                "Yoga canino",
                "Ejercicios suaves para relajación.",
                R.drawable.paseomascota // Asume que tienes esta imagen en res/drawable
        ));
        // Agrega más rutinas aquí...
    }
}
