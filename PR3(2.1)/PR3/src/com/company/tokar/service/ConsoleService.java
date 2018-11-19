package com.company.tokar.service;

import com.company.tokar.exception.NoTestsException;
import com.company.tokar.model.Test;
import com.company.tokar.model.TestTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private static final Scanner scan = new Scanner(System.in);

    private static final StorageService storageService = new StorageService();

    private static final String[] createTestMessages = {
            "Input type: ", "Input subject: ", "Input question: ", "Input answers: "
    };

    public static void showMenu() {
        start:
        while (true) {
            System.out.println("Init tests automatically(1) or create your own(2)(Write number)");

            switch (scan.nextLine()) {
                case "1":
                    storageService.initTestStorageWithData();
                    break start;
                case "2":
                    storageService.initTestStorage();
                    showFillTestsMenu();
                    break start;

            }
        }

        options:
        while(true) {
            System.out.println("Choose option:");

            System.out.println("1) Show tests by test type");
            System.out.println("2) Show tests by subject");
            System.out.println("3) Add new tests");
            System.out.println("4) Exit");
            System.out.println();
            System.out.println("`show` - show tests");

            switch(scan.nextLine()) {
                case "1":
                    System.out.println("Enter test type: ");
                    tryPrintTestsForType(scan.nextLine());
                    break;
                case "2":
                    System.out.println("Enter subject");
                    tryPrintTestsForSubject(scan.nextLine());
                    break;
                case "3":
                    storageService.getTests().add(showCreateTestMenu());
                    break;
                case "show":
                    showTests(storageService.getTests());
                    break;
                case "4":
                    break options;
            }
        }
    }

    private static void tryPrintTestsForType(String type) {
        List<Test> testsForType;

        try {
            testsForType = storageService.getTestsForType(type);

            if (testsForType.isEmpty()) {
                throw new NoTestsException("There are no tests for type " + type);
            }
            showTests(testsForType);
        } catch (NoTestsException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void tryPrintTestsForSubject(String subject) {
        List<Test> testsForSubject;

        try {
            testsForSubject = storageService.getTestsForSubject(subject);

            if (testsForSubject.isEmpty()) {
                throw new NoTestsException("There are no tests for subject " + subject);
            }
            showTests(testsForSubject);
        } catch (NoTestsException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void showFillTestsMenu() {
        ArrayList<Test> tests = new ArrayList<>();

        fill:
        while (true) {
            System.out.println("Create new test or continue(Write words `create` or `continue`)");

            switch (scan.nextLine()) {
                case "create":
                    tests.add(showCreateTestMenu());
                    break;
                case "continue":
                    storageService.setTests(tests);
                    break fill;
            }
        }
    }

    private static Test showCreateTestMenu() {
        Test test = new Test();

        for (int i = 0; i < createTestMessages.length; i++) {
            String message = createTestMessages[i];

            System.out.println(message);

            if (message.equals("Input answers: ")) {
                showInputAnswersMenu(test);
                continue;
            }

            if (scan.hasNextLine()) {
                String input = scan.nextLine();
                switch (message) {
                    case "Input type: ":
                        switch (input) {
                            case "Writing":
                                test.setType(TestTypes.WRITING);
                                break;
                            case "Speaking":
                                test.setType(TestTypes.SPEAKING);
                                break;
                            default:
                                i--;
                        }
                        break;
                    case "Input subject: ":
                        test.setSubject(input);
                        break;
                    case "Input question: ":
                        test.setQuestion(input);
                        break;
                }
            } else {
                i--;
            }
        }

        return test;
    }

    private static void showInputAnswersMenu(Test test) {
        ArrayList<String> answers = new ArrayList<>();
        while (true) {
            System.out.println("Input new answer or write `stop`");

            if (scan.hasNextLine()) {
                String answerOrStop = scan.nextLine();

                if (answerOrStop.equals("stop")) {
                    test.setAnswers(answers);
                    return;
                }

                answers.add(answerOrStop);
            }
        }
    }

    private static void showTests(List<Test> tests) {
        if(tests.size() == 0) {
            System.out.println("There is no results");
            return;
        }

        for (Test test : tests) {
            System.out.println("====================================");
            System.out.println(test.toString());
        }
    }
}
