package com.company.tokar.model;

public class Бригада {
    private Заявка заявка;

    public Бригада(Заявка заявка) {
        this.заявка = заявка;
    }

    public Заявка getЗаявка() {
        return заявка;
    }

    public void setЗаявка(Заявка заявка) {
        this.заявка = заявка;
    }

    @Override
    public String toString() {
        return "Бригада: " + заявка.toString();
    }
}
