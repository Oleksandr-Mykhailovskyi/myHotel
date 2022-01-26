package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.example.demo.RoomBuilder.aRoom;

        @AllArgsConstructor
        @Data
        public class Room implements Serializable {

                private BigDecimal price;
                private LocalDate reservedFrom;
                private LocalDate reservedUntil;
                private int roomNumber;
                private int howManyRooms;
                private Boolean breakfast;
                private Boolean isFree;
                private Boolean isReady;



                protected Room(List<Room> rooms) {

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(850))
                                .withRoomNumber(1)
                                .withHowManyRooms(4)
                                .withBreakfast(true)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(800))
                                .withReservedFrom(LocalDate.of(2021, 05, 1))
                                .withReservedUntil(LocalDate.of(2021, 05, 21))
                                .withRoomNumber(2)
                                .withHowManyRooms(2)
                                .withBreakfast(true)
                                .withIsFree(false)
                                .withIsReady(false)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(250))
                                .withRoomNumber(3)
                                .withHowManyRooms(1)
                                .withBreakfast(false)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(550))
                                .withReservedFrom(LocalDate.of(2021, 05, 1))
                                .withReservedUntil(LocalDate.of(2021, 05, 22))
                                .withRoomNumber(4)
                                .withHowManyRooms(1)
                                .withBreakfast(true)
                                .withIsFree(false)
                                .withIsReady(false)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(12800))
                                .withRoomNumber(5)
                                .withHowManyRooms(8)
                                .withBreakfast(true)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(550))
                                .withReservedFrom(LocalDate.of(2021, 05, 1))
                                .withReservedUntil(LocalDate.of(2021, 05, 28))
                                .withRoomNumber(6)
                                .withHowManyRooms(3)
                                .withBreakfast(true)
                                .withIsFree(false)
                                .withIsReady(false)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(300))
                                .withRoomNumber(7)
                                .withHowManyRooms(1)
                                .withBreakfast(true)
                                .withIsFree(true)
                                .withIsReady(false)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(650))
                                .withReservedFrom(LocalDate.of(2021, 05, 1))
                                .withReservedUntil(LocalDate.of(2021, 05, 7))
                                .withRoomNumber(8)
                                .withHowManyRooms(2)
                                .withBreakfast(true)
                                .withIsFree(false)
                                .withIsReady(false)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(400))
                                .withReservedFrom(LocalDate.of(2021, 05, 1))
                                .withReservedUntil(LocalDate.of(2021, 05, 22))
                                .withRoomNumber(9)
                                .withHowManyRooms(1)
                                .withBreakfast(true)
                                .withIsFree(false)
                                .withIsReady(false)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(550)).
                                withReservedFrom(LocalDate.of(2021, 05, 1)).
                                withReservedUntil(LocalDate.of(2021, 05, 22)).
                                withRoomNumber(10).
                                withHowManyRooms(1).
                                withBreakfast(true).
                                withIsFree(false).
                                withIsReady(false).
                                build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(15000))
                                .withRoomNumber(11)
                                .withHowManyRooms(12)
                                .withBreakfast(true)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(550)).
                                withReservedFrom(LocalDate.of(2021, 05, 1)).
                                withReservedUntil(LocalDate.of(2021, 05, 26)).
                                withRoomNumber(12).
                                withHowManyRooms(1).
                                withBreakfast(false).
                                withIsFree(false).
                                withIsReady(false).
                                build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(250))
                                .withRoomNumber(13)
                                .withHowManyRooms(1)
                                .withBreakfast(false)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(400))
                                .withRoomNumber(14)
                                .withHowManyRooms(2)
                                .withBreakfast(false)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(600)).
                                withReservedFrom(LocalDate.of(2021, 05, 1)).
                                withReservedUntil(LocalDate.of(2021, 05, 22)).
                                withRoomNumber(15).
                                withHowManyRooms(3).
                                withBreakfast(true).
                                withIsFree(false).
                                withIsReady(false).
                                build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(450))
                                .withRoomNumber(16)
                                .withHowManyRooms(2)
                                .withBreakfast(true)
                                .withIsFree(true)
                                .withIsReady(false)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(700))
                                .withRoomNumber(17)
                                .withHowManyRooms(3)
                                .withBreakfast(false)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(250))
                                .withRoomNumber(18)
                                .withHowManyRooms(1)
                                .withBreakfast(false)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(350))
                                .withRoomNumber(19)
                                .withHowManyRooms(2)
                                .withBreakfast(false)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());

                        rooms.add(aRoom().withPrice(BigDecimal.valueOf(550))
                                .withRoomNumber(20)
                                .withHowManyRooms(3)
                                .withBreakfast(true)
                                .withIsFree(true)
                                .withIsReady(true)
                                .build());
                }

                public String toString(){
                        return
                                " | Numer Pokoju -> " + roomNumber +
                                        " | Cena -> " + price +
                                        "zł | Ilość miejsc -> " + howManyRooms +
                                        " | Sniadania są w cenie -> " + breakfast;
                }

                protected void showUnRent(List<Room> saveRooms) {
                        saveRooms.stream()
                                .filter(room -> room.getIsFree())
                                .filter(room -> room.getIsReady())
                                .forEach(room -> System.out.println(
                                        " | Numer Pokoju -> "+room.getRoomNumber()+
                                        " | Cena -> "+ room.getPrice() +
                                        "zł | Ilość miejsc -> "+room.getHowManyRooms()+
                                        " | Sniadania są w cenie -> "+room.getBreakfast())
                                );
                }

                protected void showRent(List<Room> saveRooms) {

                        saveRooms.stream()
                                .filter(room -> !room.getIsFree())
                                .filter(room -> !room.getIsReady())
                                .forEach(room -> System.out.println(
                                        " | Numer Pokoju -> "+room.getRoomNumber()+
                                        " | Cena -> "+ room.getPrice() +
                                        "zł | Ilość miejsc -> "+room.getHowManyRooms()+
                                        " | Sniadania są w cenie -> "+room.getBreakfast())
                                );
                }
        }
