package com.company.tokar.utils;


import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringService {
    //приниет только буквы от a до z (большие тоже)
    private Pattern letterRegex = Pattern.compile("[a-zA-Z]");


    public String changeLettersCase(String str) {
        ArrayList<String> endSymbols = createEndSymbols();

        StringBuilder newStringBuilder = new StringBuilder();
        char[] letters = str.toCharArray();

        // Если true - значит буква подлежит изменению.
        boolean isNextLower = true;
        String currentLetter;

        for (char letter : letters) {
            currentLetter = String.valueOf(letter);

            if (isNextLower && currentLetter.matches(letterRegex.pattern())) {
                currentLetter = currentLetter.toLowerCase();
                isNextLower = false;
            }

            if (endSymbols.contains(currentLetter)) {
                isNextLower = true;
            }

            //добавляем букву в результат
            newStringBuilder.append(currentLetter);
        }

        return newStringBuilder.toString();
    }

    private ArrayList<String> createEndSymbols() {
        ArrayList<String> endOfSentenceSymbols = new ArrayList<>();
        endOfSentenceSymbols.add(".");
        endOfSentenceSymbols.add("?");
        endOfSentenceSymbols.add("!");

        return endOfSentenceSymbols;
    }
}
