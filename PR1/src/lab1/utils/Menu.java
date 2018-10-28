package lab1.utils;

import java.util.Scanner;

public class Menu {
    private static final String NAME = "Oleksandra Tokar";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getSize() {
        System.out.println("Enter matrix size:");
        return scanner.nextLine();
    }

    public static void printDevelopersName() {
        System.out.println(NAME);
    }
}
