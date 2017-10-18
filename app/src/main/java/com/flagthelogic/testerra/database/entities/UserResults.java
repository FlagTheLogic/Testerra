package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Volodymyr Nahorny on:
 Lenovo
 18.10.2017
 */
@Entity(tableName = "user_results",
        indices = {@Index(value = "id", unique = true)})
public class UserResults {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "test_id")
    private int tId;
    @ColumnInfo(name = "result_id")
    private int rId;
}
