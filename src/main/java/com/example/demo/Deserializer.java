package com.example.demo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserializer {

    protected List<Room> saveRooms = new ArrayList<>();

    protected void deserializerGuest(List<Guest> serializerGuest) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("guests.dat"))) {
            serializerGuest = ((ArrayList<Guest>)ois.readObject());
        }
        catch(Exception e){}

        for(Guest p : serializerGuest)
            System.out.printf(p + "\n");
    }

    protected List<Room> deserializerForSave(List<Room> saveRooms) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("roomsForSave.dat"))) {

            saveRooms = ((ArrayList<Room>) ois.readObject());
        }
        catch(Exception e){}

        this.saveRooms = saveRooms;

        return saveRooms;
    }

    protected List<Guest> serializerGuestForSave(List<Guest> guests, List<Guest> serializerGuest) {

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
