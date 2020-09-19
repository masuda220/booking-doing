package example.domain.model.type;

/**
 *　大きさ
 */
public class Size {
    int value;

    Size(int value) {
        this.value = value;
    }

    public Size add(Size other) {
        return new Size(value + other.value);
    }

    public Size subtract(Size other) {
        int result = value - other.value;
        if (result < 0) throw new IllegalArgumentException();
        return new Size(result);
    }

    public boolean isLargerThan(Size other) {
        return value > other.value;
    }

    public Size multiply(Percent percent) {
        int result = percent.of(value);
        return new Size(result);
    }

    public static Size of(int value) {
        if (value < 0) throw new IllegalArgumentException();
        return new Size(value);
    }

    public static Size ZERO = Size.of(0);

    @Override
    public String toString() {
        return "Size{" +
                "value=" + value +
                '}';
    }
}
