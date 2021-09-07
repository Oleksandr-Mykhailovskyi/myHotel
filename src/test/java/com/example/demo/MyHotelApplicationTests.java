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

	Reception reception = new Reception();

	@Test
	void checkHowManyDaysAndReturnBigDecimalPrice() {

		// given
		BigDecimal price = BigDecimal.valueOf(1600);
		int numberRoom = 1;
		List<Room> rooms = new ArrayList<>();
		rooms.add(new Room(BigDecimal.valueOf(850), null, null, 1, 4, true, true, true));
		rooms.add(new Room(BigDecimal.valueOf(800), LocalDate.of(2021, 05, 1), LocalDate.of(2021, 05, 21), 2, 2, true, false, false));
		rooms.add(new Room(BigDecimal.valueOf(250), null, null, 3, 1, false, true, true));
		// when
		String days = "2";
		InputStream in = new ByteArrayInputStream(days.getBytes());
		System.setIn(in);
		// then
		assertEquals(price, reception.dayPrice(rooms, numberRoom));
	}

}
