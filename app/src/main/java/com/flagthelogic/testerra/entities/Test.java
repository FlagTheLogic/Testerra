package com.flagthelogic.testerra.entities;

import java.util.ArrayList;

public class Test {
    private int id = 0;
    private String title = "default_test_title";
    private int type = 0;
    private String author = "default_test_author";
    private String description = "default_test_description";
    private ArrayList<Question> questions = new ArrayList<>();

    public Test() {
    }

    public Test(int id, String title, int type, String author, String description) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.author = author;
        this.description = description;
    }

    public Test(int id, String title, int type, String author, String description, ArrayList<Question> questions) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.author = author;
        this.description = description;
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Test{" + "\n" +
                "\tid : " + id + ",\n" +
                "\ttitle : '" + title + "\',\n" +
                "\ttype : " + type + ",\n" +
                "\tauthor : '" + author + "\',\n" +
                "\tdescription : '" + description + "\',\n" +
                "\tquestions : " + questions + "\n" +
                "}\n";
    }
}
