package example.application.service.booking;

import example.domain.model.booking.Booking;
import example.domain.model.booking.BookingPolicy;
import example.domain.model.cargo.Cargo;
import example.domain.model.type.Size;
import example.domain.model.voyage.Voyage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookingServiceTest {

    @Autowired
    BookingService bookingService;

    @ParameterizedTest
    @MethodSource("arguments")
    @DisplayName("オーバーブッキング")
    void overBooking(
            Booking expected, BookingPolicy bookingPolicy, Size capacity,
            Size booked, Size toBook) {
        Voyage initial = Voyage.create(capacity,bookingPolicy);
        Cargo bookedCargo = new Cargo(booked);
        Voyage voyage = initial.addCargo(bookedCargo);
        System.out.println(voyage);
        Cargo toBookCargo = new Cargo(toBook);

        assertEquals(expected, bookingService.canBook(voyage, toBookCargo));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
            Arguments.of(
                Booking.できる, BookingPolicy.of(10), Size.of(100),
                    Size.of(80), Size.of(30)),
            Arguments.of(
                Booking.できない, BookingPolicy.of(10), Size.of(100),
                Size.of(80), Size.of(31))
        );
    }
}