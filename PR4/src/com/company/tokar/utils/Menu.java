package com.company.tokar.utils;

import com.company.tokar.service.Диспетчер;
import com.company.tokar.service.Квартироприймач;

import java.util.Scanner;

public class Menu {
    private static final Квартироприймач квартироприймач = new Квартироприймач();
    private static final Диспетчер диспетчер = new Диспетчер();

    public static void showMenu() {
        Scanner scan = new Scanner(System.in);
        String variant;

        menu:
        while(true) {
            System.out.println("1: Create заявка");
            System.out.println("2: Show all registered бригади");
            System.out.println("3: Exit");

            variant = scan.nextLine();

            switch (variant) {
                case "1":
                    квартироприймач.sendЗаявка(квартироприймач.createЗаявка(), диспетчер);
                    System.out.println();
                    System.out.println("Success");
                    break;
                case "2":
                    диспетчер.showПланРобіт();
                    break;
                case "3":
                    break menu;
            }
        }
    }
}
