package example.application.service.booking;

import example.domain.model.booking.Booking;
import example.domain.model.cargo.Cargo;
import example.domain.model.voyage.Voyage;
import example.domain.model.type.Size;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BookingServiceTest {

    @Autowired
    BookingService bookingService;

    @Test
    @DisplayName("オーバーブッキング")
    void overBooking() {
        Size capacity = new Size(100);
        Voyage initial = Voyage.create(capacity);

        Voyage voyage = initial.addBooked(new Size(80));
        Size cargoSize = new Size(40);
        Cargo cargo = new Cargo(cargoSize);

        assertEquals(Booking.できない,
                bookingService.canBook(voyage, cargo));
    }
}