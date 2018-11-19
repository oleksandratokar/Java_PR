package com.company.tokar.service;

import java.io.*;
import java.util.Scanner;

public class ConsoleService {
    private static final Scanner scan = new Scanner(System.in);

    public static void changeFileFromConsole() {
        while (true) {
            try {
                File file = getFileByPath();
                FileService.changeFile(file);
            } catch (IOException e) {
                System.out.println("Помилка, спробуйте ще раз");
            }

            System.out.println("1. Змінити інший файл");
            System.out.println("2. Вийти");
            if (scan.hasNextLine()) {
                switch (scan.nextLine()) {
                    case "1":
                        continue;
                    case "2":
                        return;
                }
            }

        }
    }

    private static File getFileByPath() {
        while(true) {
            System.out.println("Введіть шлях до файлу");

            if (scan.hasNextLine()) {
                String path = scan.nextLine();
                int indexOfFileExtension = path.lastIndexOf('.');

                if (!path.isEmpty() && indexOfFileExtension != -1 && path.substring(indexOfFileExtension).equals(".java")) {
                    return new File(path);
                }
            }
        }
    }
}
