package com.company.tokar.service;

import com.company.tokar.model.Test;
import com.company.tokar.storage.TestStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageService {
    private TestStorage testStorage;

    public void initTestStorage() {
        if(testStorage != null)  {
            return;
        }
        testStorage = TestStorage.getEmptyTestStorage();
    }
    public void initTestStorageWithData() {
        if(testStorage != null)  {
            return;
        }
        testStorage = TestStorage.getTestStorageWithData();
    }

    public List<Test> getTestsForSubject(String subject) {
        return testStorage.getTests().stream()
                .filter(test -> test.getSubject().equals(subject))
                .collect(Collectors.toList());
    }

    public List<Test> getTestsForType(String type) {
        return testStorage.getTests().stream()
                .filter(test -> test.getType().toString().equals(type))
                .collect(Collectors.toList());
    }

    public ArrayList<Test> getTests() {
        return testStorage.getTests();
    }

    public void setTests(ArrayList<Test> tests) {
        testStorage.setTests(tests);
    }
}
