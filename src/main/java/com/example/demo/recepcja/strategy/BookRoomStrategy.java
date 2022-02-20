package com.example.demo.recepcja.strategy;

import com.example.demo.deserializer.Deserializer;
import com.example.demo.emailSender.SendMail;
import com.example.demo.guest.Guest;
import com.example.demo.hotelMoney.HotelCash;
import com.example.demo.roomPrice.RoomPrice;
import com.example.demo.rooms.Room;
import com.example.demo.serializer.Serializer;
import com.example.demo.user.UserInformation;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BookRoomStrategy implements ReceptionStrategy {

    public String userName;
    public String userSurname;
    public String userIdNumber;
    public String days;
    public int userNumber;

    public BookRoomStrategy(String userName, String userSurname, String userIdNumber, String days, int userNumber, int userAge, int numberRoom, List<Room> room, List<Guest> serializerGuest, LocalDate dateOn, LocalDate dateOff, RoomPrice roomPrice, HotelCash cash, SendMail sendMail, UserInformation userInformation, Serializer serializer, Deserializer deserializer) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userIdNumber = userIdNumber;
        this.days = days;
        this.userNumber = userNumber;
        this.userAge = userAge;
        this.numberRoom = numberRoom;
        this.room = room;
        this.serializerGuest = serializerGuest;
        this.dateOn = dateOn;
        this.dateOff = dateOff;
        this.roomPrice = roomPrice;
        this.cash = cash;
        this.sendMail = sendMail;
        this.userInformation = userInformation;
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public int userAge;
    public int numberRoom;

    public List<Room> room;

    public List<Guest> serializerGuest;

    public LocalDate dateOn;
    public LocalDate dateOff;

    public RoomPrice roomPrice;
    public HotelCash cash;
    public SendMail sendMail;
    public UserInformation userInformation;
    public Serializer serializer;
    public Deserializer deserializer;

    @Override
    public void receptionAction() {

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

    public String checkName() {

        userInformation.checkName();
        userName = userInformation.userName;
        return userName;
    }

    public String checkSurname() {

        userInformation.checkSurname();
        userSurname = userInformation.userSurname;
        return userSurname;
    }

    public Integer checkUserAge() {

        userInformation.checkUserAge();
        userAge = userInformation.userAge;
        return  userAge;
    }

    public String checkIdNumber() {

        userInformation.checkIdNumber();
        userIdNumber = userInformation.userIdNumber;
        return userIdNumber;
    }

    public Integer roomChoice(List<Room> room, int numberRoom) {

        userInformation.roomChoice(room, numberRoom);
        numberRoom = userInformation.numberRoom;
        return numberRoom;
    }

    public BigDecimal dayPrice(List<Room> room, int numberRoom) {
        roomPrice.dayPrice(room, numberRoom);
        days = roomPrice.days;
        return room.get(numberRoom).getPrice();
    }

    public BigDecimal breakfastPrice(List<Room> room,
                                     int numberRoom,
                                     String days) {

        roomPrice.breakfastPrice(room,
                numberRoom,
                days);
        return room.get(numberRoom).getPrice();
    }

    public BigDecimal voucher(List<Room> room,
                              int numberRoom) {

        roomPrice.voucher(room,
                numberRoom);

        return room.get(numberRoom).getPrice();
    }

    private void controlOfEarnedMoney(List<Room> room, int numberRoom) {

        cash.controlOfEarnedMoney(room, numberRoom);
    }

    public BigDecimal regularCostumer(int numberRoom,
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
    public void sendEmailInfo(List<Guest> serializerGuest,
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

    private void serializationGuest(List<Guest> serializerGuest) {

        serializer.serializationGuest(serializerGuest);
    }

    private void deserializerGuest(List<Guest> serializerGuest) {

        deserializer.deserializerGuest(serializerGuest);
        this.serializerGuest = serializerGuest;
    }

    public Guest addNewGuest(String userName,
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

    public Room reservedRoom(int numberRoom, List<Room> room, String days) {

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
