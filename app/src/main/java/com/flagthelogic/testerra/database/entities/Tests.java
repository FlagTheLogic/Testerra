package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tests",indices = {@Index(value = "id", unique = true)})
public class Tests {
    @PrimaryKey
    private int id = 0;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "author")
    private String author;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "test_completed")
    private int testCompleted;
    @ColumnInfo(name = "category")
    private int category;
    @Embedded
    @ColumnInfo(name = "parameters")
    private Params params;
    @ColumnInfo(name = "logic_type")
    private int logicType;
    @ColumnInfo(name = "instruction")
    private String instruction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTestCompleted() {
        return testCompleted;
    }

    public void setTestCompleted(int testCompleted) {
        this.testCompleted = testCompleted;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public int getLogicType() {
        return logicType;
    }

    public void setLogicType(int logicType) {
        this.logicType = logicType;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    class Params {
        private String param1;
        private int param2;
    }
}
