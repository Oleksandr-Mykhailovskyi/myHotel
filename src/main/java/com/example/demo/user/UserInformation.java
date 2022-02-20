package com.example.demo.user;

import com.example.demo.recepcja.strategy.ShowUnRentRoomsForGuestStrategy;
import com.example.demo.rooms.Room;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInformation {

    public String userName;
    public String userSurname;
    public String userIdNumber;
    public int numberRoom;
    public int userAge;
    public int userNumber;

    public void getNumber() {

        try {
            Scanner scanner = new Scanner(System.in);
            userNumber = scanner.nextInt();

        } catch (InputMismatchException in) {
            getNumber();
        }
    }

    public void roomChoice(List<Room> room, int numberRoom) {
        try {
            new ShowUnRentRoomsForGuestStrategy(room);
            System.out.println("Wybierz pokój :");
            Scanner number = new Scanner(System.in);
            numberRoom = number.nextInt() - 1;

            if (numberRoom >= 0 && numberRoom <= 19 && room.get(numberRoom).getIsFree().equals(true) && room.get(numberRoom).getIsReady().equals(true)) {
            } else
                roomChoice(room, numberRoom);
        } catch (InputMismatchException in) {
            roomChoice(room, numberRoom);
        }
    }

    public void checkName() {

        System.out.println("Podaj imie :");
        Scanner name = new Scanner(System.in);
        userName = name.next();

        if (userName.length() <= 2 || !userName.matches("[a-zA-Z]+") || userName.length() > 15)
            checkName();
    }

    public void checkSurname() {

        System.out.println("Podaj nazwisko :");
        Scanner surname = new Scanner(System.in);
        userSurname = surname.nextLine();

        if (userSurname.length() <= 2 || !userSurname.matches("[a-zA-Z]+") || userSurname.length() > 15)
            checkSurname();
    }

    public void checkIdNumber() {

        System.out.println("Podaj numer pesel :");
        Scanner scanner = new Scanner(System.in);
        userIdNumber = scanner.next();

        if (userIdNumber.matches("[a-zA-Z]+") || userIdNumber.toCharArray().length != 11) { checkIdNumber(); }
    }

    public void checkUserAge() {
        try {

            System.out.println("Podaj wiek :");
            Scanner age = new Scanner(System.in);
            userAge = age.nextInt();

            if (userAge <= 17) {
                System.out.println("Jesteś za mlody");
                System.exit(0);
            } else if (userAge > 99) {
                System.out.println("Chyba jesteś za stary :)");
                checkUserAge();
            }
        }
        catch (InputMismatchException in) { checkUserAge(); }
    }
}
