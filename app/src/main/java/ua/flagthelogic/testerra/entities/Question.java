package ua.flagthelogic.testerra.entities;

import java.util.ArrayList;

public class Question {
    int id = 0;
    String question = "default_test_question";
    ArrayList<Option> options = new ArrayList<>();

    public Question() {
    }

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }

    public Question(int id, String question, ArrayList<Option> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "\n\t\tQuestion{ \n" +
                "\t\t\tid=" + id + ",\n" +
                "\t\t\tquestion='" + question + "\',\n" +
                "\t\t\toptions=" + options + "},\n";
    }
}
