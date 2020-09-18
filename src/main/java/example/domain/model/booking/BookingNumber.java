package example.domain.model.booking;

import java.util.UUID;

/**
 * 予約番号
 */
public class BookingNumber {
    UUID number;

    public BookingNumber(UUID number) {
        this.number = number;
    }

    public static BookingNumber generate() {
        return new BookingNumber(UUID.randomUUID());
    }
}
