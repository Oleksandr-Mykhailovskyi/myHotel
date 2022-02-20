package com.example.demo.recepcja.strategy;

import com.example.demo.guest.Guest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ShowGuestsStrategy implements ReceptionStrategy{

    public List<Guest> guests;

    public ShowGuestsStrategy(List<Guest> guests){
        this.guests = guests;
    }

    @Override
    public void receptionAction() {
        deserializerGuest(guests);
    }

    public void deserializerGuest(List<Guest> guests) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("guests.dat"))) {
            guests = ((ArrayList<Guest>)ois.readObject());
        }
        catch(Exception e){}

        for(Guest p : guests)
            System.out.printf(p + "\n");
    }
}
