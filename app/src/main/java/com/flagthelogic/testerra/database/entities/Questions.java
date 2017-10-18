package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "questions",
        primaryKeys = {"test_id", "question_id"},
        indices = {
                @Index(
                        name = "id",
                        value = {"test_id", "question_id"},
                        unique = true
                )
        })
public class Questions {
    @PrimaryKey
    @ColumnInfo(name = "test_id")
    private int tid;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id")
    private int qid;
    @ColumnInfo(name = "question")
    private String question;
    @ColumnInfo(name = "options")
    private String options;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
