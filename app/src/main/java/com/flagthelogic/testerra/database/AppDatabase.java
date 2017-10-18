package com.flagthelogic.testerra.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.flagthelogic.testerra.database.entities.Questions;
import com.flagthelogic.testerra.database.entities.Results;
import com.flagthelogic.testerra.database.entities.Tests;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 18.10.17.
 */
@Database(entities = {Tests.class, Questions.class, Results.class}, version = 1)
public class AppDatabase extends RoomDatabase {

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
