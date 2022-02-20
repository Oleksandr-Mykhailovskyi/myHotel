//package com.example.demo;
//
//import com.example.demo.rooms.Room;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//public class RoomBuilder {
//    private BigDecimal price = BigDecimal.valueOf(0);
//    private LocalDate reservedFrom = null;
//    private LocalDate reservedUntil = null;
//    private int roomNumber = 0;
//    private int howManyRooms = 0;
//    private Boolean breakfast = false;
//    private Boolean isFree = false;
//    private Boolean isReady = false;
//
//    private RoomBuilder() {
//    }
//
//    public static com.example.demo.rooms.RoomBuilder aRoom() {
//        return new com.example.demo.rooms.RoomBuilder();
//    }
//
//    public com.example.demo.rooms.RoomBuilder withPrice(BigDecimal price) {
//        this.price = price;
//        return this;
//    }
//
//    public com.example.demo.rooms.RoomBuilder withReservedFrom(LocalDate reservedFrom) {
//        this.reservedFrom = reservedFrom;
//        return this;
//    }
//
//    public com.example.demo.rooms.RoomBuilder withReservedUntil(LocalDate reservedUntil) {
//        this.reservedUntil = reservedUntil;
//        return this;
//    }
//
//    public com.example.demo.rooms.RoomBuilder withRoomNumber(int roomNumber) {
//        this.roomNumber = roomNumber;
//        return this;
//    }
//
//    public com.example.demo.rooms.RoomBuilder withHowManyRooms(int howManyRooms) {
//        this.howManyRooms = howManyRooms;
//        return this;
//    }
//
//    public com.example.demo.rooms.RoomBuilder withBreakfast(Boolean breakfast) {
//        this.breakfast = breakfast;
//        return this;
//    }
//
//    public com.example.demo.rooms.RoomBuilder withIsFree(Boolean isFree) {
//        this.isFree = isFree;
//        return this;
//    }
//
//    public com.example.demo.rooms.RoomBuilder withIsReady(Boolean isReady) {
//        this.isReady = isReady;
//        return this;
//    }
//
//    public Room build() {
//        Room rooms = new Room(null,  null,   null, 0, 0, null, null, null);
//        rooms.setPrice(price);
//        rooms.setReservedFrom(reservedFrom);
//        rooms.setReservedUntil(reservedUntil);
//        rooms.setRoomNumber(roomNumber);
//        rooms.setHowManyRooms(howManyRooms);
//        rooms.setBreakfast(breakfast);
//        rooms.setIsFree(isFree);
//        rooms.setIsReady(isReady);
//        return rooms;
//    }
//}
