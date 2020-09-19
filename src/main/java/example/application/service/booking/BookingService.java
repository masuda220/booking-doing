package example.application.service.booking;

import example.domain.model.booking.*;
import example.domain.model.cargo.Cargo;
import example.domain.model.voyage.Voyage;
import org.springframework.stereotype.Service;

/**
 * 予約
 */
@Service
public class BookingService {

    /**
     * 予約可能か確認する
     */
    Booking canBook(Voyage voyage, Cargo cargo) {
        return voyage.canBook(cargo);
    }

    /**
     * 予約を記録して、予約番号を返す
     */
    BookingNumber booking(Voyage voyage, Cargo cargo) {
        // ToDo 予約を記録する
        return BookingNumber.generate();
    }
}
