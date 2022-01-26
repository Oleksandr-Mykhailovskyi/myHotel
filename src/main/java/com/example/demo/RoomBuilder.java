package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class RoomBuilder {
    private BigDecimal price;
    private LocalDate reservedFrom;
    private LocalDate reservedUntil;
    private int roomNumber;
    private int howManyRooms;
    private Boolean breakfast;
    private Boolean isFree;
    private Boolean isReady;

    private RoomBuilder() {
    }

    public static RoomBuilder aRoom() {
        return new RoomBuilder();
    }

    public RoomBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public RoomBuilder withReservedFrom(LocalDate reservedFrom) {
        this.reservedFrom = reservedFrom;
        return this;
    }

    public RoomBuilder withReservedUntil(LocalDate reservedUntil) {
        this.reservedUntil = reservedUntil;
        return this;
    }

    public RoomBuilder withRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public RoomBuilder withHowManyRooms(int howManyRooms) {
        this.howManyRooms = howManyRooms;
        return this;
    }

    public RoomBuilder withBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
        return this;
    }

    public RoomBuilder withIsFree(Boolean isFree) {
        this.isFree = isFree;
        return this;
    }

    public RoomBuilder withIsReady(Boolean isReady) {
        this.isReady = isReady;
        return this;
    }

    public Room build() {
        Room room = new Room(null);
        room.setPrice(price);
        room.setReservedFrom(reservedFrom);
        room.setReservedUntil(reservedUntil);
        room.setRoomNumber(roomNumber);
        room.setHowManyRooms(howManyRooms);
        room.setBreakfast(breakfast);
        room.setIsFree(isFree);
        room.setIsReady(isReady);
        return room;
    }
}
