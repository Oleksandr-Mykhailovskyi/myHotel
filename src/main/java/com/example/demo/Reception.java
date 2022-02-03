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

    public List<Room> room = new ArrayList<>();

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

    protected Reception() {

        deserializerForSave(room);
        serializationForSave(room);
        new Room(room);
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
                ShowRoomsForGuest.showUnRent(room);
                run();
                break;
            case 3:
                showRooms(room);
                run();
                break;
            case 4:
                deserializerGuest(guests);
                System.out.println(guests);
                run();
                break;
            case 5:
                ShowRoomsForGuest.showRent(room);
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

        roomChoice(room, numberRoom);
        dayPrice(room, numberRoom);
        breakfastPrice(room, numberRoom, days);
        voucher(room, numberRoom);

        checkName();
        checkSurname();
        checkUserAge();
        checkIdNumber();

        regularCostumer(numberRoom, serializerGuest, userIdNumber, room);
        reservedData(days, numberRoom, room);
        addNewGuest(userName, userSurname, userAge, userIdNumber, numberRoom, dateOn, dateOff);
        serializationGuest(serializerGuest);
        controlOfEarnedMoney(room, numberRoom);

        sendEmailInfo(serializerGuest, room, numberRoom, dateOn, dateOff);

        reservedRoom(numberRoom, room, days);
        serializationForSave(room);
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

    protected Integer getNumber() {

        userInformation.getNumber();
        userNumber = userInformation.userNumber;
        return userNumber;
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

    protected String checkIdNumber() {

        userInformation.checkIdNumber();
        userIdNumber = userInformation.userIdNumber;
        return userIdNumber;
    }

    protected Integer roomChoice(List<Room> room, int numberRoom) {

        userInformation.roomChoice(room, numberRoom);
        numberRoom = userInformation.numberRoom;
        return numberRoom;
    }

    protected BigDecimal dayPrice(List<Room> room, int numberRoom) {
        roomPrice.dayPrice(room, numberRoom);
        days = roomPrice.days;
        return room.get(numberRoom).getPrice();
    }

    protected BigDecimal breakfastPrice(List<Room> room,
                                  int numberRoom,
                                        String days) {

        roomPrice.breakfastPrice(room,
                numberRoom,
                days);
        return room.get(numberRoom).getPrice();
    }

    protected BigDecimal voucher(List<Room> room,
                           int numberRoom) {

        roomPrice.voucher(room,
                numberRoom);

        return room.get(numberRoom).getPrice();
    }

    private void controlOfEarnedMoney(List<Room> room, int numberRoom) {

        cash.controlOfEarnedMoney(room, numberRoom);
    }

    private void showHotelMoney() {

        cash.showHotelMoney();
    }

    protected BigDecimal regularCostumer(int numberRoom,
                                   List<Guest> serializerGuest,
                                   String userIdNumber,
                                   List<Room> room) {

        roomPrice.regularCostumer(numberRoom,
                serializerGuest,
                userIdNumber,
                room);

        return room.get(numberRoom).getPrice();
    }

    @SneakyThrows
    protected void sendEmailInfo(List<Guest> serializerGuest,
                                 List<Room> room,
                                 int numberRoom,
                                 LocalDate dateOn,
                                 LocalDate dateOff) {

        sendMail.sendEmailInfo(serializerGuest,
                room,
                numberRoom,
                dateOn,
                dateOff);
    }

    private void serializationForSave(List<Room> room) {

        serializer.serializationForSave(room);
        this.room = serializer.saveRooms;
    }

    protected void deserializerForSave(List<Room> room) {

        deserializer.deserializerForSave(room);
        this.room = deserializer.saveRooms;
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


    protected Guest addNewGuest(String userName,
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

        return serializerGuest.get(0);
    }

    protected Room reservedRoom(int numberRoom, List<Room> room, String days) {

        room.get(numberRoom).setIsFree(false);
        room.get(numberRoom).setIsReady(false);

        System.out.println(
                "Dziękuję! Cena za pokój : " + room.get(numberRoom).getPrice() +
                " | Sniadanie dostępne : " + room.get(numberRoom).getBreakfast() +
                " | Ilość dni : " + days
        );

        this.room = room;

        return room.get(numberRoom);
    }

    private void reservedData(String days, int numberRoom, List<Room> saveRooms) {
        dateOn = LocalDate.now();
        dateOff = dateOn.plusDays(Long.parseLong(days));
        saveRooms.get(numberRoom).setReservedFrom(dateOn);
        saveRooms.get(numberRoom).setReservedUntil(dateOff);
    }
}