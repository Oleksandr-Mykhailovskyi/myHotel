package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MyHotelApplicationTests {

	protected Reception reception = new Reception();

	@Test
	protected void correctUserNumberRoomReturnInteger() {

		// given
		// when
		String value = "1";
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// theString value = "1";
		//		InputStream in = new ByteArrayInputStream(value.getBytes());
		//		System.setIn(in);
		//		// then
		//		assertEquals(1, reception.getNumber());n
		assertEquals(1, reception.getNumber());
	}

	@Test
	protected void correctUserNameReturnString() {

		// given
		// when
		String value = "Alex";
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals("Alex", reception.checkName());
	}

	@Test
	protected void correctUserSurnameReturnString() {

		// given
		// when
		String value = "Tarna";
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals("Tarna", reception.checkSurname());
	}

	@Test
	protected void correctUserAgeReturnInteger() {

		// given
		// when
		String value = "21";
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals(21, reception.checkUserAge());
	}

	@Test
	protected void correctUserIdNumberReturnString() {

		// given
		// when
		String value = "11111111111";
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals("11111111111", reception.checkIdNumber());
	}

	@Test
	protected void correctUserRoomChoiceReturnInteger() {

		// given
		List<Room> saverooms = new ArrayList<>();
		saverooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		saverooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		saverooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		Room room = new Room(saverooms);
		// when
		String value = "1";
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals(0, reception.roomChoice(saverooms, room));
	}

	@Test
	protected void returnCorrectUserDayPriceLikeBigDecimalPrice() {

		// given
		List<Room> saverooms = new ArrayList<>();
		saverooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		saverooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		saverooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		// when
		String value = "3";
		int numberRoom = 1;
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals(BigDecimal.valueOf(2400), reception.dayPrice(saverooms, numberRoom));
	}

	@Test
	protected void returnCorrectUserBreakfastLikeBigDecimalPrice() {

		// given
		List<Room> saverooms = new ArrayList<>();
		saverooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		saverooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		saverooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		// when
		String value = "tak";
		int numberRoom = 2;
		String days = "3";
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals(BigDecimal.valueOf(400), reception.breakfastPrice(saverooms, numberRoom, days));
	}

	@Test
	protected void returnCorrectUserVoucher30LikeBigDecimalPrice() {

		// given
		List<Room> saverooms = new ArrayList<>();
		saverooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		saverooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		saverooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		// when
		String value = "SUPER_HOTEL";
		int numberRoom = 2;
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals(BigDecimal.valueOf(175), reception.voucher(saverooms, numberRoom));
	}

	@Test
	protected void returnCorrectUserVoucher20LikeBigDecimalPrice() {

		// given
		List<Room> saverooms = new ArrayList<>();
		saverooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		saverooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		saverooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		// when
		String value = "MEGA_HOTEL";
		int numberRoom = 2;
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals(BigDecimal.valueOf(200), reception.voucher(saverooms, numberRoom));
	}

	@Test
	protected void returnCorrectUserVoucher10LikeBigDecimalPrice() {

		// given
		List<Room> saverooms = new ArrayList<>();
		saverooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		saverooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		saverooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		// when
		String value = "EXTRA_HOTEL";
		int numberRoom = 2;
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);
		// then
		assertEquals(BigDecimal.valueOf(225), reception.voucher(saverooms, numberRoom));
	}

	@Test
	protected void returnCorrectVoucherForRegularCostumerLikeBigDecimalPrice() {

		// given
		List<Guest> seriaGuest = new ArrayList<>();
		seriaGuest.add(new Guest("Adam", "Baranowski", 32, "81031536647", 2, LocalDate.now(), LocalDate.now().plusDays(2)));
		seriaGuest.add(new Guest("Amelia", "Adams", 25, "95061732268", 4, LocalDate.now(), LocalDate.now().plusDays(1)));
		seriaGuest.add(new Guest("Michał", "Michałowski", 30, "90120180097", 6, LocalDate.now(), LocalDate.now().plusDays(4)));
		List<Room> saverooms = new ArrayList<>();
		saverooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		saverooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		saverooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		// when
		String idNumber = "81031536647";
		int numberRoom = 2;
		// then
		assertEquals(BigDecimal.valueOf(225), reception.regularCostumer(numberRoom, seriaGuest, idNumber, saverooms));
	}

	@Test
	protected void returnCorrectAddNewGuest() {

		// given
		List<Guest> seriaGuest = new ArrayList<>();
		seriaGuest.add(new Guest("Adam", "Baranowski", 32, "81031536647", 2, LocalDate.now(), LocalDate.now().plusDays(2)));
		seriaGuest.add(new Guest("Amelia", "Adams", 25, "95061732268", 4, LocalDate.now(), LocalDate.now().plusDays(1)));
		seriaGuest.add(new Guest("Michał", "Michałowski", 30, "90120180097", 6, LocalDate.now(), LocalDate.now().plusDays(4)));
		// when
		String userName = "Alex";
		String userSurname = "Tarna";
		Integer userAge = 21;
		String userIdNumber = "11111111111";
		int numberRoom = 1;
		LocalDate dateOn = LocalDate.now();
		LocalDate dateOff = LocalDate.now().plusDays(1);
		Guest guest = new Guest(userName, userSurname, userAge, userIdNumber, numberRoom + 1, dateOn, dateOff);
		// then
		assertEquals(guest, reception.addNewGuest(userName, userSurname, userAge, userIdNumber, numberRoom, dateOn, dateOff));
	}

	@Test
	protected void returnReservedRoom() {

		// given
		List<Room> saverooms = new ArrayList<>();
		saverooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		saverooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		saverooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		// when
		int numberRoom = 0;
		String days = "1";
		Room room = new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, false, false);
		// then
		assertEquals(room, reception.reservedRoom(numberRoom, saverooms, days));
	}
}
