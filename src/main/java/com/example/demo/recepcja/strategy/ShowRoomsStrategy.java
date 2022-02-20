package com.example.demo.recepcja.strategy;

import com.example.demo.rooms.Room;

import java.util.List;

public class ShowRoomsStrategy implements ReceptionStrategy{

    private List<Room> rooms;

    public ShowRoomsStrategy(List<Room> rooms) { this.rooms = rooms; }

    @Override
    public void receptionAction() {
        showRooms(rooms);
    }

    public List<Room> showRooms(List<Room> rooms) {
        rooms.stream()
                .forEach(room -> System.out.println(
                        " | Numer Pokoju -> " + room.getRoomNumber() +
                                " | Cena -> " + room.getPrice() + "zł | Ilość miejsc -> " + room.getHowManyRooms() +
                                " | Sniadania są w cenie -> " + room.getBreakfast())
                );
        return rooms;
    }
}
