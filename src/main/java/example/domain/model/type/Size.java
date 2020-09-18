package example.domain.model.type;

/**
 *　容積
 */
public class Size {
    int value;

    public Size(int value) {
        this.value = value;
    }

    public Size add(Size other) {
        return new Size(value + other.value);
    }

    public Size subtract(Size other) {
        int result = value - other.value;
        if (result < 0) throw new IllegalArgumentException();
        return new Size(value - other.value);
    }

    public boolean isSmallerThan(Size other) {
        return value < other.value;
    }

    public int multiply(Percent percent) {
        return percent.of(value);
    }

    public static Size of(int value) {
        if (value < 0) throw new IllegalArgumentException();
        return new Size(value);
    }
}
