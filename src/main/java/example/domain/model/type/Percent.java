package example.domain.model.type;

public class Percent {
    public int value;

    public Percent(int value) {
        this.value = value;
    }

    public int of(int multiplier) {
        return ( multiplier * value ) / 100;
    }
}
