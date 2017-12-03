package com.flagthelogic.testerra;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;


import com.flagthelogic.testerra.database.AppDatabase;


public class App extends Application {

    private static final String TAG = "App";
    private static volatile AppDatabase db = null;
    private static Context mContext;

    public static AppDatabase getDB() {
        if (db == null) {
            Log.e(TAG, "DB == null. Building DB");
            db = Room
                    .databaseBuilder(getContext(), AppDatabase.class, "db.name")
                    .addMigrations(AppDatabase.MIGRATION_3_4, AppDatabase.MIGRATION_4_5)
                    .build();
        }
        return db;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}

