package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Guest implements Serializable {
    protected String name;
    protected String surname;
    protected int age;
    protected String idNumber;
    protected int roomNumber;
    protected LocalDate startRent;
    protected LocalDate finishRent;

    protected Guest(List<Guest> guests) {

        GuestBuilder guestFactory = new GuestBuilder();

        guests.add(guestFactory.createExampleGuest(2));
        guests.add(guestFactory.createExampleGuest(4));
        guests.add(guestFactory.createExampleGuest(6));
        guests.add(guestFactory.createExampleGuest(8));
        guests.add(guestFactory.createExampleGuest(9));
        guests.add(guestFactory.createExampleGuest(10));
        guests.add(guestFactory.createExampleGuest(12));
        guests.add(guestFactory.createExampleGuest(15));

    }

    public String toString() {
        return
                "Name : " + name +
                        " | Surname : " + surname +
                        " | Age : " + age +
                        " | ID number : " + idNumber +
                        " | Rent room number : " + roomNumber +
                        " | Rent from " + startRent +
                        " | Rent to " + finishRent;
    }
}
