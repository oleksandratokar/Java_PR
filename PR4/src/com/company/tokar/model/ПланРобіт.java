package com.company.tokar.model;

import java.util.ArrayList;

public class ПланРобіт {
    private ArrayList<Бригада> зареєстрованіБригади = new ArrayList<>();

    public void register(Бригада бригада) {
        зареєстрованіБригади.add(бригада);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Бригада бригада : зареєстрованіБригади) {
            builder.append(бригада.toString());
            builder.append("\n");
        }

        return builder.toString();
    }
}
