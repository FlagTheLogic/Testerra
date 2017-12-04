package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tests",indices = {@Index(value = "id", unique = true)})
public class Test {
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
    private Params parameters;
    @ColumnInfo(name = "logic_type")
    private int logicType;
    @ColumnInfo(name = "instruction")
    private String instruction;

//    public Test() {
//    }

    public Test(int id, String title, String author, String description, int testCompleted, int category, Params parameters, int logicType, String instruction) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.testCompleted = testCompleted;
        this.category = category;
        this.parameters = parameters;
        this.logicType = logicType;
        this.instruction = instruction;
    }

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

    public Params getParameters() {
        return parameters;
    }

    public void setParameters(Params params) {
        this.parameters = params;
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

    public static class Params {
        private String param1;
        private int param2;

        public Params(String param1, int param2) {
            this.param1 = param1;
            this.param2 = param2;
        }

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public int getParam2() {
            return param2;
        }

        public void setParam2(int param2) {
            this.param2 = param2;
        }
        @Override
        public String toString() {
            return "Params{" +
                    "param1='" + param1 + '\'' +
                    ", param2=" + param2 +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title=\'" + title + '\'' +
                ", author=\'" + author + '\'' +
                ", description=\'" + description + '\'' +
                ", testCompleted=" + testCompleted +
                ", category=" + category +
                ", parameters=" + parameters +
                ", logicType=" + logicType +
                ", instruction=\'" + instruction + '\'' +
                '}';
    }
}
