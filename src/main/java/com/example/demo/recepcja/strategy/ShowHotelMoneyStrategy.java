package com.example.demo.recepcja.strategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ShowHotelMoneyStrategy implements ReceptionStrategy {


    @Override
    public void receptionAction() {
        showHotelMoney();
    }

    public void showHotelMoney() {

        Scanner myReader;

        System.out.println("Podaj hasło: ");
        Scanner login = new Scanner(System.in);
        String password = login.next();

        if (password.equals("admin1234")) {
            try {

                FileReader file = new FileReader("Budżet.txt");
                myReader = new Scanner(file);

                while (myReader.hasNext()) {

                    System.out.println(myReader.next());
                }
                myReader.close();
            }
            catch (FileNotFoundException e) { e.printStackTrace(); }
        }
        else {
            System.out.println("Żle podałeś hasło");
        }
    }
}
