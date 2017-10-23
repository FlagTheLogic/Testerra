package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import com.flagthelogic.testerra.database.converters.OptionsConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
//https://stackoverflow.com/questions/44815784/room-persistent-database-how-to-insert-list-of-items-into-db-when-it-has-no-pr
@Entity(tableName = "questions", primaryKeys = {"test_id", "question_id"})
@TypeConverter(OptionsConverter.class)
public class Questions {
    @ColumnInfo(name = "test_id")
    public int tId;
    @ColumnInfo(name = "question_id")
    public int qId;
    @ColumnInfo(name = "question")
    private String question;

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
        return "Questions{" +
                "tId=" + tId +
                ", qId=" + qId +
                ", question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}
