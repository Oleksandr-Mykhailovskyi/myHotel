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
		String value = "1";
		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		int expected = 1;
		// then
		assertEquals(expected, reception.getNumber());
	}

	@Test
	protected void correctUserNameReturnString() {

		// given
		String value = "Alex";
		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		String expected = "Alex";
		// then
		assertEquals(expected, reception.checkName());
	}

	@Test
	protected void correctUserSurnameReturnString() {

		// given
		String value = "Tarna";
		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		String expected = "Tarna";
		// then
		assertEquals(expected, reception.checkSurname());
	}

	@Test
	protected void correctUserAgeReturnInteger() {

		// given
		String value = "21";
		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		int expected = 21;
		// then
		assertEquals(expected, reception.checkUserAge());
	}

	@Test
	protected void correctUserIdNumberReturnString() {

		// given
		String value = "11111111111";
		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		String id = "11111111111";
		// then
		assertEquals("11111111111", reception.checkIdNumber());
	}

	@Test
	protected void returnCorrectUserDayPriceLikeBigDecimalPrice() {

		// given
		String value = "3";
		int numberRoom = 0;
		List<Room> room = new ArrayList<>();

		room.add(RoomBuilder
				.aRoom()
				.withPrice(BigDecimal.valueOf(850))
				.build());

		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		BigDecimal expected = BigDecimal.valueOf(2550);

		// then
		assertEquals(expected, reception.dayPrice(room, numberRoom));
	}

	@Test
	protected void returnCorrectUserBreakfastLikeBigDecimalPrice() {

		// given
		String value = "tak";
		int numberRoom = 0;
		String days = "3";

		List<Room> room = new ArrayList<>();

		room.add(RoomBuilder.aRoom().withPrice(BigDecimal.valueOf(850)).withBreakfast(false).build());

		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		BigDecimal expected = BigDecimal.valueOf(1000);

		// then
		assertEquals(expected, reception.breakfastPrice(room, numberRoom, days));
	}

	@Test
	protected void returnCorrectUserVoucher30LikeBigDecimalPrice() {

		// given
		String value = "SUPER_HOTEL";
		int numberRoom = 0;

		List<Room> room = new ArrayList<>();

		room.add(RoomBuilder.aRoom().withPrice(BigDecimal.valueOf(850)).build());

//		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		BigDecimal expected = BigDecimal.valueOf(595);

//		// then
		assertEquals(expected, reception.voucher(room, numberRoom));
	}

	@Test
	protected void returnCorrectUserVoucher20LikeBigDecimalPrice() {

		// given
		String value = "MEGA_HOTEL";
		int numberRoom = 0;

		List<Room> room = new ArrayList<>();

		room.add(RoomBuilder.aRoom().withPrice(BigDecimal.valueOf(850)).build());

		// when
		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		BigDecimal expected = BigDecimal.valueOf(680);
		// then
		assertEquals(expected, reception.voucher(room, numberRoom));
	}

	@Test
	protected void returnCorrectUserVoucher10LikeBigDecimalPrice() {

		// given
		String value = "EXTRA_HOTEL";
		int numberRoom = 0;

		List<Room> room = new ArrayList<>();

		room.add(RoomBuilder.aRoom().withPrice(BigDecimal.valueOf(850)).build());

		InputStream in = new ByteArrayInputStream(value.getBytes());
		System.setIn(in);

		// when
		BigDecimal expected = BigDecimal.valueOf(765);
		// then
		assertEquals(expected, reception.voucher(room, numberRoom));
	}

	@Test
	protected void returnCorrectVoucherForRegularCostumerLikeBigDecimalPrice() {

		// given
		String idNumber = "81031536647";
		int numberRoom = 0;

		List<Guest> guest = new ArrayList<>();

		guest.add(new GuestBuilder().createExampleGuest(2));

		List<Room> room = new ArrayList<>();

		room.add(RoomBuilder
				.aRoom()
				.withPrice(BigDecimal.valueOf(850))
				.withReservedFrom(null)
				.withReservedUntil(null)
				.withHowManyRooms(1)
				.withRoomNumber(2)
				.withBreakfast(true)
				.withIsFree(true)
				.withIsReady(true)
				.build());

		// when
		BigDecimal expected = BigDecimal.valueOf(765);

		// then
		assertEquals(expected, reception.regularCostumer(numberRoom, guest, idNumber, room));
	}

	@Test
	protected void returnCorrectAddNewGuest() {

		// given
		String userName = "Adam";
		String userSurname ="Baranowski";
		Integer userAge = 32;
		String userIdNumber ="81031536647";
		int numberRoom = 1;
		LocalDate dateOn = LocalDate.now();
		LocalDate dateOff = LocalDate.now().plusDays(2);

		// when
		Guest expected = new Guest("Adam", "Baranowski",32,"81031536647",2, LocalDate.now(),LocalDate.now().plusDays(2));

		// then
		assertEquals(expected, reception.addNewGuest(userName, userSurname, userAge, userIdNumber, numberRoom, dateOn, dateOff));
	}

	@Test
	protected void returnReservedRoom() {

		// given
		int numberRoom = 0;
		String days = "2";

		List<Room> room = new ArrayList<>();

		room.add(RoomBuilder
				.aRoom()
				.withPrice(BigDecimal.valueOf(850))
				.withReservedFrom(null)
				.withReservedUntil(null)
				.withHowManyRooms(1)
				.withRoomNumber(1)
				.withBreakfast(true)
				.withIsFree(true)
				.withIsReady(true)
				.build());

		// when
		// then
		assertEquals(room.get(0), reception.reservedRoom(numberRoom, room, days));
	}
}
