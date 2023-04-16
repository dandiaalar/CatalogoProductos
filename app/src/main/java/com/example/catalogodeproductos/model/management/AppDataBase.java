package com.example.catalogodeproductos.model.management;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.catalogodeproductos.model.pojos.Criteria;

@Database(
        entities = {Criteria.class},
        version = 1
)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase database;
    private static String DATABASE_NAME = "testdb";

    public synchronized static AppDataBase getInstance(Context context){

        if (database == null){

            database = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return database;
    }
    public abstract DaoCriteria daoCriteria();
}
