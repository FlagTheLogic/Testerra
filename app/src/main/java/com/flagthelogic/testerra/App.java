package com.flagthelogic.testerra;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import com.flagthelogic.testerra.database.AppDatabase;
import com.flagthelogic.testerra.objs.Option;
import com.flagthelogic.testerra.objs.Question;
import com.flagthelogic.testerra.objs.Test;


public class App {
    private static final String TAG = "App";
    private static AppDatabase db = null;

    public App(Context appContext) {
        db = Room
                .databaseBuilder(appContext, AppDatabase.class, "db.name")
                .addMigrations(AppDatabase.MIGRATION_3_4, AppDatabase.MIGRATION_4_5)
//                    .allowMainThreadQueries(
//                    .fallbackToDestructiveMigration()
                .build();
        if (db.isOpen()) {
            Log.e(TAG+" constructor", "db OPENED");
        }
    }


    public static AppDatabase getDb(Context appContext) {
        if (db == null) {
            Log.e(TAG, "1st getDB() call. Building DB");
            db = Room
                    .databaseBuilder(appContext, AppDatabase.class, "db.name")
                    .addMigrations(AppDatabase.MIGRATION_3_4, AppDatabase.MIGRATION_4_5)
//                    .allowMainThreadQueries(
//                    .fallbackToDestructiveMigration()
                    .build();
            if (db.isOpen()) {
                Log.e(TAG, "db OPENED");
            }
        }
        return db;
    }
}

