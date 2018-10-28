package com.company.tokar.service;

import com.company.tokar.model.Бригада;
import com.company.tokar.model.Заявка;
import com.company.tokar.model.ПланРобіт;

public class Диспетчер {
    private ПланРобіт планРобіт;

    public Диспетчер() {
        this.планРобіт = new ПланРобіт();
    }

    public void onReceiveMessage(Заявка заявка) {
        Бригада бригада = new Бригада(заявка);
        this.планРобіт.register(бригада);
    }

    public void showПланРобіт() {
        System.out.println();
        System.out.println(планРобіт.toString());
    }
}
