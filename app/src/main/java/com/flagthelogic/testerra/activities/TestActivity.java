package com.flagthelogic.testerra.activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flagthelogic.testerra.R;
import com.flagthelogic.testerra.database.TesterraDBHelper;

public class TestActivity extends AppCompatActivity {
    TesterraDBHelper dbHelper = new TesterraDBHelper(getApplicationContext());
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        sqLiteDatabase = dbHelper.getWritableDatabase();


    }
}
