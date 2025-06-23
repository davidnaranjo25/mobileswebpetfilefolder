package com.example.fitpet;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {UserEntity.class}, version = 2)
public abstract class FitPetDatabase extends RoomDatabase {
    private static volatile FitPetDatabase INSTANCE;

    public abstract UserDao userDao();

    public static FitPetDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (FitPetDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    FitPetDatabase.class,
                                    "fitpet_db")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries() // Solo para pruebas, quítalo en producción
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    // Inserta el super admin usando SQL directo
                                    db.execSQL("INSERT INTO users (nombre, correo, password, rol, aprobado) " +
                                            "VALUES ('Super Admin', 'admin@fitpet.com', 'admin123', 'admin', 1)");
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}