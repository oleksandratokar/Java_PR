package com.company.tokar.utils;

import java.util.Scanner;

public class ConsoleManager {
    private static final String RESULT_TITLE = "Result:";
    private static final String TEXT = "  Can you provide some text? No? Okay, I will provide it for you!!";
    private static final StringService stringService = new StringService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void Start() {
        while(true) {
            System.out.println("Choose option: ");
            System.out.println("Write 'from code' if you want change hard-coded text");
            System.out.println("Write 'from input' if you want to provide it by yourself");
            System.out.println("Write something else to quit");

            String option = scanner.nextLine();

            if(option.equalsIgnoreCase("from code")) {
                changeStringFromCode(TEXT);
            } else if(option.equalsIgnoreCase("from input")) {
                changeStringFromConsole();
            } else {
                break;
            }
        }
    }


    private static void changeStringFromConsole() {
        System.out.println("Please, provide your text:");

        String str = scanner.nextLine();

        System.out.println();
        System.out.println(RESULT_TITLE);

        System.out.println(stringService.changeLettersCase(str));
    }

    private static void changeStringFromCode(String str) {
        System.out.println("Text:");
        System.out.println(str);
        System.out.println();
        System.out.println(RESULT_TITLE);
        System.out.println(stringService.changeLettersCase(str));
    }
}
