package com.flagthelogic.testerra;

import java.util.ArrayList;

import com.flagthelogic.testerra.entities.Option;
import com.flagthelogic.testerra.entities.Question;
import com.flagthelogic.testerra.entities.Test;


public class Application {

    static ArrayList<Test> tests = new ArrayList<>();
    static {
        Question question1 = new Question(1, "question 1");
        question1.addOption(new Option(0,"tit0",1));
        question1.addOption(new Option(1,"tit1",0));
        question1.addOption(new Option(2,"tit2",0));
        question1.addOption(new Option(3,"tit3",0));

        Question question2 = new Question(2, "question 2");
        question2.addOption(new Option());
        question2.addOption(new Option());
        question2.addOption(new Option());
        question2.addOption(new Option());

        Test test = new Test();
        Test test1 = new Test();
        test.addQuestion(question1);
        test.addQuestion(question2);
        test1.addQuestion(question1);
        test1.addQuestion(question2);
        Application.addTest(test);
        Application.addTest(test1);
    }
    public static void addTest(Test test) {
        tests.add(test);
    }
    public static ArrayList<Test> getTests() {
        return tests;
    }

    public static void setTests(ArrayList<Test> tests) {
        Application.tests = tests;
    }

    public static void main(String[] args) {
        System.out.println(getTests());
    }
}
