package com.company.tokar.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    private TestTypes type;

    private String subject;

    private String question;

    private ArrayList<String> answers = new ArrayList<>();

    public Test() {
    }

    public Test(TestTypes type, String subject, String question, String ... answers) {
        this.type = type;
        this.subject = subject;
        this.question = question;
        this.answers.addAll(Arrays.asList(answers));
    }

    public TestTypes getType() {
        return type;
    }

    public void setType(TestTypes type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        StringBuilder answersStringBuilder = new StringBuilder();

        if (this.answers.size() == 0) {
            answersStringBuilder.append("empty");

        } else {
            for (String answer : this.answers)
            {
                answersStringBuilder.append(answer).append("\t");
            }
        }

        return "Test: Type - " + this.type.toString() +
                ", Subject - " + this.subject +
                ", Question - " + this.question +
                ", Answers - " + answersStringBuilder.toString();
    }
}
