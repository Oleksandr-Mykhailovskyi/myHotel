package com.example.demo.deserializer;

import com.example.demo.guest.Guest;
import com.example.demo.rooms.Room;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserializer {

    public List<Room> saveRooms = new ArrayList<>();

    public void deserializerGuest(List<Guest> serializerGuest) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("guests.dat"))) {
            serializerGuest = ((ArrayList<Guest>)ois.readObject());
        }
        catch(Exception e){}

        for(Guest p : serializerGuest)
            System.out.printf(p + "\n");
    }

    public List<Room> deserializerForSave(List<Room> saveRooms) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("roomsForSave.dat"))) {

            saveRooms = ((ArrayList<Room>) ois.readObject());
        }
        catch(Exception e){}

        this.saveRooms = saveRooms;

        return saveRooms;
    }

    public List<Guest> serializerGuestForSave(List<Guest> guests, List<Guest> serializerGuest) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("guests.dat"))) {
            serializerGuest = ((ArrayList<Guest>) ois.readObject());
        }
        catch (Exception e) {}
        if (serializerGuest.size() == 0) {
            for (int i = 0; i < guests.size(); i++) {
                serializerGuest.add(guests.get(i));
            }
        }
        return serializerGuest;
    }
}
