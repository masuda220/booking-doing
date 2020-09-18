package example.domain.model.booking;

import example.domain.model.cargo.Cargo;
import example.domain.model.type.Size;
import example.domain.model.voyage.Voyage;

public class BookingContext {
    Voyage voyage;
    BookingPolicy bookingPolicy;
    Cargo cargo;

    public BookingContext(Voyage voyage, BookingPolicy bookingPolicy, Cargo cargo) {
        this.voyage = voyage;
        this.bookingPolicy = bookingPolicy;
        this.cargo = cargo;
    }

    public Booking canBook() {
        Size remains = voyage.remains(bookingPolicy);
        if (cargo.isSmallerThan(remains)) return Booking.できる;
        return Booking.できない;
    }
}
