package com.company.tokar.service;

import com.company.tokar.model.Заявка;

import java.util.Scanner;

public class Квартироприймач {
    public void sendЗаявка(Заявка заявка, Диспетчер диспетчер) {
        диспетчер.onReceiveMessage(заявка);
    }

    public Заявка createЗаявка() {
        Scanner scan = new Scanner(System.in);

        String workType, date;
        double scale = -1;

        do {
            System.out.println("Please, fill all fields!");
            System.out.println();
            System.out.println("Enter workType: ");
            workType = scan.nextLine();
            System.out.println("Enter end date: ");
            date = scan.nextLine();
            System.out.println("Enter scale");
            try {
                scale = Double.parseDouble(scan.nextLine());
            } catch (Exception ignored) {
            }

        } while (workType.isEmpty() || date.isEmpty() || scale < 0);

        return new Заявка(workType, date, scale);
    }
}
