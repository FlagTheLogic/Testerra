package com.flagthelogic.testerra.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "questions", primaryKeys = {"test_id", "question_id"})
public class Questions {
    @PrimaryKey
    @ColumnInfo(name = "test_id")
    private int tId;
    @PrimaryKey
    @ColumnInfo(name = "question_id")
    private int qId;
    @ColumnInfo(name = "question")
    private String question;
    @ColumnInfo(name = "options")
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
        @SerializedName("options")
        @Expose
        private List<Option> options = null;

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }

        @Override
        public String toString() {
            String optionsStr = "";
            for (int i = 0; i < options.size(); i++) {
                if (options.size() != i) {
                    optionsStr += "{" + options.get(i).toString() + "},";
                } else {
                    optionsStr += "{" + options.get(i).toString() + "}";
                }
            }
            return "{\"options\":[" + optionsStr +"]}";
        }
        static class Option {
            @SerializedName("id")
            @Expose
            private int id;
            @SerializedName("title")
            @Expose
            private String title;

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
                return "{\"id\":"+id+","+
                        "\"title\":\""+title+"\"}";
            }
        }
    }
}
