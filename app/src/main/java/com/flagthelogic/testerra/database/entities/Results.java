package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 18.10.17.
 */
@Entity(tableName = "results",
        indices = {@Index(value = "result_id", unique = true)})
public class Results {
    @PrimaryKey
    @ColumnInfo(name = "test_id")
    private int tId;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id")
    private int rId;
    @ColumnInfo(name = "value")
    private String value;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
