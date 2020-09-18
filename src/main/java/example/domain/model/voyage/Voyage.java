package example.domain.model.voyage;

import example.domain.model.booking.BookingPolicy;
import example.domain.model.type.Size;

import java.time.LocalDate;

/**
 * 航海
 */
public class Voyage {
    Origin origin;
    Destination destination;
    LocalDate departure;

    Size capacity;
    Size bookedTotal; // TODO CargoSetで集計する

    private Voyage(Size capacity, Size bookedSize) {
        this.capacity = capacity;
        this.bookedTotal = bookedSize;
    }

    // TODO Cargoセットへの変更
    public Voyage addBooked(Size booked) {
        return new Voyage(capacity, this.bookedTotal.add(booked));
    }

    // TODO BookingPolicy の適用
    public Size remains(BookingPolicy bookingPolicy) {
        return capacity.subtract(bookedTotal);
    }

    public static Voyage create(Size capacity) {
        Size booked = new Size(0);
        return new Voyage(capacity, booked);
    }
}