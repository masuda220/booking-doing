package example.application.service.booking;

import example.domain.model.booking.BookingNumber;
import example.domain.model.booking.Cargo;
import example.domain.model.booking.Voyage;
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
    BookingNumber booking(Voyage voyage, Cargo cargo) {

        // TODO ビジネスルールの明示（クラスを使って）
        // TODO ビジネスロジックの記述をdomain.modelに移動
        double maxBooking = voyage.capacity() * 1.1 ;
        if (voyage.bookedSize() + cargo.size() > maxBooking)
            throw new IllegalStateException("最大積載量オーバー");

        return BookingNumber.generate();
    }
}
