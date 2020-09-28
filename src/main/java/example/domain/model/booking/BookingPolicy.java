package example.domain.model.booking;

import example.domain.model.type.Percent;
import example.domain.model.type.Size;

/**
 * *ブッキングポリシー
 */
public class BookingPolicy {
    Percent percent;

    BookingPolicy(Percent percent) {
        this.percent = percent;
    }

    public Size sizeMax(Size capacity) {
        Size extend = capacity.multiply(percent);
        return capacity.add(extend);
    }

    public static BookingPolicy of(int value) {
        return new BookingPolicy(new Percent(value));
    }

    @Override
    public String toString() {
        return "BookingPolicy{" +
                "percent=" + percent +
                '}';
    }
}
