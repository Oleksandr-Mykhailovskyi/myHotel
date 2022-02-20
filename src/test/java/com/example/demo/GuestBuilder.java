package com.example.demo;

import com.example.demo.guest.Guest;

import java.time.LocalDate;

public class GuestBuilder {

    public Guest createExampleGuest(int roomNumber) {
        Guest guest = new Guest("Adam", "Baranowski",32,"81031536647",0, LocalDate.now(),LocalDate.now().plusDays(2));

        guest.setRoomNumber(roomNumber);

        return guest;
    }
}
