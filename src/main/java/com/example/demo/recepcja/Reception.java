package com.example.demo.recepcja;

import com.example.demo.deserializer.Deserializer;
import com.example.demo.emailSender.SendMail;
import com.example.demo.guest.Guest;
import com.example.demo.hotelMoney.HotelCash;
import com.example.demo.recepcja.strategy.*;
import com.example.demo.roomPrice.RoomPrice;
import com.example.demo.rooms.Room;
import com.example.demo.serializer.Serializer;
import com.example.demo.user.UserInformation;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reception {

    public String userName;
    public String userSurname;
    public String userIdNumber;
    public String days;
    public int userNumber;
    public int userAge;
    public int numberRoom;

    public List<Room> room = new ArrayList<>();

    public List<Guest> serializerGuest = new ArrayList<>();
    public List<Guest> guests = new ArrayList<>();

    public LocalDate dateOn;
    public LocalDate dateOff;

    public RoomPrice roomPrice = new RoomPrice();
    public HotelCash cash = new HotelCash();
    public SendMail sendMail = new SendMail();
    public UserInformation userInformation = new UserInformation();
    public Serializer serializer = new Serializer();
    public Deserializer deserializer = new Deserializer();

    private List<ReceptionStrategy> receptionStrategyList = List.of(
            new BookRoomStrategy(userName,
            userSurname,
            userIdNumber,
            days,
            userNumber,
            userAge,
            numberRoom,
            room,
            serializerGuest,
            dateOn,
            dateOff,
            roomPrice,
            cash,
            sendMail,
            userInformation,
            serializer,
            deserializer),
            new ShowUnRentRoomsForGuestStrategy(room),
            new ShowRoomsStrategy(room),
            new ShowGuestsStrategy(serializerGuest),
            new ShowRentRoomsForGuestStrategy(room),
            new ShowHotelMoneyStrategy()
    );

    public Reception() {

        deserializerForSave(room);
        serializationForSave(room);
        new Room(room);
        new Guest(guests);
        deserializerGuestForSave(guests, serializerGuest);

    }

    @SneakyThrows
    public void run() {

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

        receptionStrategyList.get(numberRoom -1).receptionAction();
        run();
    }

    public Integer getNumber() {

        userInformation.getNumber();
        userNumber = userInformation.userNumber;
        return userNumber;
    }

    private void serializationForSave(List<Room> room) {

        serializer.serializationForSave(room);
        this.room = serializer.saveRooms;
    }
//
    public void deserializerForSave(List<Room> room) {

        deserializer.deserializerForSave(room);
        this.room = deserializer.saveRooms;
    }

    public void deserializerGuestForSave(List<Guest> guests, List<Guest> serializerGuest) {

        deserializer.serializerGuestForSave(guests, serializerGuest);
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
}