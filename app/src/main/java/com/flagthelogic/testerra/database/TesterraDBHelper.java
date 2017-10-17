package com.flagthelogic.testerra.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Volodymyr Nahornyi on
 device: Lenovo
 date: 15.10.2017.
 */

public class TesterraDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Testerra.db";

    public TesterraDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public TesterraDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TesterraContract.SQL_CREATE_TESTS);
        sqLiteDatabase.execSQL(TesterraContract.SQL_CREATE_OPTIONS);
        sqLiteDatabase.execSQL(TesterraContract.SQL_CREATE_RESULTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TesterraContract.SQL_DROP_TESTS);
        sqLiteDatabase.execSQL(TesterraContract.SQL_DROP_QUESTIONS);
        sqLiteDatabase.execSQL(TesterraContract.SQL_DROP_RESULTS);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
