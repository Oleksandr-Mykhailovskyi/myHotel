package com.example.demo.guest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Guest implements Serializable {
    public String name;
    public String surname;
    public int age;
    public String idNumber;
    public int roomNumber;
    public LocalDate startRent;
    public LocalDate finishRent;

    public Guest(List<Guest> guests) {

        guests.add(GuestBuilder.createExampleGuest(2));
        guests.add(GuestBuilder.createExampleGuest(4));
        guests.add(GuestBuilder.createExampleGuest(6));
        guests.add(GuestBuilder.createExampleGuest(8));
        guests.add(GuestBuilder.createExampleGuest(9));
        guests.add(GuestBuilder.createExampleGuest(10));
        guests.add(GuestBuilder.createExampleGuest(12));
        guests.add(GuestBuilder.createExampleGuest(15));

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
