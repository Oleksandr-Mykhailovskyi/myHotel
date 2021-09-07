package com.example.demo;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reception {

    protected String userName;
    protected String userSurname;
    protected String userIdNumber;
    protected String days;
    protected int userNumber;
    protected int userAge;
    protected int numberRoom;

    protected Scanner scanner = new Scanner(System.in);

    protected List<Room> saveRooms = new ArrayList<>();
    protected List<Room> rooms = new ArrayList<>();

    protected List<Guest> serializerGuest = new ArrayList<>();
    protected List<Guest> guests = new ArrayList<>();

    protected LocalDate dateOn;
    protected LocalDate dateOff;

    protected RoomPrice roomPrice = new RoomPrice();
    protected Cash cash = new Cash();
    protected SendMail sendMail = new SendMail();
    protected UserInformation userInformation = new UserInformation();
    protected Serializer serializer = new Serializer();
    protected Deserializer deserializer = new Deserializer();
    protected Room room = new Room(rooms);

    protected Reception() {

        deserializerForSave(saveRooms);
        serializationForSave(rooms, saveRooms);
        new Guest(guests);
        deserializerGuestForSave(guests, serializerGuest);

    }

    @SneakyThrows
    protected void run() {

        System.out.println("""
                Podaj numer
                1 - Wynajmij pokój
                2 - Pokaż wolne pokoje
                3 - Pokaż pokoje
                4 - Pokaź listę gosci
                5 - Pokaż pokoje zajęte
                6 - Stan konta hotelu
                7 - wyjść""");

        getNumber();

        switch (userNumber) {
            case 1:
                bookRoom();
                run();
                break;
            case 2:
                room.showUnRent(saveRooms);
                run();
                break;
            case 3:
                showRooms(rooms);
                run();
                break;
            case 4:
                deserializerGuest(guests);
                run();
                break;
            case 5:
                room.showRent(saveRooms);
                run();
                break;
            case 6:
                showHotelMoney();
                run();
                break;
            case 7:
                scanner.close();
                System.exit(0);
            default:
                run();
        }
    }

    private void bookRoom() {

        roomChoice(saveRooms, room);
        dayPrice(saveRooms, numberRoom);
        breakfastPrice(saveRooms, numberRoom);
        voucher(saveRooms, numberRoom);

        checkName();
        checkSurname();
        checkUserAge();
        checkIdNumber();

        regularCostumer(numberRoom, serializerGuest, userIdNumber, rooms);
        reservedData(days, numberRoom, saveRooms);
        addNewGuest(userName, userSurname, userAge, userIdNumber, numberRoom, dateOn, dateOff);
        serializationGuest(serializerGuest);
        controlOfEarnedMoney(saveRooms, numberRoom);

        sendEmailInfo(serializerGuest, rooms, numberRoom, dateOn, dateOff);

        reservedRoom(numberRoom, saveRooms, days);
        serializationForSave(rooms, saveRooms);
    }

    protected List<Room> showRooms(List<Room> rooms) {
        rooms.stream()
                .forEach(room -> System.out.println(
                        " | Numer Pokoju -> " + room.getRoomNumber() +
                        " | Cena -> " + room.getPrice() + "zł | Ilość miejsc -> " + room.getHowManyRooms() +
                        " | Sniadania są w cenie -> " + room.getBreakfast())
                );
        return rooms;
    }

    protected void getNumber() {

        userInformation.getNumber();
        userNumber = userInformation.userNumber;
    }

    protected String checkName() {

        userInformation.checkName();
        userName = userInformation.userName;
        return userName;
    }

    protected String checkSurname() {

        userInformation.checkSurname();
        userSurname = userInformation.userSurname;
        return userSurname;
    }

    protected Integer checkUserAge() {

        userInformation.checkUserAge();
        userAge = userInformation.userAge;
        return  userAge;
    }

    protected void checkIdNumber() {

        userInformation.checkIdNumber();
        userIdNumber = userInformation.userIdNumber;
    }

    protected void roomChoice(List<Room> saveRooms, Room room) {

        userInformation.roomChoice(saveRooms, room);
        numberRoom = userInformation.numberRoom;
    }

    protected BigDecimal dayPrice(List<Room> saveRooms, int numberRoom) {
        roomPrice.dayPrice(saveRooms, numberRoom);
        days = roomPrice.days;
        return saveRooms.get(numberRoom).getPrice();
    }

    protected BigDecimal breakfastPrice(List<Room> saveRooms,
                                  int numberRoom) {

        roomPrice.breakfastPrice(saveRooms,
                numberRoom);
        return saveRooms.get(numberRoom).getPrice();
    }

    protected void voucher(List<Room> saveRooms,
                           int numberRoom) {

        roomPrice.voucher(saveRooms,
                numberRoom);
    }

    private void controlOfEarnedMoney(List<Room> saveRooms, int numberRoom) {

        cash.controlOfEarnedMoney(saveRooms, numberRoom);
    }

    private void showHotelMoney() {

        cash.showHotelMoney();
    }

    protected void regularCostumer(int numberRoom,
                                   List<Guest> serializerGuest,
                                   String userIdNumber,
                                   List<Room> saveRooms) {

        roomPrice.regularCostumer(numberRoom,
                serializerGuest,
                userIdNumber,
                saveRooms);
    }

    @SneakyThrows
    protected void sendEmailInfo(List<Guest> serializerGuest,
                                 List<Room> rooms,
                                 int numberRoom,
                                 LocalDate dateOn,
                                 LocalDate dateOff) {

        sendMail.sendEmailInfo(serializerGuest,
                rooms,
                numberRoom,
                dateOn,
                dateOff);
    }

    private void serializationForSave(List<Room> rooms, List<Room> saveRooms) {

        serializer.serializationForSave(rooms, saveRooms);
        this.saveRooms = serializer.saveRooms;
    }

    protected void deserializerForSave(List<Room> saveRooms) {

        deserializer.deserializerForSave(saveRooms);
        this.saveRooms = deserializer.saveRooms;
    }

    private void serializationGuest(List<Guest> serializerGuest) {

        serializer.serializationGuest(serializerGuest);
    }

    private void deserializerGuest(List<Guest> serializerGuest) {

        deserializer.deserializerGuest(serializerGuest);
        this.serializerGuest = serializerGuest;
    }

    protected void deserializerGuestForSave(List<Guest> guests, List<Guest> serializerGuest) {

        deserializer.serializerGuestForSave(guests, serializerGuest);
    }


    protected List<Guest> addNewGuest(String userName,
                                      String userSurname,
                                      Integer userAge,
                                      String userIdNumber,
                                      int numberRoom,
                                      LocalDate dateOn,
                                      LocalDate dateOff)
    {
        serializerGuest.add(0,
                new Guest(userName,
                        userSurname,
                        userAge,
                        userIdNumber,
                        numberRoom + 1,
                        dateOn,
                        dateOff));
        return serializerGuest;
    }

    protected List<Room> reservedRoom(int numberRoom, List<Room> saveRooms, String days) {

        saveRooms.get(numberRoom).setIsFree(false);
        saveRooms.get(numberRoom).setIsReady(false);

        System.out.println(
                "Dziękuję! Cena za pokój : " + saveRooms.get(numberRoom).getPrice() +
                " | Sniadanie dostępne : " + saveRooms.get(numberRoom).getBreakfast() +
                " | Ilość dni : " + days
        );

        this.saveRooms = saveRooms;

        return saveRooms;
    }

    private void reservedData(String days, int numberRoom, List<Room> saveRooms) {
        dateOn = LocalDate.now();
        dateOff = dateOn.plusDays(Long.parseLong(days));
        saveRooms.get(numberRoom).setReservedFrom(dateOn);
        saveRooms.get(numberRoom).setReservedUntil(dateOff);
    }
}