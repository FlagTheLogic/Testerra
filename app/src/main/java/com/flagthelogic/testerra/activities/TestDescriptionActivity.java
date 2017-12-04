package com.flagthelogic.testerra.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.flagthelogic.testerra.App;
import com.flagthelogic.testerra.R;
import com.flagthelogic.testerra.database.entities.Test;

import static com.flagthelogic.testerra.App.DEFAULT_TID;

public class TestDescriptionActivity extends AppCompatActivity {

    private Test test;
    private int tid;
    private String TAG = "TEST DESCRIPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_description);
        Intent intent = getIntent();
        tid = intent.getIntExtra("tid", DEFAULT_TID);

        new Thread(new Runnable() {
            @Override
            public void run() {
                test = App.getDB().testsDao().getTestById(tid);
                fillViews();
            }
        }).start();
    }

    void fillViews() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "ACTIVITY CHANGE - to Test description");

            }
        });
    }
}
