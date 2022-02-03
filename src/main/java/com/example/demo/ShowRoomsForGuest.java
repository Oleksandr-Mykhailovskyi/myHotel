package com.example.demo;

import java.util.List;

public class ShowRoomsForGuest {

    public static void showUnRent(List<Room> room) {
        room.stream()
                .filter(rooms -> rooms.getIsReady())
                .filter(rooms -> rooms.getIsFree())
                .forEach(rooms -> System.out.println(
                        " | Numer Pokoju -> "+rooms.getRoomNumber()+
                                " | Cena -> "+ rooms.getPrice() +
                                "zł | Ilość miejsc -> "+rooms.getHowManyRooms()+
                                " | Sniadania są w cenie -> "+rooms.getBreakfast())
                );
    }

    public static void showRent(List<Room> room) {

        room.stream()
                .filter(rooms -> !rooms.getIsFree())
                .filter(rooms -> !rooms.getIsReady())
                .forEach(rooms -> System.out.println(
                        " | Numer Pokoju -> "+rooms.getRoomNumber()+
                                " | Cena -> "+ rooms.getPrice() +
                                "zł | Ilość miejsc -> "+rooms.getHowManyRooms()+
                                " | Sniadania są w cenie -> "+rooms.getBreakfast())
                );
    }
}
