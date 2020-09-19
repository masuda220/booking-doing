package example.domain.model.type;

/**
 * 百分率
 */
public class Percent {
    public int value;

    public Percent(int value) {
        this.value = value;
    }

    public int of(int multiplier) {
        return ( multiplier * value ) / 100;
    }

    @Override
    public String toString() {
        return "Percent{" +
                "value=" + value +
                '}';
    }
}
