package com.company.tokar.service;

import java.io.*;

public class FileService {
    private static BufferedWriter fileWriter;

    public static void changeFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        fileWriter = new BufferedWriter(new FileWriter("New " + file.getName()));

        reader.lines()
                .filter(line -> !line.isEmpty())
                .forEach(FileService::changeAndWriteLine);

        fileWriter.flush();
        fileWriter.close();
        fileReader.close();
    }

    private static void changeAndWriteLine(String line) {
        char[] characters = line.toCharArray();
        boolean isSpace = false;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ' ') {
                if (!isSpace) {
                    if (i - 1 >= 0 && i + 1 < characters.length && (!isBracketCharacter(characters[i + 1]) && !isBracketCharacter(characters[i - 1]))) {
                        tryWriteCharacter(characters[i]);
                    }
                    isSpace = true;
                }
            } else {
                tryWriteCharacter(characters[i]);
                isSpace = false;
            }
        }
    }

    private static void tryWriteCharacter(char character) {
        try {
            fileWriter.append(character);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isBracketCharacter(char character) {
        return character == '{' || character == '}';
    }
}
