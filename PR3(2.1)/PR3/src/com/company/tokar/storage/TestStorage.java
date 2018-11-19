package com.company.tokar.storage;

import com.company.tokar.model.Test;
import com.company.tokar.model.TestTypes;

import java.util.ArrayList;

public class TestStorage {
    private ArrayList<Test> tests;

    public static TestStorage getEmptyTestStorage() {
        return new TestStorage();
    }

    public static TestStorage getTestStorageWithData() {
        final ArrayList<Test> tests = new ArrayList<>();

        tests.add(new Test(TestTypes.WRITING, "Math", "2 + 2?", "4", "5", "2"));
        tests.add(new Test(
                TestTypes.SPEAKING,
                "Math",
                "What is sin?",
                "First answer", "Second answer", "Third answer"
        ));
        tests.add(new Test(
                TestTypes.SPEAKING,
                "Math",
                "What is cos?",
                "First answer", "Second answer", "Third answer"
        ));
        tests.add(new Test(
                TestTypes.SPEAKING,
                "Ukrainian language",
                "What is word?",
                "First answer", "Second answer", "Third answer"
        ));
        tests.add(new Test(
                TestTypes.WRITING,
                "Ukrainian language",
                "What is letter?",
                "First answer", "Second answer", "Third answer"
        ));

        return new TestStorage(tests);
    }

    private TestStorage() {
    }

    private TestStorage(ArrayList<Test> tests) {
        this.tests = tests;
    }

    public ArrayList<Test> getTests() {
        return tests;
    }

    public void setTests(ArrayList<Test> tests) {
        this.tests = tests;
    }
}
