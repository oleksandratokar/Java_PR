package com.company.tokar.model;

public enum TestTypes {
    WRITING("Writing"),
    SPEAKING("Speaking");

    private String type;

    TestTypes(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
