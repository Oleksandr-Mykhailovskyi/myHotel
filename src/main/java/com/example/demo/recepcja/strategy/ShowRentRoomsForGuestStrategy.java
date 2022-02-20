package com.example.demo.recepcja.strategy;

import com.example.demo.rooms.Room;

import java.util.List;

public class ShowRentRoomsForGuestStrategy implements ReceptionStrategy{

    private List<Room> rooms;

    public ShowRentRoomsForGuestStrategy(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void receptionAction() {
        showRent(rooms);
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
