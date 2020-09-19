package example.domain.model.voyage;

import example.domain.model.booking.Booking;
import example.domain.model.booking.BookingPolicy;
import example.domain.model.cargo.Cargo;
import example.domain.model.cargo.CargoSet;
import example.domain.model.route.Destination;
import example.domain.model.route.Origin;
import example.domain.model.route.Route;
import example.domain.model.type.Size;

import java.time.LocalDate;

/**
 * 航海
 */
public class Voyage {
    Route route;
    LocalDate departure;

    BookingPolicy bookingPolicy;
    Size capacity;
    CargoSet cargoSet;

    private Voyage(Size capacity, BookingPolicy bookingPolicy, CargoSet cargoSet) {
        this.capacity = capacity;
        this.bookingPolicy = bookingPolicy;
        this.cargoSet = cargoSet;
    }

    public Voyage addCargo(Cargo cargo) {
        CargoSet result = cargoSet.addCargo(cargo);
        return new Voyage(capacity, bookingPolicy, result);
    }

    public Booking canBook(Cargo cargo) {
        Size max = bookingPolicy.sizeMax(capacity);
        Size remains = max.subtract(cargoSet.total());
        if (cargo.isLargerThan(remains)) return Booking.できない;
        return Booking.できる;
    }

    public static Voyage create(Size capacity, BookingPolicy bookingPolicy) {
        return new Voyage(capacity,bookingPolicy, CargoSet.EMPTY);
    }

    @Override
    public String toString() {
        return "Voyage{" +
                ", bookingPolicy=" + bookingPolicy +
                ", capacity=" + capacity +
                ", cargoSet=" + cargoSet +
                '}';
    }
}