package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "questions", primaryKeys = {"test_id", "question_id"})
public class Questions {
    @ColumnInfo(name = "test_id")
    public int tId;
    @ColumnInfo(name = "question_id")
    public int qId;
    @ColumnInfo(name = "question")
    private String question;

    private POJOOptions options;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public POJOOptions getOptions() {
        return options;
    }

    public void setOptions(POJOOptions options) {
        this.options = options;
    }

    public static class POJOOptions {
        List<Integer> ids;
        List<String> titles;

        public POJOOptions(List<Integer> ids, List<String> titles) {
            this.ids = ids;
            this.titles = titles;
        }

        public List<Integer> getIds() {
            return ids;
        }

        public void setIds(List<Integer> ids) {
            this.ids = ids;
        }

        public List<String> getTitles() {
            return titles;
        }

        public void setTitles(List<String> titles) {
            this.titles = titles;
        }

        @Override
        public String toString() {
            return "POJOOptions{" +
                    "ids=" + ids.get(1) +
                    ", titles=" + titles.get(1) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Questions{" +
                "tId=" + tId +
                ", qId=" + qId +
                ", question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}
