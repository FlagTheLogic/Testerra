package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tests", indices = {@Index(value = "id", unique = true)})
public class Tests {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    @ColumnInfo(name = "")
    private String title;
    @ColumnInfo(name = "")
    private String author;
    @ColumnInfo(name = "")
    private String description;
    @ColumnInfo(name = "")
    private String testCompleted;
    @ColumnInfo(name = "")
    private String category;
    @ColumnInfo(name = "")
    private String params;
    @ColumnInfo(name = "")
    private String logicType;
    @ColumnInfo(name = "")
    private String instruction;
}
