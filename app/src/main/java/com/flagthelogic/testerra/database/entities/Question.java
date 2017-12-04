package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;

import com.flagthelogic.testerra.database.converters.OptionsConverter;


import java.util.List;
//https://stackoverflow.com/questions/44815784/room-persistent-database-how-to-insert-list-of-items-into-db-when-it-has-no-pr
@Entity(tableName = "questions", primaryKeys = {"test_id", "question_id"})
@TypeConverters({OptionsConverter.class})
public class Question {
    @ColumnInfo(name = "test_id")
    public int tId;
    @ColumnInfo(name = "question_id")
    public int qId;
    @ColumnInfo(name = "question")
    private String question;
    @ColumnInfo(name = "options")
    private List<Options> options = null;

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

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public static class Options {
        int id;
        String title;

        public Options() {
        }

        public Options(int id, String title) {
            this.id = id;
            this.title = title;
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

        @Override
        public String toString() {
            return "Options{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Question{" +
                "tId=" + tId +
                ", qId=" + qId +
                ", question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}
