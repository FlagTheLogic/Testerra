package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.flagthelogic.testerra.database.converters.DateConverter;

import java.util.Date;

/**
 * Created by Volodymyr Nahorny on:
 * device: Lenovo
 * date: 18.10.2017
 */
@Entity(tableName = "user_results", indices = {@Index(value = "id", unique = true)})
@TypeConverters({DateConverter.class})
public class UserResults {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "test_id")
    private int tId;
    @ColumnInfo(name = "result_id")
    private int rId;
    @ColumnInfo
    private Date when_added;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getWhen_added() {
        return when_added;
    }

    public void setWhen_added(Date when_added) {
        this.when_added = when_added;
    }
}
