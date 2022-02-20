package com.example.demo.recepcja.strategy;

import com.example.demo.rooms.Room;

import java.util.List;

public class ShowUnRentRoomsForGuestStrategy implements ReceptionStrategy {

    private List<Room> room;

    public ShowUnRentRoomsForGuestStrategy(List< Room > room) {
        this.room = room;
    }

    @Override
    public void receptionAction() {
        showUnRent(room);
    }
        public static void showUnRent(List< Room > room) {
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
}
