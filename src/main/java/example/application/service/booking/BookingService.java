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

    // TODO コマンドとクエリーの分離

    /**
     * 限度を超えていなかったら予約して予約番号を返す
     * @param voyage
     * @param cargo
     * @return
     */
    Booking canBook(Voyage voyage, Cargo cargo) {

        BookingContext bookingContext = new BookingContext(
                voyage, new BookingPolicy(), cargo);
        return bookingContext.canBook();
    }
    BookingNumber booking(Voyage voyage, Cargo cargo) {
        return BookingNumber.generate();
    }
}
