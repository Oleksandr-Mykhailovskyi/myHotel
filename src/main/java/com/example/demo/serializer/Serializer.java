package com.example.demo.serializer;

import com.example.demo.guest.Guest;
import com.example.demo.rooms.Room;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Serializer {

    public List<Room> saveRooms = new ArrayList<>();

    public void serializationForSave(List<Room> rooms) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("roomsForSave.dat"))) {

            oos.writeObject(saveRooms);
        }
        catch(Exception e){}
        if (saveRooms.size() == 0) {
            for (int i = 0; i < rooms.size(); i++) {
                saveRooms.add(rooms.get(i));
            }
        }
        this.saveRooms = rooms;
    }

    public void serializationGuest(List<Guest> serializerGuest) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("guests.dat"))) {

            oos.writeObject(serializerGuest);
        }
        catch (Exception e) {}
    }
}
